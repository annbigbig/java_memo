package com.kashu.demo;

import java.text.DecimalFormat;
import java.util.Scanner;


public class HomeWork2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1=0,n2=0,n3=0;
		System.out.println("Please input a number for number1:");
		n1 = sc.nextInt();
		System.out.println("Please input a number for number2:");
		n2 = sc.nextInt();
		System.out.println("Please input a number for number3:");
		n3 = sc.nextInt();
		double average = (n1+n2+n3)/3;
		//DecimalFormat df = new DecimalFormat("##.00");
		//double average = Double.parseDouble(df.format((n1+n2+n3)/3));
		//System.out.println("The average of " + n1 + " " + n2 + " " + n3 + " is ");
		//System.out.format("%.2f%n",average);
		System.out.printf("%.2f",average);
	}

}