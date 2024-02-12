package org.legendary_code_challenges.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayAndHashingTest {
  @Test
  void containsDuplicateTest() {
    assertTrue(ArrayAndHashing.containsDuplicate(new int[] { 1, 2, 3, 1 }), "Failded on Example 1:\n" +
        "\n" +
        "Input: nums = [1,2,3,1]\n" +
        "Output: true");

    assertFalse(ArrayAndHashing.containsDuplicate(new int[] { 1, 2, 3, 4 }), "Failed on Example 2:\n" +
        "Input: nums = [1,2,3,4]\n" + //
        "Output: false");

    assertTrue(ArrayAndHashing.containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }),
        "Failded on Example 3:\n" +
            "\n" +
            "Input: nums = [1,1,1,3,3,4,3,2,4,2]\n" +
            "Output: true");
  }

  @Test
  void isAnagramTest() {
    assertTrue(ArrayAndHashing.isAnagram("anagram", "nagaram"), "Failed on Example 1:\n" +
        "Input: s = \"anagram\", t = \"nagaram\"\n" +
        "Output: true");

    assertFalse(ArrayAndHashing.isAnagram("rat", "car"), "Failed on Example 2:\n" +
        "Input: s = \"rat\", t = \"car\"\n" +
        "Output: false"
        );
  }
}