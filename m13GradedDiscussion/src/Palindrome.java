public class Palindrome {
    String palindrome;

    public Palindrome (String palindrome) {
        this.palindrome = palindrome;
    }

    public boolean isPalindrome() {
        for (int i = 0; i < palindrome.length(); i++) {
            if (palindrome.charAt(i) != palindrome.charAt(palindrome.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
