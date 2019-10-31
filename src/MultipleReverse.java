public class MultipleReverse {

    // signature: public String multipleReverse(String)
    // example: multipleReverse("abcd") retourneert "ddddcccbba"
    public static void main(String[] args) {
        System.out.println(multipleReverse("abc")); // returns cccbba
    }

    // driver
    // use a static variable; ugly, but simple
    static String result = "";
    public static String multipleReverse(String s) {
        result = "";
        multipleReverse(s, 1);
        return result;
    }

    // recursive method
    public static void multipleReverse(String s, int n) {
        if(s.length() > 0) {
            for(int i=0; i<n; i++) {
                result = s.substring(0,1) + result;
            }
            multipleReverse(s.substring(1), ++n);
        }

    }

}
