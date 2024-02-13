package org.legendary_code_challenges.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

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
                "Output: false");
    }

    @Test
    void twoSumTest() {
        assertTrue(Arrays.equals(new int[] { 0, 1 }, ArrayAndHashing.twoSum(new int[] { 2, 7, 11, 15 }, 9)),
                "Failed on Exemple 1:\n" +
                        "Output: [0,1] \n" +
                        "Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].");

        assertTrue(Arrays.equals(new int[] { 1, 2 }, ArrayAndHashing.twoSum(new int[] { 3, 2, 4 }, 6)),
                "Failed on Exemple 2:\n" +
                        "Input: nums = [3,2,4], target = 6\n" +
                        "Output: [1,2]");

        assertTrue(Arrays.equals(new int[] { 0, 1 }, ArrayAndHashing.twoSum(new int[] { 3, 3 }, 6)),
                "Failed on Exemple 3:\n" +
                        "Input: nums = [3,3], target = 6\n" +
                        "Output: [0,1]");

        assertTrue(Arrays.equals(new int[] {2, 4}, ArrayAndHashing.twoSum(new int[] {-1,-2,-3,-4,-5}, -8)),
        "Failed on Submission test");
    }
}