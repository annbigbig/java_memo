package com.kashu.demo;

import java.util.Scanner;

public class CompareABC {

	public static void main(String[] args) {
		
		//variables declaration
		Scanner sc = new Scanner(System.in);
		int a=0,b=0,c=0;
		String result = "";
		
   //collect data
		System.out.println("請輸入整數a");
		a = sc.nextInt();
		System.out.println("請輸入整數b");
		b = sc.nextInt();
		System.out.println("請輸入整數c");
		c = sc.nextInt();
		
		//calculating
	  	if ((a>=b)&&(b>=c)){
			  result = "a>b>c";
  		}else if((a>=c)&&(c>=b)){
			  result = "a>c>b";
  		}else if((b>=a)&&(a>=c)){
  			 result = "b>a>c";
  		}else if((b>=c)&&(c>=a)){
  			result = "b>c>a";
  		} else if((c>=a)&&(a>=b)){
  			result = "c>a>b";
  		} else{
  			result = "c>b>a";
  		}
			
			//display results
	  	System.out.println(result);
	  	
		}

}