package a1;

//import java.util.Arrays;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int k = 0;
		int itemVarieties = scan.nextInt();
		String[] itemList = new String[itemVarieties];
		while (k < itemVarieties) {
			itemList[k] = scan.next();
			scan.nextDouble();
			k ++;
		}
		//System.out.println(Arrays.toString(itemList));
		int numberOfCustomers = scan.nextInt();
		//System.out.println(numberOfCustomers);
		int[] customerCounts = new int[itemVarieties];
		int[] itemCounts = new int[itemVarieties];
		for (k = 0; k < numberOfCustomers; k ++) {
			scan.next();
			scan.next();
			int numberOfItems = scan.nextInt();
			String[] uniqueItems = new String[numberOfItems];
			for (int j = 0; j < numberOfItems; j++) {
				int itemQuantity = scan.nextInt();
				String itemName = scan.next();		
				boolean alreadyBought = false;
				for (int i = 0; i < uniqueItems.length; i++) {
					if (itemName.equals(uniqueItems[i])) {
						alreadyBought = true;
					}
				}
				for (int i = 0; i < itemVarieties; i++) {
					if (itemName.equals(itemList[i])) {
						itemCounts[i] += itemQuantity;
						if (alreadyBought == false) {
							customerCounts[i] += 1;
						}
						
					}
				}
				uniqueItems[j] = itemName;

			}
		}
		//System.out.println(Arrays.toString(customerCounts));
		//System.out.println(Arrays.toString(itemCounts));
		for (k = 0; k < itemVarieties; k ++) {
			if (customerCounts[k] == 0) {
				System.out.println("No customers bought " + itemList[k]);
			}
			else {
				System.out.println(customerCounts[k] + " customers bought " + itemCounts[k] + " " + itemList[k]);
			}
		}
		scan.close();
	}
}
