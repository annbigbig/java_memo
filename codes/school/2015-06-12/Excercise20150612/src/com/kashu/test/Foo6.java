package com.kashu.test;

public class Foo6 {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		final int j=2, k=1;
		for(int i: a){
			 switch(i){
			    case j: System.out.print("A");break;
			    case j+k: System.out.print("B");break;
			    case 4: System.out.print("C");break;
			    default: System.out.print("D");
			    case 1: System.out.print("E");break;
			 
			 }//end-switch
		}//end-for
	}//end-main

}