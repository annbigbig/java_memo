package com.kashu.demo;

public class Circle05_sub {

	static void Area(int r){
		 double a = Math.PI * Math.pow((double)r, 2);
		 System.out.println("半徑" + r + "的圓形的圓面積 = " + a);
	}
	
	static void Volume(int r , int h){
		 double v = Math.PI * Math.pow(r, 2) * h;
		 System.out.println("半徑 " + r + " 高度 " + h + "的圓柱體的體積 =" + v);
	}
	
	public static void main(String[] args) {
		Area(10);
		Volume(10,20);

	}

}