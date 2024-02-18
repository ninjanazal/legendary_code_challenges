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

  @Test
  void MinStackTest(){
    StackEx.MinStack minStack = (new StackEx()).new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);

    assertEquals(-3, minStack.getMin(), "Failed on Example getMin");
    minStack.pop();
    assertEquals(0, minStack.top(), "Failed on Example top");
    assertEquals(-2, minStack.getMin(), "Failed on Example getMin 2");
  }
}
