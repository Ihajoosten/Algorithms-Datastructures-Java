public class RecursiveReverseString {

    public static void main(String[] args) {
        System.out.println(reverse("abc")); // returns cba
    }

    public static String reverse(String s) {

        if(s.length() > 0) {
            char lastLetter = s.charAt(s.length() - 1);
            String firstPartOfString = s.substring(0, s.length() - 1);

            return lastLetter + reverse(firstPartOfString);
        } else {
            return "";
        }
    }
}

