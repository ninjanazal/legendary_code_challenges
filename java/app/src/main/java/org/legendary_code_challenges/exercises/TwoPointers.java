package org.legendary_code_challenges.exercises;

import java.util.*;

public class TwoPointers {

  /*
   * [125. Valid Palindrome]
   * A phrase is a palindrome if, after converting all uppercase letters into
   * lowercase letters and removing all non-alphanumeric characters, it reads the
   * same forward and backward. Alphanumeric characters include letters and
   * numbers.
   * 
   * Given a string s, return true if it is a palindrome, or false otherwise.
   */
  public static boolean isPalindrome(String s) {
    s = s.replaceAll("[^a-zA-Z0-9]", "");
    s = s.toLowerCase();

    if (s.length() == 0) {
      return true;
    }

    for (int i = 0; i < s.length(); i++) {
      int rI = s.length() - 1 - i;
      if (s.charAt(i) != s.charAt(rI)) {
        return false;
      }
    }
    return true;
  }

  /*
   * [167. Two Sum II - Input Array Is Sorted]
   * Given a 1-indexed array of integers numbers that is already sorted in
   * non-decreasing order, find two numbers such that they add up to a specific
   * target number. Let these two numbers be numbers[index1] and numbers[index2]
   * where 1 <= index1 < index2 <= numbers.length.
   * 
   * Return the indices of the two numbers, index1 and index2, added by one as an
   * integer array [index1, index2] of length 2.
   * 
   * The tests are generated such that there is exactly one solution. You may not
   * use the same element twice.
   * 
   * Your solution must use only constant extra space.
   */
  public static int[] twoSum(int[] numbers, int target) {
    int lPoint = 0;
    int rPoint = numbers.length - 1;
    while (lPoint < rPoint) {
      int result = numbers[lPoint] + numbers[rPoint];

      if (result == target) {
        return new int[] { lPoint + 1, rPoint + 1 };
      } else if (result > target) {
        rPoint--;
      } else {
        lPoint++;
      }
    }

    return new int[2];
  }
}
