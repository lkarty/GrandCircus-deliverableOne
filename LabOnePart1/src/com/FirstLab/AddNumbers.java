/* Lindsay Karty Lab 1 part 1
 * Write a Java Console program to perform the following task: 
 * Input: Your program should read two integer numbers from the user with the same
 * number of digits (example: number1= 234, number2 = 564).
 * Task: Check if each corresponding place in the two numbers (ones, tens, hundreds, …)
 * sums to the same total. Output: Your program should print out: True or False based on the result. */

package com.FirstLab;

import java.util.Scanner;

public class AddNumbers {

	private static Scanner scnum;

	public static void main(String[] args) {

		scnum = new Scanner(System.in);
		String usrNum1; // usernum1 sequence
		String usrNum2; // user num2 sequence
		int n1Length;
		int n2Length;
		int pNum1; // parsed 1 sequence
		int pNum2; // parsed 2 sequence
		int r = 0; // num1 division
		int r2 = 0; // num2 division
		int sum = 0; // sum num1 and 2
		int i;
		boolean isdigValid;

		isdigValid = false;

		// Get user input
		while (isdigValid == false) {
			System.out.println("Enter a whole number (up to 9 digits):");
			usrNum1 = scnum.next();

			System.out.println(
					"Enter a second whole number with the same amount of digits. Digits corresponding to first number should be sum of 9:");
			usrNum2 = scnum.next();

			// assign character length
			n1Length = usrNum1.length();
			n2Length = usrNum2.length();

			// check that length of sequences match and under 9 digits

			if (n1Length != n2Length && n1Length > 10 && n2Length > 10) {
				isdigValid = false;
				System.out.println("Not a valid entry. Numbers only. Use equal amount of digits.");
			}

			// if all good, parse as integers and check sums
			else if (usrNum1.matches("[0-9]+") && usrNum2.matches("[0-9]+")) {

				isdigValid = true;

				// change string to int
				pNum1 = Integer.parseInt(usrNum1);
				pNum2 = Integer.parseInt(usrNum2);


				// check for sums of corresponding integers and
				for (i = 0; i < n1Length; ++i) {
					r = pNum1 % 10;
					pNum1 = pNum1 / 10;

					r2 = pNum2 % 10;
					pNum2 = pNum2 / 10;

					sum = r + r2;

					if (sum != 9) {
						// If sums do not equal, print false
						System.out.println("FALSE: digits " + (i + 1) + " do not equal 9.");
					} else {
						// If sums equal, print true
						System.out.println("TRUE: sum of digits " + (i + 1) + "  equal 9.");
					}
				}		
			}
			
		}
	}
}
	

		

		
