package com.kashu.demo;

import java.util.Scanner;

public class HomeWork9 {

	public static void main(String[] args) {
		//declaration
	 Scanner sc = new Scanner(System.in);
	 int a1=0,a5=0,a10=0,a50=0;
	 int total = 0;
	 int thousands=0,hundreds=0,tens=0,zeros=0;
	 
	   //collect data
   System.out.println("請輸入小孩姓名");
     String name = sc.nextLine();
     System.out.println("Hi "+ name + "請輸入你的銅板的個數:");
     System.out.println("請輸入1元的數量:");
     a1=sc.nextInt();
     System.out.println("請輸入5元的數量:");
     a5=sc.nextInt();
     System.out.println("請輸入10元的數量:");
     a10=sc.nextInt();
     System.out.println("請輸入50元的數量:");
     a50=sc.nextInt();
     
     //---calculating ... ---
     total = (1*a1)+(5*a5)+(10*a10)+(50*a50);
     thousands = total / 1000;
     hundreds = (total - (thousands * 1000))/100;
     tens = (total - (thousands * 1000) - (hundreds * 100))/10;
     zeros = total % 10;
     
     //---generate result---
     System.out.print("您的錢總共有 : "+thousands+"千"+hundreds+"百"+tens+"十"+zeros+"元");
     
	}
	

}
