import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {

    @Test
    public void isPalindrome() {
        Palindrome string1 = new Palindrome("racecar");
        assertTrue(string1.isPalindrome());
    }

    @Test
    public void isNotPalindrome() {
        Palindrome string1 = new Palindrome("racercar");
        assertFalse(string1.isPalindrome());
    }
}