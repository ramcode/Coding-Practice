package com.practice.interview.java.snippets;

import java.util.Arrays;

public class EnumPrimer {

	public enum DaysofWeek {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}

	public static void spellDay(DaysofWeek day) {
		switch (day) {
		case SUNDAY:
			System.out.println("Day is Sunday");
			break;
		default:
			System.out.println("Day is not sunday");
			break;
		}
	}

	public static void main(String[] args) {
		DaysofWeek day = DaysofWeek.SUNDAY;
		spellDay(day);
		System.out.println("All days:");
		Arrays.stream(DaysofWeek.values()).forEach(System.out::println);

	}

}
