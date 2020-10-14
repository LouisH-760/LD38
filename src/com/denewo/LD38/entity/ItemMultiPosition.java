package com.denewo.LD38.entity;

import java.util.ArrayList;

import com.denewo.LD38.graphics.Animation;

public class ItemMultiPosition extends Collectable{

	private ArrayList<Integer> position = new ArrayList<Integer>(); 
	
	public static ItemMultiPosition ruby = (ItemMultiPosition) new ItemMultiPosition(200, 100, 17, 17).setAni(Animation.ruby);
	
	public ItemMultiPosition(double x, double y, int width, int height) {
		super(x, y, width, height);
	}
	
	public ItemMultiPosition addPosition (int x, int y){
		position.add(x);
		position.add(y);
		
		return this;
	}
	
	public void rmAllPosition (){
		position = new ArrayList<Integer>();
	}
	
	public boolean next (){
		
		if (position.size() < 2)
			return false;
		
		x = position.get(0);
		position.remove(0);
		y = position.get(0);
		position.remove(0);
		return true;
		
	}

}
