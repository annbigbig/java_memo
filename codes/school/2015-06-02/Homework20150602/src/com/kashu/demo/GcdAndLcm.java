package com.kashu.demo;

import java.util.Scanner;

public class GcdAndLcm {

	public static void main(String[] args) {
		//求最大公因數與最小公倍數
		//variables declaration
		int a=1,b=1,gcd=1,lcm=1,bigger=1,smaller=1;
		Scanner sc = new Scanner(System.in);
		
		//collect data
		System.out.println("請輸入正整數a");
		a = sc.nextInt();
		System.out.println("請輸入正整數b");
		b = sc.nextInt();
		
		//calculating
		if(a<1) a=1;
		if(b<1) b=1;
		if(a>b){
			bigger=a;
			smaller=b;
		}else{
			bigger=b;
			smaller=a;
		}
		     //this is for gcd 最大公因數
		for(int i=bigger;i>=1;i--){
		  if((a%i==0)&&(b%i==0)){
			    gcd = i;
			    break;
		     }
		}
		     //this is for lcm 最小公倍數
		for(int j=1;j<=(a*b);j++){
			if((j%a==0)&&(j%b==0)){
				 lcm = j;
				 break;
			}
		}
		
		//display results
		System.out.println("您輸入的正整數為 : a = " +a + " , b = " + b);
		System.out.println("最大公因數 = "+ gcd);
		System.out.println("最小公倍數 = " + lcm);

	}

}