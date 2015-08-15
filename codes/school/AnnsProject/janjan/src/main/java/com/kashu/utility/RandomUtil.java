package com.kashu.utility;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class RandomUtil {

	//@Autowired
	//ServletContext servletContext;
	//http://stackoverflow.com/questions/22096983/spring-mvc-read-file-from-src-main-resources
	// http://stackoverflow.com/questions/11210465/spring-mvc-get-file-under-web-inf-without-a-request
	
	@Autowired
	private ApplicationContext applicationContext;
	
	private String words;
	
	public String get_a_chinese_word(int length){
		String result = "";
		if(words==null){
			words = readTxtFile();
		}
		
		int beginIndex = 0;
		for(int i=0;i<length;i++){
			beginIndex = get_a_number(0,1849);
			result += words.substring(beginIndex, beginIndex +1);
		}
		return result;
	}
	
	public List<String> get_a_string_list(int length,int arraySize){
		List<String> list = new ArrayList<String>();
		for(int i=0;i<arraySize;i++){
			list.add(get_a_chinese_word(length));
		}
		return list;
	}
	
	//http://howtodoinjava.com/2013/10/06/how-to-read-data-from-inputstream-into-string-in-java/
	//http://www.mkyong.com/spring/spring-resource-loader-with-getresource-example/
	public String readTxtFile(){
		String result = null;
		//Resource resource = new ClassPathResource("classpath:chinese_words.txt");
		Resource resource = applicationContext.getResource("classpath:chinese_words.txt");
		InputStream in = null;
		try{
				in = resource.getInputStream();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(in!=null){
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	        StringBuilder out = new StringBuilder();
	        String line;
	        		try{
	        			while ((line = reader.readLine()) != null) {
	        					out.append(line);
	        						}
	        		}catch(Exception e){
	        						e.printStackTrace();
	        		}//end-try
	        		result=out.toString();
		}//end-if
		return result;
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
		//Date startDate = new Date(Timestamp.valueOf("2015-01-01 00:00:00").getTime());
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
