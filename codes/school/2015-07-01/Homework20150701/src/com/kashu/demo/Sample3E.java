package com.kashu.demo;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Sample3E extends Applet {
	Image img,img2;
	int x=0,y=0;
	
	Thread timer = new Thread(){
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};

	
	
	@Override
	public void init() {
		System.out.println("init()");
		System.out.println("getDocumentBase():" + getDocumentBase());
		img = getImage(getDocumentBase(),"image01.jpg");
		img2 = getImage(getDocumentBase(),"image02.jpg");		
		//addMouseListener(mouseListener);
		timer.start();
		super.init();
	}

	@Override
	public void start() {
		
		super.start();
	}

	@Override
	public void stop() {
		
		super.stop();
	}

	@Override
	public void destroy() {
		
		super.destroy();
	}
	
	public void paint(Graphics g){
		if(img==null || img2==null){
			System.out.println("Image not found");
		}else{
			g.drawImage(img, 0,0, this);
			g.drawImage(img2, x,y, this);
		}
		g.setColor(Color.red);
		
	}

}
