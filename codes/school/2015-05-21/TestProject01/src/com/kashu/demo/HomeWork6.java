package com.kashu.demo;

import java.util.Scanner;

public class HomeWork6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=0,total=1;
		System.out.println("Please enter one value:");
		n = sc.nextInt();
		if((n>=1) &&(n<=10)){
			for(int j=1;j<=n;j++){
				total = total * j;
				if(j!=n){
				  System.out.print(j + " * ");
				}else{
					System.out.print(j + " ");
				}
			}
			System.out.println(" = " + total);
		}else{
			System.out.println("Error, the value is out of range.");
		}
	}

}
