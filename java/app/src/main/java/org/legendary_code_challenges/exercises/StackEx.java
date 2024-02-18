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
}
