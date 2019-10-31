public class BinaryToDecimal {
    public static void main(String[] args) {
        System.out.println(binaryToDecimal("1101"));
    }

    public static int binaryToDecimal(String value) {
        int length = value.length();
        if (length == 1) return Integer.parseInt(value);
        else
            return binaryToDecimal(value.substring(1, length)) + Integer.parseInt(value.substring(0, 1)) * (int) Math.pow(2, length - 1);
    }
}
