import java.util.HashMap;

public class RomanNumeralConverter {

    private static HashMap<Integer, String> hm = RomanSymbols.getHm();
    public static int convertFromRoman(String romanNumerals) {
        StringBuilder sb = new StringBuilder(romanNumerals);

        int sum = 0;
        if (sb.length() == 1)
            sum = romanCharToArabicNum(sb.charAt(0));
        for (int i = 0; i < sb.length() - 1; i++) {
            int j = i + 1;

            char chI = sb.charAt(i);
            char chJ = sb.charAt(j);
            int arabicNumI = romanCharToArabicNum(chI);
            int arabicNumJ = romanCharToArabicNum(chJ);

            if (arabicNumI >= arabicNumJ) {
                sum += arabicNumI;
                if (j == sb.length() - 1)
                    sum++;
            } else {
                sum += (arabicNumJ - arabicNumI);
            }
        }
        return sum;
    }

    public static String convertToRoman(int arabicNum, int num) {
        if (arabicNum == 0)
            return "";
        int numToConvert = arabicNum % num;
        StringBuilder sb = new StringBuilder(convertToRoman(arabicNum-numToConvert, num * 10));
        if (hm.containsKey(numToConvert)) {
            sb.append(hm.get(numToConvert));
        }
        return sb.toString();
    }

    private static int romanCharToArabicNum(char ch) {
        if (ch == RomanSymbols.I.getRomanChar()) {
            return RomanSymbols.I.getArabicNum();
        } else if (ch == RomanSymbols.V.getRomanChar()) {
            return RomanSymbols.V.getArabicNum();
        } else if (ch == RomanSymbols.X.getRomanChar()){
            return RomanSymbols.X.getArabicNum();
        } else if (ch == RomanSymbols.L.getRomanChar()){
            return RomanSymbols.L.getArabicNum();
        } else if (ch == RomanSymbols.C.getRomanChar()){
            return RomanSymbols.C.getArabicNum();
        } else if (ch == RomanSymbols.D.getRomanChar()){
            return RomanSymbols.D.getArabicNum();
        } else if (ch == RomanSymbols.M.getRomanChar()){
            return RomanSymbols.M.getArabicNum();
        }
        return 0;
    }

}
