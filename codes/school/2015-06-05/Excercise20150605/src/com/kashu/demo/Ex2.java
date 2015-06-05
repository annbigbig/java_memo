package com.kashu.demo;

public class Ex2 {

	public static void main(String[] args) {
		double y = 3.21384;
		System.out.printf("f(y) = %.4f\n",f(y));
		System.out.printf("f(%.4f) = %.4f\n",f(y),f(y));
	}

	public static double f(double x){
		return (3*x*x*x + 2*x -1);
	}
}
