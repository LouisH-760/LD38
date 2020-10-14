package com.denewo.LD38.collision;

import com.denewo.LD38.entity.Entity;

public interface Collisionable {
	
	BoxCollider box = null;
	
	public BoxCollider getBoxCollider ();
	
	public void setBoxCollider (BoxCollider box);
	
	public boolean collision (Entity entity);
	
	public int[] correctPosition(BoxCollider collision, double xC, double yC);

}
