package com.kashu.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sqrt {

	public static void main(String[] args) {
		   //variables declaration
		  int a=0,b=0,c=0;
		  double up = 0.0,x=0.0;
		  Scanner sc = new Scanner(System.in);
		  boolean check_condition1 = false , check_condition2 = false;
		
		   //collect data
		  System.out.println("請輸入整數a");
		  a = sc.nextInt();
		  System.out.println("請輸入整數b");
		  b = sc.nextInt();
		  System.out.println("請輸入整數c");
		  c = sc.nextInt();
		  
		  //calculating
		  check_condition1 = (a!=0);
		  up = Math.sqrt((Math.pow(b, 2) - (double)(4 * a * c)));
		  check_condition2 = (up>=0);
		  if(check_condition1){
			    if(check_condition2){
			    	  x = (up /(2*a));
			          }
		     }
		     
		  //display results
		   if(check_condition1){
			    if(check_condition2){
			    	 System.out.println("x = " + x);
			    }else{
			    	 System.out.println("b平方減4ac必須大於等於0");
			           }
          
		   }else{
			   System.out.println("a必須不等於0");
		        }
		
	}

}
