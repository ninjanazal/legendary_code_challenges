package org.legendary_code_challenges.exercises;

import java.util.*;

public class ArrayAndHashing {
  /*
   * [217. Contains Duplicate]
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
   * [242. Valid Anagram]
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

  /*
   * [1. Two Sum]
   * Given an array of integers nums and an integer target, return indices of the
   * two numbers such that they add up to target.
   * You may assume that each input would have exactly one solution, and you may
   * not use the same element twice.
   * You can return the answer in any order.
   */

  public static int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      int remain = target - nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == remain) {
          return new int[] { i, j };
        }
      }
    }
    return new int[0];
  }

  /*
   * [49. Group Anagrams]
   * Given an array of strings strs, group the anagrams together. You can return
   * the answer in any order.
   * An Anagram is a word or phrase formed by rearranging the letters of a
   * different word or phrase,
   * typically using all the original letters exactly once.
   */
  public static List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> dataMap = new HashMap<>();
    for (String textData : strs) {
      char[] sChars = textData.toCharArray();
      Arrays.sort(sChars);
      String key = new String(sChars);

      if (!dataMap.containsKey(key)) {
        dataMap.put(key, new ArrayList<String>());
      }
      dataMap.get(key).add(textData);
    }

    List<List<String>> result = new ArrayList<>();
    for (Map.Entry<String, List<String>> set : dataMap.entrySet()) {
      result.add(set.getValue());
    }

    return result;
  }

  /*
   * [347. Top K Frequent Elements]
   * Given an integer array nums and an integer k, return the k most frequent
   * elements.
   * You may return the answer in any order.
   */
  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> dataMap = new HashMap<>();

    for (int i : nums) {
      if (!dataMap.containsKey(i)) {
        dataMap.put(i, 1);
      } else {
        dataMap.put(i, dataMap.get(i) + 1);
      }
    }

    List<Integer> entryList = new ArrayList<>(dataMap.keySet());
    entryList.sort((a, b) -> dataMap.get(b) - dataMap.get(a));

    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = (entryList.get(i));
    }

    return result;
  }

  /*
   * [238. Product of Array Except Self]
   * Given an integer array nums, return an array answer such that answer[i] is
   * equal to the product of all the elements of nums except nums[i].
   * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
   * integer.
   * You must write an algorithm that runs in O(n) time and without using the
   * division operation.
   */
  public static int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    int[] lCalc = new int[nums.length];
    Arrays.fill(lCalc, 1);

    for (int i = 1; i < nums.length; i++) {
      lCalc[i] = nums[i - 1] * lCalc[i - 1];
    }

    result[nums.length - 1] = lCalc[nums.length - 1];

    int rAccumulator = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      rAccumulator *= nums[i + 1];
      result[i] = lCalc[i] * rAccumulator; 
    }
    return result;
  }
}
