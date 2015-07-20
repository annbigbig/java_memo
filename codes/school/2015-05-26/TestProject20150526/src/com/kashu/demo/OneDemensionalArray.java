package com.kashu.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneDemensionalArray {

	public static void main(String[] args) throws IOException {
		//variables declaration
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String userInput = "";
		String[] str = new String[2];
		int[] num = new int[2];
		
		//collect data
		System.out.println("請輸入兩個整數，並以空白鍵隔開，例:     8 39");
		userInput = buf.readLine();
		
		//calculating 
		str = userInput.split(" ");
		for(int i=0;i<2;i++){
			num[i] = Integer.parseInt(str[i]);
		}
		
		//display results
		if (num[0]>num[1]){
			System.out.println(num[0] + ">" + num[1]);
		}else if (num[0]==num[1]){
			System.out.println(num[0] + "=" + num[1]);
		}else{
			System.out.println(num[0] + "<" + num[1]);
		}

	}

}