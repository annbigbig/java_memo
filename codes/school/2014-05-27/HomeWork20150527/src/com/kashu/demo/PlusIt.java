package com.kashu.demo;

import java.util.Scanner;

public class PlusIt {

	public static void main(String[] args) {
		//homework5: 求 S = 1 - (1/2) + (1/3) - (1/4) + (1/5) - (1/6) + ------ + (1/n)
		//variables declaration
		int n = 1;
		double s = 0.0;
		Scanner sc = new Scanner(System.in);
		
		//collect data
		System.out.println("請輸入一個正整數n，稍後會計算");
		System.out.println("S = 1 - (1/2) + (1/3) - (1/4) + (1/5) - (1/6) + ------ + (1/n)");
		n = sc.nextInt();
		
		//calculating
		if(n<=0) n=1;
		for(int i=1;i<=n;i++){
			if(i%2==1){
				System.out.println(s + "= " + s + "+ 1/" + i +" ");
				s = s + (1/(double)i);
			}else{
				System.out.println(s + "= " + s + "- 1/" + i + " ");
				s = s - (1/(double)i);
			}
			
		}
		
		//display results
		System.out.println("結果是" + s);
		

	}

}