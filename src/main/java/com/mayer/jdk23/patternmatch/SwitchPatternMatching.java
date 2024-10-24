package com.mayer.jdk23.patternmatch;

public class SwitchPatternMatching {
	
	public enum Day {
	    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

    public static void main(String[] args) {
        Day day = Day.SATURDAY;
        switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("Weekday");
            case SATURDAY, SUNDAY -> System.out.println("Weekend");
        }
    }
}