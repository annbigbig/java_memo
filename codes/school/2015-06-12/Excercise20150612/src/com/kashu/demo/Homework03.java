package com.kashu.demo;

public class Homework03 {
/*
 * 練習3
 * 
 * 將陣列反轉
 * 
 */
	
	public static void main(String[] args) {
		
		//variables declaration
		String[] strArray1 = {"A","B","C","D","E","F","G","H","I","J"};
		String[] strArray2 = new String[strArray1.length];

		//collect data
		
		
		//calculating
		for(int i=0;i<strArray1.length;i++){
			strArray2[strArray2.length-i-1] = strArray1[i];
		}
		
		//display results
		for(int j=0;j<strArray2.length;j++){
			System.out.println("strArray2[" + j + "]=" + strArray2[j]);
		}
		
		
	}

}
