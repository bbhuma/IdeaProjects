package com.example.java8practice.java8.conceptwise;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

public class LocalDateTimeZonePractice {

	public static void main(String[] args) {
		LocalTime now = LocalTime.now();
		System.out.println(now);
		int seconds = now.getSecond();
		now.getNano();
		LocalTime customTime = LocalTime.of(14, 30, 30, 400);
		System.out.println(customTime);
		System.out.println(now.isAfter(customTime));

		String localTime = "23/39/04";
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH/mm/ss");
		// Parsing the string into LocalTime can give you access to all the DateTime
		// methods.
		// Format based on a formatter pattern.
		LocalTime parsedTime = LocalTime.parse(localTime, formatter1);
		System.out.println(parsedTime);

		// Create a ZonedDateTime using .now();
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);

		// Create a ZonedDateTime using .now();
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println(zonedDateTime);
		ZoneId zoneId = zonedDateTime.getZone();
		System.out.println(zoneId);
		
		ZonedDateTime dateTime = ZonedDateTime.of(2024, 05, 30, 14, 30, 30, 400, ZoneId.of("Asia/Calcutta"));
        System.out.println("Custom ZonedDateTime: " + dateTime);
		
		String date = "2024/05/30T00:56:23.973213300+05:30"; // you can use --> "yyyy-MM-dd HH:mm:ssXXX" XXX is offset for +5.30
		// Define the formatter for the given date format
		DateTimeFormatter myformatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm:ss.SSSSSSSSSXXX");
		// Parse the string into a ZonedDateTime object
		ZonedDateTime ParsedZonedDateTime = ZonedDateTime.parse(date, myformatter1);
		System.out.println("Parsed ZonedDateTime: " + ParsedZonedDateTime);

		// Display all available zone IDs
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		System.out.println("All Zone IDs:");
		zoneIds.stream().limit(24).forEach(System.out::print); //-----> a total of 600 is present.

		// Create a custom date with the zone ID set to "America/New_York"
		ZoneId newYorkZone = ZoneId.of("America/New_York");
		ZonedDateTime newYorkTime = ZonedDateTime.now(newYorkZone);
		DateTimeFormatter zoneFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
		DateTimeFormatter offsetFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssXXX");
		String formattedDateTime = newYorkTime.format(zoneFormat);
		System.out.println("\nCurrent time in New York: " + formattedDateTime);
		//Format indian time now() into the format showing "Z" as EDT or IST. 
		System.out.println("\nCurrent time in India: " + zonedDateTime.format(zoneFormat));
		System.out.println("\nCurrent time in India: " + zonedDateTime.format(offsetFormat));
		
		/*
		 * Instant used to calculate time from 1970,jan 1. duration is used to cal time
		 * between short duration like time in hours and mins. period is between two
		 * dates which is for longer duration like years and months. Datetimeformatter
		 * is for formatting dates into the desired format, using date.format().
		 */
		
		Instant start = Instant.now();
		for (int i = 0; i < 1000000; i++) {
			
		}
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");

	}
};