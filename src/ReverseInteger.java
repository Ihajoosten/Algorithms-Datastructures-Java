public class ReverseInteger {
    // signature: public static void int insideOut(int n)
    // example: insideOut(137) retourneert 731
    public static void main(String[] args) {
        System.out.println(insideOut(1234)); // returns 4321
    }

    // driver
    // use a static variable; ugly, but simple
    static int res = 0;
    public static int insideOut(int n) {
        res = 0;
        insideOut_(n);
        return res;
    }

    // recursive method
    public static void insideOut_(int n) {
        if(n > 0) {
            res *= 10;
            res += n%10;
            insideOut_(n/10);
        }
    }

}
