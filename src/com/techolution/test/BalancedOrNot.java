package com.techolution.test;

import java.util.Scanner;
import java.util.Stack;


public class BalancedOrNot {

	  public static void main(String[] args) {
	        
	        Scanner scanner = new Scanner(System.in);
	        int numberOfExpressions = scanner.nextInt();

	        String[] expressions = new String[numberOfExpressions];
	        for (int i = 0; i < numberOfExpressions; i++) {
	            expressions[i] = scanner.next();
	        }

	        /*
	            Scanning maxReplacements
	         */
	        int maxReplacementsNumber = scanner.nextInt();
	        int[] maxReplacements = new int[maxReplacementsNumber];
	        for (int i = 0; i < numberOfExpressions; i++) {
	            maxReplacements[i] = scanner.nextInt();
	        }

	        int[] result = balancedOrNot(expressions, maxReplacements);

	        for (int i = 0; i < result.length; i++) {
	            System.out.println(result[i]);
	        }
	    }

	    static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
	        int[] result = new int[expressions.length];
	        String replaceValue = ">";
	        int replacementCounter;
	        for (int i = 0; i < expressions.length; i++) {
	            replacementCounter = 0;
	            String expression = expressions[i];
	            int replacement = maxReplacements[i];
	            result[i] = isBalancedOrNot(replacementCounter, expression, replaceValue, replacement);
	        }
	        return result;
	    }

	    static int isBalancedOrNot(int replacementCounter, String expression, String replaceValue, int replacement) {

	        int openCount = 0;
	        int closeCount = 0;
	        String res;

	        if (isBalanced(expression)) {
	            return 1;
	        }

	        String[] brackets = expression.split("");
	        for (String bracket : brackets) {
	            if (replaceValue.equals(bracket)) {
	                closeCount++;
	            } else {
	                openCount++;
	            }
	        }

	     
	        if (closeCount > openCount) {
	            res = expression.replaceFirst(">", "<>");
	            replacementCounter++;
	            if (replacementCounter <= replacement) {
	                return isBalancedOrNot(replacementCounter, res, replaceValue, replacement);
	            }
	        }
	       
	        return 0;
	    }

	    private static boolean isBalanced(String expression) {
	        
	        if ((expression.length() % 2) != 0) {
	            return false;
	        } else {
	           
	            String[] brackets = expression.split("");
	            Stack<String> stack = new Stack<>();
	            for (String bracket : brackets) {
	                switch (bracket) {
	                    case "<":
	                        stack.push(">");
	                        break;
	                    default:
	                        if (stack.empty() || !bracket.equalsIgnoreCase(stack.peek())) {
	                            return false;
	                        }
	                        stack.pop();
	                }
	            }
	            return stack.empty();
	        }
	    }

}
