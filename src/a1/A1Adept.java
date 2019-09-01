package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int numberOfItems = scan.nextInt();
		int k = 0;
		String[] itemList = new String[numberOfItems];
		double[] itemPrices = new double[numberOfItems];
		while (k < numberOfItems) {
			itemList[k] = scan.next();
			itemPrices[k] = scan.nextDouble();
			k ++;
		}
		int numberOfCustomers = scan.nextInt();
		int j = 0;
		String[] names = new String[numberOfCustomers];
		double[] costs = new double[numberOfCustomers];
		while (j < numberOfCustomers) {
			names[j] = customerName(j, scan);
			//System.out.println(names[j]);
			costs[j] = orderCost(j, itemList, itemPrices, scan);
			//System.out.println(costs[j]);
			j++;
		}
		double maxCost = 0;
		double minCost = 0;
		int maxIndex = 0;
		int minIndex = 0;
		
		for (int i = 0; i < costs.length - 1; i ++) {
			if (costs[i + 1] > costs[i]) {
				maxCost = costs[i + 1];
				maxIndex = i + 1;
			}
		}
		for (int i = 0; i < costs.length - 1; i ++) {
			if (costs[i + 1] < costs[i]) {
				minCost = costs[i + 1];
				minIndex = i + 1;
			}
		}
		//System.out.println(maxCost);
		//System.out.println(minCost);
		double avgCost = 0;
		for (int i = 0; i < costs.length; i ++) {
			avgCost += costs[i];
		}
		avgCost = avgCost / numberOfCustomers;
		//System.out.println(avgCost);
		System.out.println("Biggest: " + names[maxIndex] + " (" + String.format("%.2f", maxCost) + ")");
		System.out.println("Smallest: " + names[minIndex] + " (" + String.format("%.2f", minCost) + ")");
		System.out.println("Average: " + String.format("%.2f", avgCost));
		scan.close();
	}
	
	static String customerName(int customerNumber, Scanner scan) {
		String firstName = scan.next();
		String lastName = scan.next();
		return firstName + " " + lastName;
	}
	
	static double orderCost(int customerNumber, String[] itemList, double[] itemPrices, Scanner scan) {
		double totalCost = 0;
		int numberOfItems = scan.nextInt();
		while (numberOfItems > 0) {
			int itemQuantity = scan.nextInt();
			String item = scan.next();
			int itemIndex = 0;
			int k = 0;
			while (k < itemList.length) {
				if (item.equals(itemList[k])) {
					itemIndex = k;
				}
				k++;
			}
			totalCost += itemPrices[itemIndex] * itemQuantity;
			numberOfItems += -1;
		}
		return totalCost;
	}
}
