package com.kashu.demo;

import javax.swing.JOptionPane;

public class Square {

	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("請輸入一個整數");
		int n = Integer.parseInt(s);
		int nn = n*n;
		String message = "整數" + s + "的平方是" + nn;
		String title = "標題: 計算平方";
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);

	}

}