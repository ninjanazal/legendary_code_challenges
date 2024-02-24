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
}
