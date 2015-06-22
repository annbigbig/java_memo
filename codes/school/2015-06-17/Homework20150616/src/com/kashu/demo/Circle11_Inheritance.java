package com.kashu.demo;

import java.util.Scanner;

public class Circle11_Inheritance {

	public static void main(String[] args) {
		int r=0 ,h=0;
		System.out.println("請輸入半徑");
		r = InputData();
		System.out.println("請輸入圓柱高");
		h = InputData();
		CalcVolume cv = new CalcVolume(r,h);
		cv.printR();
		cv.printH();
	}

	static int InputData(){
		Scanner sc = new Scanner(System.in);
		int n =0;
		n = sc.nextInt();
		if(n>0) return n;
		return n;
	}
}

class CalcArea{
	private int r;
	private double PI = 3.1416;
	
	public CalcArea(){
		
	}
	
	public CalcArea(int radius){
		this.r = radius;
	}
	
	public double getNum(){
		return (PI * Math.pow(r,2));
	}
	
	public void printR(){
		System.out.println("半徑" + r + "，圓面積 = " + getNum());
	}
}

class CalcVolume extends CalcArea{
	private int h = 0;
	
	public CalcVolume(int radius , int height){
		super(radius);
		this.h = height;
	}
	
	public double getNum(int h){
		return super.getNum() * h;
	}
	
	public void printH(){
		System.out.println("高度"  + h + "，圓柱體體積 = " + getNum(h));
	}
	
}
