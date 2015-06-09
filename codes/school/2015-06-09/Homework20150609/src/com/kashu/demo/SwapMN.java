package com.kashu.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapMN {

	//利用呼叫函式，傳入整數陣列的參數是By Reference的特性，交換陣列元素0與陣列元素1的值
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//定義變數
		int no[] = new int[2];
		BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
		
		//收集資料
		System.out.println("請輸入整數 n ");
		no[0] = Integer.valueOf(keyin.readLine());
		System.out.println("請輸入整數 m ");
		no[1] = Integer.valueOf(keyin.readLine());
		
		//運算 : 我希望大數放在no[0]，小數放在no[1]
		if(no[1]>no[0]) swap(no);
		
		//列印結果
		System.out.println(no[0]+ ">=" + no[1]);
	}

	public static void swap(int no[]){
		int temp;
			temp = no[0];
			no[0] = no[1];
			no[1] = temp;
	}
	
}
