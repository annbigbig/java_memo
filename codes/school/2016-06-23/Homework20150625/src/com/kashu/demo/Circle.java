package com.kashu.demo;

public class Circle extends Shape implements ShapeInfo,ShapeInterface{
	private double r;
	
	public Circle(double x,double y,double r){
		super.x = x;
		super.y = y;
		this.r = r;
	}

	@Override
	public void show() {
		System.out.println("半徑=" + r + "\t圓面積 = " + area());
	}
	
	@Override
	public double area(){
		return Math.PI * Math.pow(r, 2);
	}

}
