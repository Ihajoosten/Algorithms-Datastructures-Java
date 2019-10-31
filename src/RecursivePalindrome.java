public class RecursivePalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abbc")); // returns false
        System.out.println(isPalindrome("abb")); // returns false
        System.out.println(isPalindrome("a")); // returns true
        System.out.println(isPalindrome("")); // returns true
        System.out.println(isPalindrome("abba")); // returns true
    }

    private static boolean isPalindrome(String str) {
        // Empty or single char returns true
        int length = str.length();
        if(length <= 1) return true;

        // Get first and last character
        char a = str.charAt(0), b = str.charAt(length - 1);
        if(a == b) {
            // Substring for next recursion
            // reversing characters
            String substr = str.substring(1, length - 1);
            // call recursion to determine if it is palindrome
            return isPalindrome(substr);
        }
        return false;
    }
}
