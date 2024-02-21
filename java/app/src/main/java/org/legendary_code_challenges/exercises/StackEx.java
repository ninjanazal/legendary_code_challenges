package org.legendary_code_challenges.exercises;

import java.util.*;
import java.util.function.BinaryOperator;

public class StackEx {

	/*
	 * [20. Valid Parentheses]
	 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * An input string is valid if:
	 * 
	 * - Open brackets must be closed by the same type of brackets.
	 * - Open brackets must be closed in the correct order.
	 * - Every close bracket has a corresponding open bracket of the same type.
	 */
	public static boolean isValid(String s) {
		HashMap<Character, Character> outSet = new HashMap<>() {
			{
				put(')', '(');
				put(']', '[');
				put('}', '{');
			}
		};

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);

			if (!outSet.keySet().contains(currChar)) {
				stack.push(currChar);
			} else {
				if (stack.empty()) {
					return false;
				}

				char last = stack.pop();
				if (last != outSet.get(currChar)) {
					return false;
				}
			}
		}
		return stack.empty();
	}

	/*
	 * [155. Min Stack]
	 * Design a stack that supports push, pop, top, and retrieving the minimum
	 * element in constant time.
	 * 
	 * Implement the MinStack class:
	 * - MinStack() initializes the stack object.
	 * - void push(int val) pushes the element val onto the stack.
	 * - void pop() removes the element on the top of the stack.
	 * - int top() gets the top element of the stack.
	 * - int getMin() retrieves the minimum element in the stack.
	 * - You must implement a solution with O(1) time complexity for each function.
	 * 
	 * 
	 */
	public class MinStack {
		private ArrayList<int[]> stkPair;

		public MinStack() {
			stkPair = new ArrayList<int[]>();
		}

		public void push(int val) {
			int[] data = new int[] { val, val };

			if (!stkPair.isEmpty()) {
				int[] prev = stkPair.getLast();
				data[1] = val < prev[1] ? val : prev[1];
			}
			stkPair.add(data);
		}

		public void pop() {
			stkPair.removeLast();
		}

		public int top() {
			return stkPair.getLast()[0];
		}

		public int getMin() {
			return stkPair.getLast()[1];
		}
	}

	/*
	 * [150. Evaluate Reverse Polish Notation]
	 * You are given an array of strings tokens that represents an arithmetic
	 * expression in a Reverse Polish Notation.
	 * 
	 * Evaluate the expression. Return an integer that represents the value of the
	 * expression.
	 * 
	 * Note that:
	 * 
	 * - The valid operators are '+', '-', '*', and '/'.
	 * - Each operand may be an integer or another expression.
	 * - The division between two integers always truncates toward zero.
	 * - There will not be any division by zero.
	 * - The input represents a valid arithmetic expression in a reverse polish
	 * notation.
	 * - The answer and all the intermediate calculations can be represented in a
	 * 32-bit integer.
	 */
	public static int evalRPN(String[] tokens) {
		HashMap<String, BinaryOperator<Integer>> operators = new HashMap<String, BinaryOperator<Integer>>() {
			{
				put("+", (lOp, rOP) -> lOp + rOP);
				put("-", (lOp, rOP) -> lOp - rOP);
				put("*", (lOp, rOP) -> lOp * rOP);
				put("/", (lOp, rOP) -> Math.divideExact(lOp, rOP));
			}
		};

		Stack<Integer> opStack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];
			if (operators.keySet().contains(token)) {
				int rOp = opStack.pop();
				int lOp = opStack.pop();

				opStack.push(operators.get(token).apply(lOp, rOp));
			} else {
				opStack.push(Integer.parseInt(token));
			}
		}

		return opStack.pop();
	}

	/*
	 * [22. Generate Parentheses]
	 * Given n pairs of parentheses, write a function to generate all combinations
	 * of well-formed parentheses.
	 */
	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		parenthesisRecursion(result, 0, 0, n, "");
		return result;
	}

	private static void parenthesisRecursion(List<String> collection, int lCoun, int rCount, int total, String build) {
		if (lCoun == rCount && lCoun == total) {
			collection.add(build);
			return;
		}

		if (lCoun < total) {
			parenthesisRecursion(collection, lCoun + 1, rCount, total, build.concat("("));
		}

		if (rCount < lCoun) {
			parenthesisRecursion(collection, lCoun, rCount + 1, total, build.concat(")"));
		}
	}
}
