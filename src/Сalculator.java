import java.io.IOException;
import java.util.Scanner;

public class Сalculator {

    private static boolean isRoman = false;
    private static String num1 = "";
    private static String num2 = "";
    private static char sign;

    public static void startCalculate() throws Exception {
        input();
    }
    private static void input() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] stringArray = inputLine.split(" ");

        if (stringArray.length != 3) {
            throw new IOException("Формат математической операции не удовлетворяет заданию. Калькудятор работает для " +
                    "двух переменных");
        }

        num1 = stringArray[0];
        num2 = stringArray[2];
        sign = stringArray[1].toCharArray()[0];

        check();
    }

    private static void check() throws Exception {
        if (sign != '+' && sign != '-' && sign != '/' && sign != '*') {
            throw new IOException("Калькулятор умеет выполнять операции сложения, вычитания, умножения и " +
                    "целочисленного деления. Используйте правильный арифметический оператор");
        }

        if (isItArabicNum(num1) && isItArabicNum(num2)) {
            calculate();
        } else if (!isItArabicNum(num1) && !isItArabicNum(num2)) {
            isRoman = true;
            calculate();
        } else {
            throw new IOException("Используются одновременно разные системы счисления. Введите 2 числа одной " +
                    "системы счисления");
        }
    }

    private static boolean isItArabicNum(String num) {
        int x = 0;
        try {
            x = Integer.parseInt(num);
        } catch (NumberFormatException e1) {
            try {
                double d = Double.valueOf(num);
                throw new IOException("Калькулятор умеет работать только с целыми числами");
            } catch (NumberFormatException e2) {
                return false;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    private static void calculate() throws Exception {
        int number1 = 0;
        int number2 = 0;
        try {
            number1 = Integer.parseInt(num1);
            number2 = Integer.parseInt(num2);
        } catch (NumberFormatException e) {
            number1 = RomanNumeralConverter.convertFromRoman(num1);
            number2 = RomanNumeralConverter.convertFromRoman(num2);
        }

        if (number1 <= 0 || number1 > 10) {
            throw new IOException("Первое число не в нужном диаппазоне. Введите число от 1 до 10 включительно");
        }
        if (number2 <= 0 || number2 > 10) {
            throw new IOException("Второе число не в нужном диаппазоне. Введите число от 1 до 10 включительно");
        }

        int result = -11111;
        switch (sign) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
        }

        if (isRoman) {
            if (result > 0) {
                System.out.println(RomanNumeralConverter.convertToRoman(result, 10));
            } else {
                throw new Exception("В римской системе нет отрицательных чисел");
            }

        } else {
            System.out.println(result);
        }
    }
}
