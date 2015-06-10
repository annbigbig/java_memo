package com.kashu.demo09;

import java.util.Scanner;

public class Circle09_Advanced {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Circle cr = new Circle();
		
		System.out.println("請輸入圓半徑 r : ");
		cr.setR(sc.nextInt());
		
		System.out.println("請輸入圓柱高 h : ");
		cr.setH(sc.nextInt());
		
		System.out.println("圓面積 = " + cr.getArea());
		System.out.println("圓體積 = " + cr.getVolume());
	}

}
