public class DecimalToBinary {

    public static void main(String[] args) {
        decimalToBinary(20);
    }

    public static void decimalToBinary(int num) {
        if (num > 0) {
            System.out.print(num % 2);
            decimalToBinary(num / 2);
        }
    }
}
