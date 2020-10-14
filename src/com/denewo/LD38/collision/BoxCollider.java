package com.denewo.LD38.collision;

public class BoxCollider {

	private int x;
	private int y;
	private int width;

	private int height;
	
	private boolean solid = false;
	
	public BoxCollider (int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean isSolid () {
		return solid;
	}
	
	public void setSolid (boolean solid) {
		this.solid = solid;
	}
	
//	public boolean collision (BoxCollider box) {
//		if ((box.getX() >= x && box.getX() <= x + width) || (box.getX() + box.getWidth() <= x + width && box.getX() + box.getWidth() >= x))
//			if ((box.getY() >= y && box.getY() <= y + height) || (box.getY() + box.getHeight() <= y + height && box.getY() + box.getHeight() >= y))
//				return true;
//		return false;
//	}
//	
//	public int[] correctPosition (BoxCollider box) {
//		int xc = 0;
//		int yc = 0;
//		
//		if (x+width < box.getX()+box.getWidth() && x+width > box.getX())
//			xc = box.getX() - x - width;
//		if (x < box.getX() + box.getWidth() && x > box.getX())
//			xc = box.getX() + box.getWidth() - x;
//		if (y+height < box.getY()+box.getHeight() && y+height > box.getY())
//			yc = box.getY() - y - height;
//		if (y < box.getY() + box.getHeight() && y > box.getY())
//			yc = box.getY() + box.getHeight() - y;
//		
//		
//		return new int[] {xc,yc};
//	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
