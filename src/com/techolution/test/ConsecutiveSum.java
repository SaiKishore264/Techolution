package com.techolution.test;

import java.util.Scanner;
import java.util.InputMismatchException;
public class ConsecutiveSum {
	 public static void main(String[] args) {
		 
		 
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Please Enter a Number"); 
	        try {
	        		long number = scanner.nextLong();	           
		         System.out.print(sumOfConsecutive(number));
	        }
	        catch(InputMismatchException e) {
                System.out.println("Invalid choice please try again"); 
            }    
	    }
	    static long sumOfConsecutive(long number) {
	    	
	        long numberOfPossibleWays = 0;
	        if (number == 1) {
	            return 1;
	        }
	        
	        long end = (number + 1) / 2;
	        for (long start = 1; start < end; start++) {

	            long sumOfConsecutiveNumbers = 0;
	            for (long i = start; i <= end; i++) {

	                sumOfConsecutiveNumbers += i;

	                if (sumOfConsecutiveNumbers == number) {
	                    numberOfPossibleWays++;
	                    break;
	                }

	                
	                if (sumOfConsecutiveNumbers > number)
	                    break;
	            }
	        }
	        return numberOfPossibleWays;
	    }

}
