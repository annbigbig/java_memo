package com.kashu.demo;

import java.util.Vector;

public class LunchBox {
	private int calorie;
	private Vector<Food> content;
	private double priceRatio;
	
	public LunchBox(){
		content = new Vector<Food>();
	}
	
	void add(Food f){
		content.add(f);
	}
	
	int getCalorie(){
		int total = 0;
		for(Food f : content){
			total += f.getCalorie()*f.getAmount();
		}
		return total;
	}
	
	double getPrice(){
		int totalCost = 0;
		for(Food f: content){
			totalCost += f.getCost();
		}
		return totalCost * priceRatio;
	}
	
	void setPriceRatio(double ratio){
		priceRatio = ratio;
	}
	
	//如果便當a比便當b便宜，返回true，否則返回false
	static boolean isCheaperThan(LunchBox a, LunchBox b){
		if(a.getPrice()<b.getPrice()){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		/* EX2
		LunchBox economy = new LunchBox();
		economy.add(new Rice(200));
		economy.add(new Cabbage(100));
		economy.add(new PorkRib(250));
		System.out.println("Total calories of an economy lunch box are " + economy.getCalorie() + ".");
		
		LunchBox valuedChoice = new LunchBox();
		valuedChoice.add(new Rice(200));
		valuedChoice.add(new Egg(30));
		valuedChoice.add(new Carrot(200));
		valuedChoice.add(new PorkRib(300));
		System.out.println("Total calories of a valued-choice lunch box are " + valuedChoice.getCalorie() + ".");
		*/
		
		//EX3
		LunchBox economy = new LunchBox();
		economy.add(new Rice(200));
		economy.add(new Cabbage(100));
		economy.add(new PorkRib(250));
		//設定變數值
		economy.setPriceRatio(1.2);
		System.out.println("Total calories of an economy lunch box are " + economy.getCalorie());
		System.out.println("The price of an economy lunch box is " + economy.getPrice());
		
		LunchBox valuedChoice = new LunchBox();
		valuedChoice.add(new Rice(200));
		valuedChoice.add(new Egg(30));
		valuedChoice.add(new Carrot(100));
		valuedChoice.add(new PorkRib(300));
		valuedChoice.setPriceRatio(1.3);
		System.out.println("Total calories of a valued-choice lunch box are " + valuedChoice.getCalorie());
		System.out.println("The price of an valued-choice lunch box is " + valuedChoice.getPrice());
		
		//EX4
		System.out.println("便當economy比便當valued-choice更便宜嗎？" + (LunchBox.isCheaperThan(economy, valuedChoice)?"是":"否"));
		
	}
}
