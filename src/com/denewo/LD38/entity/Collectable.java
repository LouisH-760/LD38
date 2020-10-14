package com.denewo.LD38.entity;

import com.denewo.LD38.collision.BoxCollider;
import com.denewo.LD38.collision.Collisionable;
import com.denewo.LD38.graphics.Animation;
import com.denewo.LD38.graphics.Screen;
import com.denewo.LD38.graphics.Texture;

public class Collectable extends Entity implements Collisionable{
	
	private int value = 0;;
	private Animation ani;
	private Texture texture;
	private BoxCollider box;
	
	public static Collectable theStar = new Collectable(0,0,17,17).setAni(Animation.theStar).setValue(1);

	public Collectable(double x, double y, int width, int height) {
		super(x, y, width, height);
		box = new BoxCollider (0, 0, width, height);
	}

	@Override
	public void update() {
		if (ani != null)
			ani.update();
	}

	@Override
	public void render(Screen screen) {
		if (ani != null)
			screen.drawIMG(ani.getFrame(), (int)x, (int)y);
		else if (texture != null)
			screen.drawIMG(texture, (int)x, (int)y);
	}

	public int getValue() {
		return value;
	}

	public Collectable setValue(int value) {
		this.value = value;
		return this;
	}

	public Animation getAni() {
		return ani;
	}

	public Collectable setAni(Animation ani) {
		this.ani = ani;
		return this;
	}

	public Texture getTexture() {
		return texture;
	}

	public Collectable setTexture(Texture texture) {
		this.texture = texture;
		return this;
	}

	@Override
	public BoxCollider getBoxCollider() {
		return box;
	}

	@Override
	public void setBoxCollider(BoxCollider box) {
		this.box = box;
	}

	@Deprecated
	@Override
	public boolean collision(Entity entity) {
		return false;
	}

	@Deprecated
	@Override
	public int[] correctPosition(BoxCollider collision, double xC, double yC) {
		return null;
	}

}
