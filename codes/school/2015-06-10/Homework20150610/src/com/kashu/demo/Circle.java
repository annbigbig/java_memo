package com.kashu.demo;

public class Circle {
  int r = 0;
  int h = 0;
  
  public double getArea(int r){
	    double a = (double) Math.PI * Math.pow(r, 2);
	    return a;
    }

  public double getVolume(int r, int h){
	    double v = (double) Math.PI * Math.pow(r, 2) * h;
	    return v;
  }
}