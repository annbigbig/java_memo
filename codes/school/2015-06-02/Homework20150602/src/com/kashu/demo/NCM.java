package com.kashu.demo;

import java.util.Scanner;

public class NCM {

	public static void main(String[] args) {
		//variables declaration
		double c=0.0,sn=1.0,sm=1.0,snm=1.0;
		int n=0,m=0;
		Scanner sc = new Scanner(System.in);
		
		//collect data
		System.out.println("請輸入正整數n");
		n = sc.nextInt();
		System.out.println("請輸入正整數m");
		m = sc.nextInt();
		
		//calculating
		for(int i=1;i<=n;i++){
			sn = sn * i;
		}
		
		for(int j=1;j<=m;j++){
			sm = sm * j;
		}
		
		for(int k=1;k<=(n-m);k++){
			snm = snm * k;
		}
		
		c = sn / (sm*snm);
		
		//display results
		System.out.println("c = " + c);

	}

}
