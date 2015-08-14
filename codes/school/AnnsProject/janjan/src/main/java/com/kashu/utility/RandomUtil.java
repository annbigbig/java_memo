package com.kashu.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RandomUtil {
	
	public String get_a_chinese_word(int length){
		return null;
	}
	
	public Integer get_a_number(int min,int max){
		int diff = max - min + 1;
		return min + (int)(diff*Math.random());
	}
	
	public List<Integer> get_IntegerList(int min,int max, int arraySize){
		List<Integer> intList = new ArrayList<Integer>();
		for(int i=0;i<arraySize;i++){
			intList.add(get_a_number(min,max));
		}
		return intList;
	}
	
	// http://www.leveluplunch.com/java/examples/generate-random-date/
	public Date get_a_date(Date startDate,Date endDate){
		Long begin = startDate.getTime();
		Long end = endDate.getTime();
		Long diff = end - begin +1;
		Long afterRandomDiff = (long)(Math.random()*diff);
		System.out.println("begin = " + begin);
		System.out.println("end = " + end);
		System.out.println("diff = " + diff);
		System.out.println("afterRandomDiff = " + afterRandomDiff);
		Date randomDate = new Date(begin + afterRandomDiff);
		System.out.println("randomDate=" + randomDate);
		return randomDate;
	}
	
	public List<Date> get_dateList(Date startDate,Date endDate,int arraySize){
		List<Date> dateList = new ArrayList<Date>();
		for(int i=0;i<arraySize;i++){
			dateList.add(get_a_date(startDate,endDate));
		}
		return dateList;
	}
}
