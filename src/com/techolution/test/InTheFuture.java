package com.techolution.test;

import java.util.Scanner;

public class InTheFuture {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ashaProblemsPerDay = scanner.nextInt();
        int kellyProblemsPerDay = scanner.nextInt();
        int numberOfProblemsAshaAheadOfKelly = scanner.nextInt();

        int minimumNumberOfDays = minNum(
                ashaProblemsPerDay,
                kellyProblemsPerDay,
                numberOfProblemsAshaAheadOfKelly
        );
        System.out.print(minimumNumberOfDays);
    }

    static int minNum(int ashaProblemsPerDay,
                      int kellyProblemsPerDay,
                      int numberOfProblemsAshaAheadOfKelly) {
        if (isInValidateInput(ashaProblemsPerDay, kellyProblemsPerDay, numberOfProblemsAshaAheadOfKelly)) {
            return -1;
        }
        
        if (ashaProblemsPerDay >= kellyProblemsPerDay) {
            return -1;
        }
        int numberOfDays = 1;
        int totalNumberOfProblemsOfAshaPerDay = ashaProblemsPerDay + numberOfProblemsAshaAheadOfKelly;
        int totalNumberOfProblemsOfKellyPerDay = kellyProblemsPerDay;
        while (totalNumberOfProblemsOfKellyPerDay <= totalNumberOfProblemsOfAshaPerDay) {
            totalNumberOfProblemsOfAshaPerDay += ashaProblemsPerDay;
            totalNumberOfProblemsOfKellyPerDay += kellyProblemsPerDay;
            numberOfDays++;
        }

        return numberOfDays;
    }

    private static boolean isInValidateInput(
    		int ashaProblemsPerDay,
        int kellyProblemsPerDay,
        int numberOfProblemsAshaAheadOfKelly) {
       
        if ((1 <= ashaProblemsPerDay && ashaProblemsPerDay <= 100) &&
                (1 <= kellyProblemsPerDay && kellyProblemsPerDay <= 100) &&
                (0 <= numberOfProblemsAshaAheadOfKelly && numberOfProblemsAshaAheadOfKelly <= 100)) {
            return false;
        }
        return true;
    }
}
