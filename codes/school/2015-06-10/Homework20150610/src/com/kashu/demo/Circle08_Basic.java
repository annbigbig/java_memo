package com.kashu.demo;

import java.util.Scanner;

public class Circle08_Basic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Circle cr = new Circle();
		int r = 0, h = 0;
		
		System.out.println("請輸入圓半徑 r ");
		r = sc.nextInt();
		System.out.println("請輸入圓柱高 h ");
		h = sc.nextInt();
		
		System.out.println("圓的面積 = " + cr.getArea(r));
		System.out.println("圓的面積 = " + cr.getVolume(r,h));
		
	}

}
