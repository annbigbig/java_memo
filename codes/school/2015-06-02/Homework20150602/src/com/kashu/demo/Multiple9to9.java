package com.kashu.demo;

public class Multiple9to9 {

	public static void main(String[] args) {
		//you can refer here
		//http://stackoverflow.com/questions/699878/is-there-an-easy-way-to-output-two-columns-to-the-console-in-java
		
		//variables declaration
		
		
		//collect data
		
		
		//calculating
		for(int i=1;i<=9;i++){
			for(int j=1;j<=9;j++){
				if(j%3!=0){
					System.out.printf("%2d * %2d = %2d \t", i,j,(i*j));
				}else{
					System.out.printf("%2d * %2d = %2d \t\n", i,j,(i*j));
		    	}
		    }
		     if(i%3==0){
		    	   System.out.println("");
		              }
		}
		
		
		//display results

	}

}
