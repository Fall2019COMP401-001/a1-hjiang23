package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);	
		int numberOfCustomers = scan.nextInt();
		int copyNumberOfCustomers = numberOfCustomers;
		String[] output = new String[numberOfCustomers];
		int customerNumber = -1;
		while (numberOfCustomers != 0) {
			String firstName = scan.next();
			String lastName = scan.next();
			int numberOfItems = scan.nextInt();
			double totalCost = 0;
			while (numberOfItems != 0) {
				int howMuchOfItem = scan.nextInt();
				scan.next();
				double itemCost = scan.nextDouble();
				double oneItemTotal = howMuchOfItem * itemCost;
				totalCost += oneItemTotal;
				numberOfItems += -1;
			}
			numberOfCustomers += -1;
			customerNumber += 1;
			output[customerNumber] = firstName.charAt(0) + ". " + lastName + ": " + String.format("%.2f", totalCost);
		}
	
		int k = 0;
		while (k < copyNumberOfCustomers) {
			System.out.println(output[k]);
			k += 1;
		}
		
	}
	
}
	

