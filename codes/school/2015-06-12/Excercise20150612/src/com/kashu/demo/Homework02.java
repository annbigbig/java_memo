package com.kashu.demo;

public class Homework02 {
	/*
	 * 練習2
	 * 
	 * 加總兩個整數陣列A和B，放到另一個C陣列裡
	 * 
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		//variables declaration
		int A[][] = {{1,2,3},{4,5,6}};
		int B[][] = {{7,8,9},{10,11,12}};
		int C[][] = new int[2][3];
		
		//collect data
		
		
		//calculating
		for(int i=0;i<2;i++){
			for(int j=0;j<3;j++){
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		
		//display results
		for(int k=0;k<2;k++){
			for(int m=0;m<3;m++){
				System.out.printf("A[ %d ][ %d ] = %d +\t\t B[ %d ][ %d] = %d \t\t C[ %d ][ %d ] = %d \n",k,m,A[k][m],k,m,B[k][m],k,m,C[k][m]);
			}
		}

	}

}
