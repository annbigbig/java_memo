package com.kashu.demo;

public class Triangle extends Shape implements ShapeInfo,ShapeInterface {
	private double x1;
	private double y1;
	private double l;

	public Triangle(double x,double y,double x1,double y1,double l){
		super.x = x;
		super.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.l = l;
	}
	
	@Override
	public double area() {
		return (Math.abs(y-y1)*l*(1.0/2.0));
	}

	@Override
	public void show() {
		System.out.println("三角形座標y1=" + y1 + "\t y=" + y + "\t 高l=" + l + "\t 面積=" + area());
	}

}
