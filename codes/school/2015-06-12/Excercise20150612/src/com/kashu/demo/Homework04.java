package com.kashu.demo;

import java.util.Scanner;

public class Homework04 {
	/*
	 * 練習4
	 * 計算停車費
	 * 
	 */

	public static void main(String[] args) {
		
		//variables declaration
		Scanner sc = new Scanner(System.in);
		int[] fees = {30,50,80,100};  //停車費用區間
		double hour = 0 , totalFee = 0;
		
		//collect data
		System.out.println("請輸入停車時數 : (可以是浮點數，需為正數");
		hour = sc.nextDouble();
		
		//calculating
		if(hour<=0) hour = 1.0;
		if((hour>=0)&&(hour<=2)){
			totalFee = hour * fees[0];
			System.out.println("停車時間" + hour+ "費率每小時 " + fees[0]+"元");
		}else if((hour>=2)&&(hour<=4)){
			totalFee = hour * fees[1];
			System.out.println("停車時間" + hour+ "費率每小時 " + fees[1]+"元");
		}else if((hour>=4)&&(hour<=6)){
			totalFee = hour * fees[2];
			System.out.println("停車時間" + hour+ "費率每小時 " + fees[2]+"元");
		}else{
			totalFee = hour * fees[3];
			System.out.println("停車時間" + hour+ "費率每小時 " + fees[3]+"元");
		}
		
		//display results
		System.out.println("總停車費 = " + totalFee);

	}

}