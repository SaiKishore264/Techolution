package com.techolution.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PsychometricTesting {

	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfScores = scanner.nextInt();
        int[] scores = new int[numberOfScores];
        for (int i = 0; i < numberOfScores; i++) {
            scores[i] = scanner.nextInt();
        }
        int numberOfLowerLimits = scanner.nextInt();
        int[] lowerLimits = new int[numberOfLowerLimits];
        for (int i = 0; i < numberOfLowerLimits; i++) {
            lowerLimits[i] = scanner.nextInt();
        }
        int numberOfUpperLimits = scanner.nextInt();
        int[] upperLimits = new int[numberOfUpperLimits];
        for (int i = 0; i < numberOfUpperLimits; i++) {
            upperLimits[i] = scanner.nextInt();
        }

        int[] result = jobOffers(scores, lowerLimits, upperLimits);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    static int[] jobOffers(int[] scores,
                           int[] lowerLimits,
                           int[] upperLimits) {
        List<Integer> numberOfScoresInclusiveOfLimitsList = new ArrayList<>();
        for (int i = 0; i < lowerLimits.length; i++) {
            int numberOfScoresInclusiveOfLimits = 0;
            for (int score : scores) {
                if (lowerLimits[i] <= score && score <= upperLimits[i]) {
                    numberOfScoresInclusiveOfLimits++;
                }
            }
            numberOfScoresInclusiveOfLimitsList.add(numberOfScoresInclusiveOfLimits);
        }
        return convertToArray(numberOfScoresInclusiveOfLimitsList);
    }

    private static int[] convertToArray(List<Integer> numberOfScoresInclusiveOfLimitsList) {
        int[] result = new int[numberOfScoresInclusiveOfLimitsList.size()];
        for (int i = 0; i < numberOfScoresInclusiveOfLimitsList.size(); i++) {
            result[i] = numberOfScoresInclusiveOfLimitsList.get(i);
        }
        return result;
    }
}
