public class NumberConverter2 {

    public static int hexToDecimal(String hex) {
        return Integer.parseInt(hex, 16);
    }

    // Binär zu Dezimal
    public static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    // Oktal zu Dezimal
    public static int octalToDecimal(String octal) {
        return Integer.parseInt(octal, 8);
    }

    // Dezimal zu Hexadezimal
    public static String decimalToHex(int decimal) {
        return Integer.toHexString(decimal).toUpperCase();
    }

    // Dezimal zu Binär
    public static String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    // Dezimal zu Oktal
    public static String decimalToOctal(int decimal) {
        return Integer.toOctalString(decimal);
    }

}
