package com.kashu.demo;

import java.util.Scanner;

public class TimeConvert {

	public static void main(String[] args) {
		 
		
		//variables declaration
		Scanner sc = new Scanner(System.in);
		int hour = 0;
		String result = "";
		
		//collect data
		System.out.println("請輸入時間，範圍是0到24的整數:");
		hour = sc.nextInt();
		
		//calculating
		if ((hour<0)||(hour>24)) hour = 0;
		result = (hour<12) ? hour + " AM" : (hour - 12) + " PM";
		
		
		//display results
    System.out.println("轉換後的時間為 : " + result);
	}

}
