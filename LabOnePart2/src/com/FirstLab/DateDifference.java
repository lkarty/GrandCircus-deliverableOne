/* Lindsay Karty Lab 1 part 2
 * Write a Java console application to calculate the duration between two dates
 * in Years, Months and Days. The user should enter two dates as input, then the
 * program will show the result of the difference in time between these two
 * dates.
 */

package com.FirstLab;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateDifference {

	private static Scanner scdate;

	public static void main(String[] args) {

		scdate = new Scanner(System.in);
		String date1; // user input date 1
		String date2; // user input date 2
		String y1; // year of date 1
		String y2; // year of date 2
		String m1; // month of date 1
		String m2; // month of date 2
		String d1; // day of date 1
		String d2; // day of date 2
		int d1y = 0; // following are string vars parsed as integers
		int d1m = 0;
		int d1d = 0;
		int d2y = 0;
		int d2m = 0;
		int d2d = 0;
		boolean isvalidDate; // validation checker

		isvalidDate = false;

		while (isvalidDate == false) {
		
		//Enter First Date
			System.out.println("Enter a date using the format yyyy/mm/dd:");
		date1 = scdate.next();
		
		// Enter second Date
			System.out.println("Enter a second date using the format yyyy/mm/dd:");
		date2 = scdate.next();

			// Strip slashes
			date1 = date1.replace("/", "");
			date2 = date2.replace("/", "");

			// Grab y/m/d from strings
			y1 = date1.substring(0, 4);
			m1 = date1.substring(4, 6);
			d1 = date1.substring(6, 8);
			y2 = date2.substring(0, 4);
			m2 = date2.substring(4, 6);
			d2 = date2.substring(6, 8);

			// Get int lengths
		int d1Length = date1.length();
		int d2Length = date2.length();

			// The following is my bloated code for validating date format

			// check character length
			if (d1Length > 8 || d2Length > 8) {
				isvalidDate = false;
				System.out.println("Not a valid dates. Please use the format yyyy/mm/dd with numbers.");
			}

			// Find out if input consists of numbers
			else if (isvalidDate == false) {
			for (int i1 = 0; i1 < d1Length; i1++) {
				if (!Character.isDigit(date1.charAt(i1))) {
					isvalidDate = false;
				}

				if (date1 == null || date1.trim().isEmpty()) {
					isvalidDate = false;
				}
			}

			for (int i1 = 0; i1 < d1Length; i1++) {
				if (!Character.isDigit(date2.charAt(i1))) {
					isvalidDate = false;
				}

				if (date2 == null || date2.trim().isEmpty()) {
					isvalidDate = false;
				}
			}
				System.out.println("Not a valid dates. Please use the format yyyy/mm/dd with numbers.");
			}

			// check for valid month
			else if ((date1.charAt(4) > '1') || date1.charAt(5) > '2' || date1.charAt(6) > '3') {
				isvalidDate = false;
				System.out.println("Not a valid dates. Please use the format yyyy/mm/dd with numbers.");
			}
			// check for valid day
			else if ((date1.charAt(6) > '2') && date1.charAt(7) > '1') {
					isvalidDate = false;
				System.out.println("Not a valid dates. Please use the format yyyy/mm/dd with numbers.");
			}

			// proceed w program if entry is valid
			else {
				isvalidDate = true;
				
				// turn strings to ints
				d1y = Integer.parseInt(y1);
				d1m = Integer.parseInt(m1);
				d1d = Integer.parseInt(d1);
				d2y = Integer.parseInt(y2);
				d2m = Integer.parseInt(m2);
				d2d = Integer.parseInt(d2);

				// define dates to be compared
				LocalDate firstDate = LocalDate.of(d1y, d1m, d1d);
				LocalDate secondDate = LocalDate.of(d2y, d2m, d2d);

				// define period to be compared
				Period p = Period.between(firstDate, secondDate);

				// calculate difference
				long p2 = ChronoUnit.DAYS.between(firstDate, secondDate);
				System.out.println("Difference is: " + p.getYears() + " years, " + p.getMonths() + " months, and "
						+ p.getDays() + " days old. (" + p2 + " days total)");
				}

			}
		}

	}


