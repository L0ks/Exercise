package com.unit;
import com.component.Palindrome;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PalindromeMethodTest {
    private Palindrome palindrome;

    @Before
    public void setup() {
        palindrome = new Palindrome(195);
    }

    @Test
    public void palindromeMethodCheck() {
        Assert.assertEquals("Palindrome result does not match the expected value",
                9339,
                palindrome.getPalindrome());
    }

    @Test
    public void iterationCheck() {
        Assert.assertEquals("Palindrome result does not match the expected value",
                9339,
                palindrome.getPalindrome());

        Assert.assertEquals(
                "Number of expected iterations does match the expected value",
                4,
                palindrome.getIterations());
    }

    @Test
    public void palindromeValueCheck(){
        Assert.assertTrue(
                "Palindrome value check does not match the expected result",
                palindrome.isPalindrome(191));
    }

    @Test
    public void reverseMethodCheck(){
        Assert.assertEquals(
                "Integer reverse function output does not match the expected result",
                321,
                palindrome.reverseNumber(123));
    }

}
