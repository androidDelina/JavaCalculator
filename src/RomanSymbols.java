import java.util.HashMap;

public enum RomanSymbols {
    I('I', 1), V('V', 5),
    X('X', 10), L('L', 50),
    C('C', 100), D ('D', 500),
    M ('M', 1000);

    private final int arabicNum;
    private final char romanChar;

    private static HashMap<Integer, String> hm = new HashMap<>();

    public int getArabicNum() {
        return arabicNum;
    }

    public char getRomanChar() {
        return romanChar;
    }

    RomanSymbols(char romanChar, int arabicNum) {
        this.romanChar = romanChar;
        this.arabicNum = arabicNum;
    }

    public static HashMap<Integer, String> getHm() {
        hm.put(1, "I");
        hm.put(2, "II");
        hm.put(3, "III");
        hm.put(4, "IV");
        hm.put(5, "V");
        hm.put(6, "VI");
        hm.put(7, "VII");
        hm.put(8, "VIII");
        hm.put(9, "IX");

        hm.put(10, "X");
        hm.put(20, "XX");
        hm.put(30, "XXX");
        hm.put(40, "XL");
        hm.put(50, "L");
        hm.put(60, "LX");
        hm.put(70, "LXX");
        hm.put(80, "LXXX");
        hm.put(90, "XC");

        hm.put(100, "C");
        hm.put(200, "CC");
        hm.put(300, "CCC");
        hm.put(400, "CD");
        hm.put(500, "D");
        hm.put(600, "DC");
        hm.put(700, "DCC");
        hm.put(800, "DCCC");
        hm.put(900, "CM");

        hm.put(1000, "M");
        hm.put(2000, "MM");
        hm.put(3000, "MMM");

        return hm;
    }
}
