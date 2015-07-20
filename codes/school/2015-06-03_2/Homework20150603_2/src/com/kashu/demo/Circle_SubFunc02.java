package com.kashu.demo;

import java.util.Scanner;

public class Circle_SubFunc02 {
	
static int InputData(){
	 Scanner sc = new Scanner(System.in);
	 System.out.println("請輸入圓半徑 :");
	 int r = sc.nextInt();
	 return r;
 }
 
//計算圓面積
static double CalcArea(int r){
	 double a = Math.PI * Math.pow(r,2);
	 return a;
 }
 
 //計算圓柱體體積
static double CalcVolumn(int r, int h){
	 double v = Math.PI * Math.pow(r,2) * h;
	 return v;
 }
 
 //打印結果
 static void PrintResult(double a, double v){
	 System.out.println("圓面積 = " + a);
	 System.out.println("圓柱體體積 =" + v);
 }
 
	public static void main(String[] args) {
		//variables declaration
		int r = 0, h = 100;
		double a = 0, v = 0;
		
  //collect data
		r = InputData();
		
		//calculating
		a = CalcArea(r);
		v = CalcVolumn(r,h);
		
		//display results
		PrintResult(a,v);
	}

}