package com.kashu.demo;

public class Ex8 {

	public static void main(String[] args) {
		int i = add(2,3);
		double d = add(5.2,4.3);
		String s = add("I love ","Java!");
		System.out.printf("%d %f %s %n",i,d,s);
	}
	
	public static int add(int i,int j){
		System.out.println("Adding two integers: " + i +"," + j);
		return i+j;
	}

	public static double add(double i,double j){
		System.out.println("Adding two doubles: " + i + "," + j);
		return i+j;
	}
	
	public static String add(String i, String j){
		System.out.println("Adding two strings: " + i + "," + j);
		return(i+j);
	}
}
