package com.denewo.LD38.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {
	
	public static double mouseX = 0;
	public static double mouseY = 0;
	
	public static boolean click = false;
	
	@Override
	public void mouseClicked(MouseEvent paramMouseEvent) {
//		System.out.println("click : " + paramMouseEvent.getX() + ":" + paramMouseEvent.getY());
		
	}

	@Override
	public void mousePressed(MouseEvent paramMouseEvent) {
//		System.out.println("press : " + paramMouseEvent.getX() + ":" + paramMouseEvent.getY());
		click = true;
	}

	@Override
	public void mouseReleased(MouseEvent paramMouseEvent) {
//		System.out.println("release : " + paramMouseEvent.getX() + ":" + paramMouseEvent.getY());
		click = false;
	}

	@Override
	public void mouseEntered(MouseEvent paramMouseEvent) {
		//System.out.println("enter : " + paramMouseEvent.getX() + ":" + paramMouseEvent.getY());
	}

	@Override
	public void mouseExited(MouseEvent paramMouseEvent) {
		//System.out.println("exit : " + paramMouseEvent.getX() + ":" + paramMouseEvent.getY());
	}

	@Override
	public void mouseDragged(MouseEvent paramMouseEvent) {
	}

	@Override
	public void mouseMoved(MouseEvent paramMouseEvent) {
		mouseX = paramMouseEvent.getX();
		mouseY = paramMouseEvent.getY();
	}
	
	//MouseInfo.getPointerInfo().getLocation().getX();
	//MouseInfo.getPointerInfo().getLocation().getY();
}
