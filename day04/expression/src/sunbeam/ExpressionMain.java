/*******************************************************************
* Java Code: ExpressionMain.java
* Date: 04-Jan-2021
* Course: Sep 2020 Batch at Sunbeam Infotech
* Module: Data Structures and Algorithms
* Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
*******************************************************************/

package sunbeam;

import java.util.Stack;

public class ExpressionMain {
	public static int calc(int a, int b, char operator) {
		switch (operator) {
			case '$': return (int)Math.pow(a, b);
			case '*': return a * b;
			case '/': return a / b;
			case '%': return a % b;
			case '+': return a + b;
			case '-': return a - b;
		}
		return 0;
	}
	public static int solvePostfix(String post) {
		// stack of operands
		Stack<Integer> s = new Stack<Integer>();
		// traverse postfix from left to right
		for (int i = 0; i < post.length(); i++) {
			// get each sym from expression
			char sym = post.charAt(i);
			// if sym is operand
			if(Character.isDigit(sym)) {
				// convert it to int & push on stack
				// e.g. '5' -toString()-> "5" -parseInt()-> 5 
				String operand = Character.toString(sym);
				s.push(Integer.parseInt(operand));
			} else {
				// pop two operands from stack
				int b = s.pop();
				int a = s.pop();
				// calculate the result
				int c = calc(a, b, sym);
				// push result on stack
				s.push(c);
			}
		}// repeat for all syms in expression
		// pop final result from stack and return.
		return s.pop();
	}
	public static void main(String[] args) {
		String postfix = "59+4862/-*-173-$+";
		int result = solvePostfix(postfix);
		System.out.println("Result: " + result);
	}
}
