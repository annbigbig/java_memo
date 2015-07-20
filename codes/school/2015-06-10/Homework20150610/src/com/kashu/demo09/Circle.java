package com.kashu.demo09;

public class Circle {
	int r = 0;
	int h = 0;
	
	public void setR(int r){
		this.r = r;
	}
	
	public void setH(int h){
		this.h = h;
	}
	
	public double getArea(){
		return Math.PI * Math.pow(r, 2);
	}
	
	public double getVolume(){
		return getArea() * h;
	}
}