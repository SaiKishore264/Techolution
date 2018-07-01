package com.techolution.test;

import java.util.Scanner;

public class BuyingShowTickets {

	public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfMembers = scanner.nextInt();
        int[] memberTicketsCountArray = new int[numberOfMembers];
        for (int i = 0; i < numberOfMembers; i++) {
            int numberOfTickets = scanner.nextInt();
            memberTicketsCountArray[i] = numberOfTickets;
        }
        int position = scanner.nextInt();
        long waitingTime = waitingTime(memberTicketsCountArray, position);

        System.out.println(waitingTime);
    }

    static long waitingTime(int[] memberTicketsCountArray, int jessiePosition) {
        long waitingTimeForJessie = 0;
        int memberToBeServed = 0;
        int[] differenceTicketsCounterArray = new int[memberTicketsCountArray.length];
        int i = 0;
        while (i < memberTicketsCountArray.length) {
            differenceTicketsCounterArray[i] = memberTicketsCountArray[i] - memberTicketsCountArray[jessiePosition];
            i++;
        }

        while (memberToBeServed < memberTicketsCountArray.length) {
            if (differenceTicketsCounterArray[memberToBeServed] < 0) {
                waitingTimeForJessie += memberTicketsCountArray[memberToBeServed];
            } else {
                if (memberToBeServed > jessiePosition) {
                    waitingTimeForJessie += memberTicketsCountArray[jessiePosition] - 1;
                } else {
                    waitingTimeForJessie += memberTicketsCountArray[jessiePosition];
                }
            }
            memberToBeServed++;
        }
        return waitingTimeForJessie;
    }

}
