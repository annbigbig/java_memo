package com.kashu.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo {

	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("請輸入一列文字:");
		String text = buf.readLine();
		System.out.print("請輸入一數字:");
		int n = Integer.parseInt(buf.readLine());
		
		//display results
		System.out.println("text = " + text);    //打印 text
		System.out.println("n + 1 = " + (n+1));  //打印 n+1
	}

}
