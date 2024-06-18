package com.example.java8practice.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class LocalDateAndTimeZoneTime {

	public static void main(String[] args) {

		/*
		 * 1. Creating: Use LocalDate.now(), LocalDate.of(), or LocalDate.parse(). 2.
		 * Manipulating: Use methods like plusDays(), minusMonths(), getDayOfWeek(),
		 * etc. 3. Comparing: Use methods like isBefore(), isAfter(), and isEqual(). 4.
		 * Formatting: Use DateTimeFormatter to format dates.
		 */

		// Creating a LocalDate
		LocalDate today = LocalDate.now();
		System.out.println("Today" + "'s" + " Date:" + today);
		LocalDate yesterday = today.minusDays(1);

		// Specific date
		LocalDate specificDate = LocalDate.of(2024, 5, 28);
		LocalDate specificDateBtechStartDate = LocalDate.of(2014, 05, 20);
		LocalDate specificDateBtechEndDate = specificDateBtechStartDate.plusYears(4);

		System.out.println(
				"My btech grad period is between " + specificDateBtechStartDate + " And " + specificDateBtechEndDate);

		// Parsing a date from a string
		LocalDate parsedDate = LocalDate.parse("2024-05-28");
		System.out.println("Parsed date: " + parsedDate);

		// Adding days
		LocalDate nextWeek = today.plusDays(7);
		System.out.println("Add 7 days - Next week: " + nextWeek);

		// Subtracting months
		LocalDate lastMonth = today.minusMonths(1);
		System.out.println("Minus 30 days - Last month: " + lastMonth);

		// Getting the day of the week
		System.out.println("Day of the week: " + today.getDayOfWeek());

		// Getting the day of the month
		System.out.println("Day of the month: " + today.getDayOfMonth());

		// Checking if a date is before another date
		System.out.println("Is today before the specific date? " + today.isBefore(specificDate));

		// Checking if a date is after another date
		System.out.println("Is today after the specific date? " + today.isAfter(specificDate));

		// Checking if two dates are equal
		System.out.println("Is today equal to the specific date? " + today.isEqual(specificDate));

		// Default format
		System.out.println("Default format: " + today);

		// Custom format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = today.format(formatter);
		System.out.println("Custom formatted date: " + formattedDate);

		/*
		 * Creating LocalDate instances. Manipulating and adjusting dates. Comparing
		 * dates. Formatting and parsing dates. Working with leap years. Calculating
		 * periods and durations. Handling specific use cases like birthdays. Combining
		 * LocalDate with LocalTime to create LocalDateTime.
		 * 
		 */

		LocalDate today1 = LocalDate.now();

		// 5. First day of the month
		LocalDate firstDayOfMonth = today1.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("First day of the month: " + firstDayOfMonth);

		// Last day of the month
		LocalDate lastDayOfMonth = today1.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("Last day of the month: " + lastDayOfMonth);

		//6. First day of the year
		LocalDate firstDayOfYear = today.with(TemporalAdjusters.firstDayOfYear());
		System.out.println("First day of the year: " + firstDayOfYear);

		// Last day of the year
		LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
		System.out.println("Last day of the year: " + lastDayOfYear);

		// 7. Next Monday
		LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		System.out.println("Next Monday: " + nextMonday);

		// Previous Monday
		LocalDate previousMonday = today.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
		System.out.println("Previous Monday: " + previousMonday);

		// 8. Calculating the Period Between Two Dates
		LocalDate startDate = LocalDate.of(2020, 1, 1);
		LocalDate endDate = LocalDate.now();

		Period period = Period.between(startDate, endDate);
		System.out.println("Period Object: " +period);
		System.out.println(
				"Years: " + period.getYears() + ", Months: " + period.getMonths() + ", Days: " + period.getDays());
		
		// 9. Checking for Leap Year
		LocalDate today2 = LocalDate.now();
        boolean isLeapYear = today2.isLeapYear();
        System.out.println("Is this year a leap year? " + isLeapYear);

        // Specific year check
        LocalDate specificDate1 = LocalDate.of(2024, 1, 1);
        boolean isSpecificLeapYear = specificDate1.isLeapYear();
        System.out.println("Is 2024 a leap year? " + isSpecificLeapYear);
        
		// 10. Working with Birthdays
		// 11.
		// 12. 
	}

};