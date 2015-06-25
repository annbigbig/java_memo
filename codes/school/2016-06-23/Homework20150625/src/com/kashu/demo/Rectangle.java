package com.kashu.demo;

public class Rectangle extends Shape implements ShapeInfo,ShapeInterface {
	private double x1;
	private double y1;

	public Rectangle(double x,double y,double x1,double y1){
		super.x = x;
		super.y = y;
		this.x1 = x1;
		this.y1 = y1;
	}
	
	@Override
	public double area() {
		return (Math.abs(x-x1) * Math.abs(y-y1));
	}

	@Override
	public void show() {
		System.out.println("座標 x= " + x + "\t 座標 x1=" + x1  + "\t 座標y=" + y + "\t 座標y1=" + y1);
		System.out.println("長=" + Math.abs(x-x1) + "\t 寬=" + Math.abs(y-y1));
		System.out.println("長方形面積 = " + area());
	}

}
