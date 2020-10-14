package com.denewo.LD38.entity;

import com.denewo.LD38.Time;
import com.denewo.LD38.collision.BoxCollider;
import com.denewo.LD38.collision.Collisionable;
import com.denewo.LD38.graphics.Screen;
import com.denewo.LD38.graphics.Texture;

public class Block extends Entity implements Collisionable, Gravity{

	private BoxCollider box;
	private boolean enabled = false;
	private boolean fall = true;
	private double fallValue = 0;
	
	private int version = 0;
	
	private Texture texture;
	
	public Block(double x, double y) {
		super(x, y, 32, 32);
		
		box = new BoxCollider(0, 0, width, height);
		box.setSolid(true);
		texture = Texture.block[0];
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
	public boolean collision(Entity entity) {return false;}

	@Deprecated
	@Override
	public int[] correctPosition(BoxCollider collision, double d, double e) {return null;}

	@Override
	public void gravity() {
		if (fall && enabled)
			if (fallValue == 0)
				fallValue = 1;
			else
				fallValue += 200 * Time.getTime();
		else
			fallValue = 0;
		
		y += fallValue * Time.getTime();
	}

	public Texture getTexture() {
		return texture;
	}

	public Block setTexture(Texture texture) {
		this.texture = texture;
		return this;
	}

	@Override
	public void update() {
		gravity();
	}

	@Override
	public void render(Screen screen) {
		screen.drawIMG(texture, (int)x-box.getX(), (int)y);
	}

	public int getVersion() {
		return version;
	}

	public Block setVersion(int version) {
		this.version = version;
		
		box.setX(0);
		box.setY(0);
		box.setWidth(32);
		box.setHeight(32);
		
		texture = Texture.block[version];
		
		switch (version){
		case 0:
		case 2:
			box.setX(2);
			break;
		case 1:
		case 3:
			break;
		case 4:
			box.setX(2);
			box.setHeight(18);
			break;
		case 12:
			box.setX(1);
			box.setWidth(34);
			box.setHeight(18);
			break;
		case 13:
			box.setSolid(false);
			box.setX(4);
			box.setY(-3);
			break;
		case 14:
			box.setY(1);
			box.setHeight(3);
			break;
		case 15:
			box.setSolid(false);
			break;
		}
		
		return this;
	}
	
	public void setFalling () {
		enabled = true;
	}

}
