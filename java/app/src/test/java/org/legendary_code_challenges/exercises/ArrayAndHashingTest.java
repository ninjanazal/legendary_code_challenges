package org.legendary_code_challenges.exercises;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import org.legendary_code_challenges.tools.*;

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

	// [238. Product of Array Except Self]
	@Test
	void productExceptSelf() {
		assertTrue(Arrays.equals(new int[] { 24, 12, 8, 6 }, ArrayAndHashing.productExceptSelf(new int[] { 1, 2, 3, 4 })),
				"Failed on Exemple 1");

		assertTrue(
				Arrays.equals(new int[] { 0, 0, 9, 0, 0 }, ArrayAndHashing.productExceptSelf(new int[] { -1, 1, 0, -3, 3 })),
				"Failed on Exemple 2");

	}

	// [36. Valid Sudoku]
	@Test
	void isValidSudokuTest() {
		char[][] board = new char[][] {
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' }
		};

		assertTrue(ArrayAndHashing.isValidSudoku(board), "Failed on Example 1");

		board = new char[][] {
				{ '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' }
		};

		assertFalse(ArrayAndHashing.isValidSudoku(board), "Failed on Example 2");
	}

	// [128. Longest Consecutive Sequence]
	@Test
	void longestConsecutiveTest() {
		assertEquals(4, ArrayAndHashing.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }), "Failed on Example 1");
		assertEquals(9, ArrayAndHashing.longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }),
				"Failed on Example 2");

	}
}