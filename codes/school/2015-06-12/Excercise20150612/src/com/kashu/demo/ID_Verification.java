package com.kashu.demo;

import java.util.Scanner;

public class ID_Verification {

	/*
	 * 身分證字號驗證程式
	 * 
	 */
	public static void main(String[] args) {
		
		//collect data
		System.out.println("請輸入中華民國身分證字號:");
		String id = inputData();
		
		//calculating
		if(verifyID(id)){
			System.out.println("您的身分證字號是合法的");
		}else{
			System.out.println("您的身分證字號是非法的");
		}
		
	}
	
	
	//從用戶取得一個長度為10的身分證字串
	public static String inputData(){
		Scanner sc = new Scanner(System.in);
		String str =  sc.nextLine();
		if (str.length()==10){
			return str;
		}
		return "";
	}
	
	public static boolean verifyID(String id){
		String[][] alpha = {
				{"A","10"},{"B","11"},{"C","12"},{"D","13"},{"E","14"},
				{"F","15"},{"G","16"},{"H","17"},{"I","34"},{"J","18"},
				{"K","19"},{"M","21"},{"N","22"},{"O","35"},{"P","23"},
				{"Q","24"},{"T","27"},{"U","28"},{"V","29"},{"W","32"},
				{"X","30"},{"Z","33"},{"L","20"},{"R","25"},{"S","26"},
				{"Y","31"}
		};
		int[] n = new int[11];
		
		//取出身分證字號的第1個英文字母
		String first_letter = id.substring(0, 1);
		int first_letter_mean = 0;
		for(int i=0;i<alpha.length;i++){
			if(alpha[i][0].equals(first_letter)){
				//將第1個英文字母所代表的數字放入first_letter_mean
				first_letter_mean = Integer.valueOf(alpha[i][1]);
				//將first_letter_mean的十位數放入n[0]
				n[0] = first_letter_mean / 10;
				//將first_letter_mean的十位數放入n[1]
				n[1] = first_letter_mean % 10;
			}
		}
		
		//身分證字號的第2到第10個字元，分別放入n[2]到n[10]
		for(int j=2;j<=10;j++){
			n[j] = Integer.valueOf(id.substring(j-1, j));
			//System.out.println("n[" + j + "]=" + n[j]);
		}
		
		
		//運算，若sum能被10整除則為合法的身分證字號
		int sum = n[0] + (n[1]*9);
		for(int k=2;k<=9;k++){
			sum += n[k]*(10-k);
			System.out.println("n[" + k+ "]=" + n[k] + "\t\t n[" + k + "] * " + (10-k));
		}
		System.out.println("n[10]=" + n[10]);
		sum+=n[10];
		
		System.out.println("sum=" + sum);
		if((sum%10)==0){
			return true;
		}
		
		return false;
	}

}
