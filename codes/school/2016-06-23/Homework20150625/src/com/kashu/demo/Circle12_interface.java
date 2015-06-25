package com.kashu.demo;

public class Circle12_interface {

	public static void main(String[] args) {
		ShapeInfo a;
		Circle c = new Circle(0,0,10.0);
		Triangle t = new Triangle(0,0,100.0,100.0,10.0);
		Rectangle r = new Rectangle(0,0,10,10);
		//Display results
		a = (ShapeInfo) c;
		a.show(); //打印圓面積
		a = (ShapeInfo) t;
		a.show(); //打印三角形面積
		a = (ShapeInfo) r;
		a.show(); //打印長方形面積
	}

}
