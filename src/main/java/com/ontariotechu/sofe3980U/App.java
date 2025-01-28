package com.ontariotechu.sofe3980U;

import org.joda.time.LocalTime;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	/**
	 * Main program: The entry point of the program. The local time will be printed first,
	 * Then it will interactively prompt the user for two binary numbers,
	 * perform various operations, and print the results.
	 *
	 * @param args: not used
	 */
	public static void main(String[] args) {
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);

		Scanner scanner = new Scanner(System.in);

		// Prompt user for the first binary number
		System.out.print("Enter the first binary number: ");
		String input1 = scanner.nextLine();
		Binary binary1 = new Binary(input1);
		System.out.println("First binary number is: " + binary1.getValue());

		// Prompt user for the second binary number
		System.out.print("Enter the second binary number: ");
		String input2 = scanner.nextLine();
		Binary binary2 = new Binary(input2);
		System.out.println("Second binary number is: " + binary2.getValue());

		// Perform and display results of operations
		Binary sum = Binary.add(binary1, binary2);
		System.out.println("Sum (Addition): " + sum.getValue());

		Binary orResult = Binary.or(binary1, binary2);
		System.out.println("Bitwise OR: " + orResult.getValue());

		Binary andResult = Binary.and(binary1, binary2);
		System.out.println("Bitwise AND: " + andResult.getValue());

		Binary multiplyResult = Binary.multiply(binary1, binary2);
		System.out.println("Multiplication: " + multiplyResult.getValue());

		scanner.close();
	}
}
