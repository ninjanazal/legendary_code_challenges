package org.legendary_code_challenges.exercises;

import java.util.*;

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
			int[] data = new int[]{val, val};
			
			if(!stkPair.isEmpty()){
				int[] prev = stkPair.getLast();
				data[1] = val <  prev[1] ? val : prev[1];
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
}
