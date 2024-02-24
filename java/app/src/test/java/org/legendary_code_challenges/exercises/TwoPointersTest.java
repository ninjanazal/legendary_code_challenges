package org.legendary_code_challenges.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;;

public class TwoPointersTest {
  // [125. Valid Palindrome]
  @Test
  void isPalindromeTest() {
    assertEquals(true, TwoPointers.isPalindrome("A man, a plan, a canal: Panama"), "Failed on Example 1");
    assertEquals(false, TwoPointers.isPalindrome("race a car"), "Failed on Example 2");
    assertEquals(true, TwoPointers.isPalindrome(" "), "Failed on Example 3");
  }
}
