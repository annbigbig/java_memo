package com.kashu.demo;

import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
	  //the value of BMI = (weight in KG) / (height in meter)^2
		
		//variables declaration
		Scanner sc = new Scanner(System.in);
		double w=0.0,h=0.0,bmi=0.0;
		
		//collect data
		System.out.println("Please input your height (cm) : ");
		h=sc.nextDouble();
		System.out.println("Please input your weight (kg) : ");
		w=sc.nextDouble();
		
		//calculating
		h = h / 100.0;
		bmi = w / (Math.pow(h,2));
		
		//display results
		System.out.println("Your BMI value is " + bmi);
		//System.out.printf("Your BMI value is %.2f",bmi);
	}
}