package org.legendary_code_challenges.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackExTest {
  @Test
  void isValidTest() {
    assertTrue(StackEx.isValid("()"), "Failed on Example 1");
    assertTrue(StackEx.isValid("()[]{}"), "Failed on Example 2");
    assertFalse(StackEx.isValid("(]"), "Failed on Example 3");

    assertFalse(StackEx.isValid("]"), "Failed on Submission");
    assertFalse(StackEx.isValid("["), "Failed on Submission 2");

  }
}
