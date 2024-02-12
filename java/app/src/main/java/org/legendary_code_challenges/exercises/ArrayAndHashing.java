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
}
