package com.kashu.test.others;

import com.kashu.domain.User;

public class HashCodeTest {
	public static void main(String[] args){
		User user1 = new User();
		User user2 = new User();
		if(user1.equals(user2)){
			System.out.println("user1 = user2");
		}else{
			System.out.println("user1 not = user2");
		}
	}
}
