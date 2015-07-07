package com.kashu.demo;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Exam02 extends Applet {
	Image img,img2;
	int x=0,y=0;
	
	@Override
	public void init() {
		System.out.println("init()");
		System.out.println("getDocumentBase():" + getDocumentBase());
		img = getImage(getDocumentBase(),"image01.jpg");
		img2 = getImage(getDocumentBase(),"image02.jpg");
		super.init();
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				Exam02.this.repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
		});
	}

	@Override
	public void start() {
		System.out.println("start()");
		super.start();
	}

	@Override
	public void stop() {
		System.out.println("stop()");
		super.stop();
	}

	@Override
	public void destroy() {
		System.out.println("destroy()");
		super.destroy();
	}

	public void paint(Graphics g){
		 g.drawString("Welcome in Java Applet.",40,20);
		 //g.drawImage(img, 0,0 , this);
		 g.drawImage(img2, x,y , this);
	}
}
