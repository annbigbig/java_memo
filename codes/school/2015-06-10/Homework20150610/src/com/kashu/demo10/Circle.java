package com.kashu.demo10;

public class Circle {
	private int r = 0;
	private int h = 0;
	
	public Circle(){
		this(1,1);
	}
	
	public Circle(int r,int h){
		this.r = r;
		this.h = h;
		if(r<=0) this.r = 1;
		if(h<=0) this.h = 1;
	}
	
	private void setR(int r){
		this.r = r;
	}
	
	private void setH(int h){
		this.h = h;
	}
	
	public double getArea(){
		return Math.PI * Math.pow(r, 2);
	}
	
	public double getVolume(){
		return getArea() * (double)h;
	}
	
}
