package com.denewo.LD38;

public class Time {

	
	private static double tmp = System.currentTimeMillis();
	public static double time = 0;
	
	public static void reset () {
		time = 0;
		tmp = System.currentTimeMillis();
	}
	
	public static void next () {
		time = System.currentTimeMillis() - tmp;
		tmp = System.currentTimeMillis();
	}
	
	public static double getTime () {
		return time/1000;
	}
	
}
