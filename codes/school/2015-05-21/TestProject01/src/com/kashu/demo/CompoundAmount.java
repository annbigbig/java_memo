package com.kashu.demo;

import java.util.Scanner;

public class CompoundAmount {

	public static void main(String[] args) {
		// A = P(1+rt)
		
		//declaration
		Scanner sc = new Scanner(System.in);
		double a=0,p=0,r=0,t=0;
		
		
		//collect data
		System.out.println("請輸入本金:");
		p = sc.nextDouble();
		System.out.println("請輸入年利率:");
		r = sc.nextDouble();
		System.out.println("請輸入期數:");
		t = sc.nextDouble();
		
		
		//calculating
		a = p * (1+r*t);
		
		//display result
		System.out.println("本利和 = " + a);

	}

}
