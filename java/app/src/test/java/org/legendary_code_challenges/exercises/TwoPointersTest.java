package org.legendary_code_challenges.exercises;

import org.junit.jupiter.api.Test;
import org.legendary_code_challenges.tools.Assertions;

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

  // [167. Two Sum II - Input Array Is Sorted]
  @Test
  void twoSumTest() {
    assertTrue(Arrays.equals(new int[] { 1, 2 }, TwoPointers.twoSum(new int[] { 2, 7, 11, 15 }, 9)),
        "Failed on Example 1");
    assertTrue(Arrays.equals(new int[] { 1, 3 }, TwoPointers.twoSum(new int[] { 2, 3, 4 }, 6)), "Failed on Example 2");
    assertTrue(Arrays.equals(new int[] { 1, 2 }, TwoPointers.twoSum(new int[] { -1, 0 }, -1)), "Failed on Example 3");
  }

  // [15. 3Sum]
  @Test
  void threeSumTest() {
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(new Integer[] { -1, -1, 2 }));
    expected.add(Arrays.asList(new Integer[] { -1, 0, 1 }));

    List<List<Integer>> output = TwoPointers.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
    assertTrue(Assertions.containeUNestedList(expected, output), "Failed on Example 1");

    expected.clear();
    output = TwoPointers.threeSum(new int[] { 0, 1, 1 });
    assertTrue(Assertions.containeUNestedList(expected, output), "Failed on Example 2");

    expected.add(Arrays.asList(new Integer[] { 0, 0, 0 }));
    output = TwoPointers.threeSum(new int[] { 0, 0, 0 });
    assertTrue(Assertions.containeUNestedList(expected, output), "Failed on Example 3");

    expected.clear();
    expected.add(Arrays.asList(new Integer[] { 0, 0, 0 }));
    output = TwoPointers.threeSum(new int[] { 0, 0, 0, 0 });
    assertTrue(expected.size() == output.size(), "Failed on size on submission 1");
    assertTrue(Assertions.containeUNestedList(expected, output), "Failed on submission 1");

    expected.clear();
    expected.add(Arrays.asList(new Integer[] { -2, 0, 2 }));
    expected.add(Arrays.asList(new Integer[] { -2, 1, 1 }));

    output = TwoPointers.threeSum(new int[] { -2, 0, 1, 1, 2 });
    assertTrue(expected.size() == output.size(), "Failed on size on submission 2");
    assertTrue(Assertions.containeUNestedList(expected, output), "Failed on submission 2");
  }
}
