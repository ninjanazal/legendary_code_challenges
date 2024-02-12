package org.legendary_code_challenges.exercises;

import java.util.*;

public class ArrayAndHashing {
  /*
   * [217. Contains
   * Duplicate](https://leetcode.com/problems/contains-duplicate/description/)
   * Given an integer array nums, return true if any value appears at least twice
   * in the array,
   * and return false if every element is distinct.
   */
  public static boolean containsDuplicate(int[] nums) {
    HashSet<Integer> unique = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (unique.contains(nums[i])) {
        return true;
      }
      unique.add(nums[i]);
    }
    return false;
  }

  /*
   * [242. Valid
   * Anagram](https://leetcode.com/problems/valid-anagram/description/)
   * Given two strings s and t, return true if t is an anagram of s, and false
   * otherwise.
   * An Anagram is a word or phrase formed by rearranging the letters of a
   * different word or phrase,
   * typically using all the original letters exactly once.
   */
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    char[] sChars = s.toCharArray();
    Arrays.sort(sChars);
    char[] tChars = t.toCharArray();
    Arrays.sort(tChars);

    for (int i = 0; i < sChars.length; i++) {
      if (sChars[i] != tChars[i]) {
        return false;
      }
    }

    return true;
  }
}
