package com.kashu.demo;

public abstract class Food {
	private int amount;
	private int calorie;
	private int unitCost;
	
	public Food(int amount){
		this.amount = amount;
	}
	
	public void setCaloriePerGram(int cal){
		this.calorie = cal;
	}
	
	public int getAmount(){
		return this.amount;
	}
	
	public int getCalorie(){
		return this.calorie;
	}
	
	void setUnitCost(int c){
		unitCost = c;
	}
	
	int getCost(){
		return unitCost * amount;
	}
}