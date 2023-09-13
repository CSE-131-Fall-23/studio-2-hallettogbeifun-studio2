package studio2;

import java.util.Scanner;

import java.lang.Math;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("What amount of money would you like to start with?");
		int startAmount = in.nextInt();
		System.out.println("What would you like the win probability to be?");
		double winChance = in.nextDouble();
		System.out.println("What would you like the win limit to be?");
		int winLimit = in.nextInt();
		System.out.println("How many simulations (days) would you like to run?");
		int totalSimulations = in.nextInt();
		int timesRun = 0;
		int moneyForDay = 0;
		double timesRuined = 0.0;
		double days = 0;
		double xRuin = 0.0;
		for (int i = 0; i < totalSimulations; i++) {
			timesRun = 0;
			days++;
			moneyForDay = 0;
			moneyForDay = startAmount;
			while (moneyForDay > 0 && moneyForDay < winLimit) {
				timesRun++;
				if (Math.random() > winChance) {
					moneyForDay--;
				} else {
					moneyForDay++;
				}
			}
			if (moneyForDay <= 0) {
				System.out.println("Day " + (int) days + ": " + timesRun + " LOSE");
				timesRuined++;
			} else {
				System.out.println("Day " + (int) days + ": " + timesRun + " WIN");
			}
			
		}
		System.out.println("Losses: " + (int) timesRuined + " Simulations: " + totalSimulations);
		double ruinRate = (timesRuined/days);
		if (winChance == 0.5) {
			xRuin = (1 - (startAmount/winLimit));
		} else {
			double alpha = ((1- (double) winChance) / ((double) winChance));
			xRuin = (((Math.pow(alpha, (double) startAmount)) - (Math.pow(alpha, (double) winLimit))) / (1 - Math.pow(alpha, winLimit)));
		}
		System.out.println("Ruin rate: " + ruinRate + " Expected Ruin Rate: " + xRuin);
	}

}
