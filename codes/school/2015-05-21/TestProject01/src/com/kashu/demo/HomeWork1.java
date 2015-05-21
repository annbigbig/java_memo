package com.kashu.demo;

import java.util.Scanner;

public class HomeWork1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input a weight value in KG:");
		double kg = sc.nextDouble();
		System.out.println(kg + "KG = " + (kg*2.20462) + "pound");
	}

}
