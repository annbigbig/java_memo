package com.kashu.demo;

import java.util.Scanner;

public class HomeWork3 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int score = 0;
		 System.out.println("Please enter score:");
		 score = sc.nextInt();
		 if(score>=60){
			 System.out.println("You pass");
		 }
		 System.out.println("End");
	}

}
