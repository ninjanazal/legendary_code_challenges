package org.legendary_code_challenges.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.legendary_code_challenges.exercises.tools.*;

import java.lang.reflect.Array;
import java.util.*;

public class ArrayAndHashingTest {
	// [217. Contains Duplicate]
	@Test
	void containsDuplicateTest() {
		assertTrue(ArrayAndHashing.containsDuplicate(new int[] { 1, 2, 3, 1 }), "Failded on Example 1");
		assertFalse(ArrayAndHashing.containsDuplicate(new int[] { 1, 2, 3, 4 }), "Failed on Example 2");
		assertTrue(ArrayAndHashing.containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }),
				"Failded on Example 3");
	}

	// [242. Valid Anagram]
	@Test
	void isAnagramTest() {
		assertTrue(ArrayAndHashing.isAnagram("anagram", "nagaram"), "Failed on Example 1");
		assertFalse(ArrayAndHashing.isAnagram("rat", "car"), "Failed on Example 2");
	}

	// [1. Two Sum]
	@Test
	void twoSumTest() {
		assertTrue(Arrays.equals(new int[] { 0, 1 }, ArrayAndHashing.twoSum(new int[] { 2, 7, 11, 15 }, 9)),
				"Failed on Exemple 1");
		assertTrue(Arrays.equals(new int[] { 1, 2 }, ArrayAndHashing.twoSum(new int[] { 3, 2, 4 }, 6)),
				"Failed on Exemple 2");
		assertTrue(Arrays.equals(new int[] { 0, 1 }, ArrayAndHashing.twoSum(new int[] { 3, 3 }, 6)),
				"Failed on Exemple 3");
		assertTrue(Arrays.equals(new int[] { 2, 4 }, ArrayAndHashing.twoSum(new int[] { -1, -2, -3, -4, -5 }, -8)),
				"Failed on Submission test");
	}

	// [49. Group Anagrams]
	@Test
	void groupAnagramsTest() {
		// Exemple 1
		List<List<String>> expectedResult = new ArrayList<List<String>>();
		expectedResult.add(Arrays.asList(new String[] { "bat" }));
		expectedResult.add(Arrays.asList(new String[] { "nat", "tan" }));
		expectedResult.add(Arrays.asList(new String[] { "ate", "eat", "tea" }));

		List<List<String>> output = ArrayAndHashing
				.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });

		assertTrue(Assertions.<String>containeUNestedList(expectedResult, output), "Failed on Example 1");

		// Exemple 2
		expectedResult.clear();
		expectedResult.add(Arrays.asList(new String[] { "" }));

		output = ArrayAndHashing.groupAnagrams(new String[] { "" });
		assertTrue(Assertions.<String>containeUNestedList(expectedResult, output), "Failed on Example 2");

		// Exemple 3
		expectedResult.clear();
		expectedResult.add(Arrays.asList(new String[] { "a" }));

		output = ArrayAndHashing.groupAnagrams(new String[] { "a" });
		assertTrue(Assertions.<String>containeUNestedList(expectedResult, output), "Failed on Example 3");
	}

	// [347. Top K Frequent Elements]
	@Test
	void topKFrequentTest() {
		assertTrue(Arrays.equals(new int[] { 1, 2 }, ArrayAndHashing.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2)),
				"Failed on Example 1");

		assertTrue(Arrays.equals(new int[] { 1 }, ArrayAndHashing.topKFrequent(new int[] { 1 }, 1)),
				"Failed on Example 2");

		assertTrue(Arrays.equals(new int[] { -1 }, ArrayAndHashing.topKFrequent(new int[] { -1, -1 }, 1)),
				"Failed on Submission test");

		int[] expected = new int[] { 2, -1 };
		Arrays.sort(expected);
		int[] result = ArrayAndHashing.topKFrequent(new int[] { 4, 1, -1, 2, -1, 2, 3 }, 2);
		Arrays.sort(result);

		assertTrue(Arrays.equals(expected, result), "Failed on Submission test 2");
	}
}