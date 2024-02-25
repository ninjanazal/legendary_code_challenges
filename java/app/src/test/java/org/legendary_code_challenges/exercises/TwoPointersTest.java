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

  @Test
  void twoSumTest() {
    assertTrue(Arrays.equals(new int[] { 1, 2 }, TwoPointers.twoSum(new int[] { 2, 7, 11, 15 }, 9)),
        "Failed on Example 1");
    assertTrue(Arrays.equals(new int[] { 1, 3 }, TwoPointers.twoSum(new int[] { 2, 3, 4 }, 6)), "Failed on Example 2");
    assertTrue(Arrays.equals(new int[] { 1, 2 }, TwoPointers.twoSum(new int[] { -1, 0 }, -1)), "Failed on Example 3");
  }
}
