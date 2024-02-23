package org.legendary_code_challenges.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;;

public class StackExTest {
  @Test
  void isValidTest() {
    assertTrue(StackEx.isValid("()"), "Failed on Example 1");
    assertTrue(StackEx.isValid("()[]{}"), "Failed on Example 2");
    assertFalse(StackEx.isValid("(]"), "Failed on Example 3");

    assertFalse(StackEx.isValid("]"), "Failed on Submission");
    assertFalse(StackEx.isValid("["), "Failed on Submission 2");

  }

  // [155. Min Stack]
  @Test
  void MinStackTest() {
    StackEx.MinStack minStack = (new StackEx()).new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);

    assertEquals(-3, minStack.getMin(), "Failed on Example getMin");
    minStack.pop();
    assertEquals(0, minStack.top(), "Failed on Example top");
    assertEquals(-2, minStack.getMin(), "Failed on Example getMin 2");
  }

  // [150. Evaluate Reverse Polish Notation]
  @Test
  void evalRPNTest() {
    assertEquals(9, StackEx.evalRPN(new String[] { "2", "1", "+", "3", "*" }), "Failed on Example 1");
    assertEquals(6, StackEx.evalRPN(new String[] { "4", "13", "5", "/", "+" }), "Failed on Example 2");
    assertEquals(22,
        StackEx.evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }),
        "Failed on Example 3");

  }

  // [22. Generate Parentheses]
  @Test
  void generateParenthesisTest() {
    assertTrue(Arrays.asList(new String[] { "((()))", "(()())", "(())()", "()(())", "()()()" })
        .equals(StackEx.generateParenthesis(3)), "Failed on Example 1");

    assertTrue(Arrays.asList(new String[] { "()" })
        .equals(StackEx.generateParenthesis(1)), "Failed on Example 2");
  }

  // [739. Daily Temperatures]
  @Test
  void dailyTemperaturesTest() {
    assertTrue(Arrays.equals(new int[] { 1, 1, 4, 2, 1, 1, 0, 0 },
        StackEx.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })), "Failed on Example 1");
    assertTrue(Arrays.equals(new int[] { 1, 1, 1, 0 },
        StackEx.dailyTemperatures(new int[] { 30, 40, 50, 60 })), "Failed on Example 2");
    assertTrue(Arrays.equals(new int[] { 1, 1, 0 },
        StackEx.dailyTemperatures(new int[] { 30, 60, 90 })), "Failed on Example 2");
  }

  // [853. Car Fleet]
  @Test
  void carFleetTest() {
    assertEquals(3, StackEx.carFleet(12, new int[] { 10, 8, 0, 5, 3 }, new int[] { 2, 4, 1, 1, 3 }),
        "Failed on Example 1");

    assertEquals(1, StackEx.carFleet(10, new int[] { 3 }, new int[] { 3 }),
        "Failed on Example 2");
    assertEquals(1, StackEx.carFleet(100, new int[] { 0, 2, 4 }, new int[] { 4, 2, 1 }),
        "Failed on Example 3");

    assertEquals(2, StackEx.carFleet(10, new int[] { 6, 8 }, new int[] { 3, 2 }),
        "Failed on Submission 1");
  }
}
