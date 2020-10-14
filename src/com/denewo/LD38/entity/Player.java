package com.denewo.LD38.entity;

import com.denewo.LD38.Musique;
import com.denewo.LD38.Time;
import com.denewo.LD38.collision.BoxCollider;
import com.denewo.LD38.collision.Collisionable;
import com.denewo.LD38.graphics.Animation;
import com.denewo.LD38.graphics.Screen;
import com.denewo.LD38.gui.menu.Menu;
import com.denewo.LD38.input.KeyInput;

public class Player extends Entity implements Collisionable{
	
	private BoxCollider box;
	
	private boolean fall = false;
	private double fallValue = 0;
	
	private double jumpValue = 0;
	
	private double xTmp = 0;
	private double yTmp = 0;
	
	private Animation animation;
	
	public static Player player = new Player (492,100,16,16);
	
	public Player (int x, int y, int width, int height) {
		super(x, y, width, height);
		animation = Animation.playerStand;
		box = new BoxCollider(0, 0, width, height);
	}
	
	public void setBoxCollider (BoxCollider box) {
		this.box = box;
	}
	
	public BoxCollider getBoxCollider () {
		return box;
	}
	
	public void update () {
		
		Musique.sonGet.setready();
		
		x += xTmp;
		y += yTmp;
		
		if (xTmp < 0)
			animation = Animation.playerMoveLeft;
		else if (xTmp > 0)
			animation = Animation.playerMoveRight;
		
		if (yTmp < 0)
			if (xTmp < 0)
				animation = Animation.playerJumpLeft;
			else
				animation = Animation.playerJumpRight;
		else if (yTmp > 0)
			if (xTmp < 0)
				animation = Animation.playerFallLeft;
			else
				animation = Animation.playerFallRight;
		
		if (!KeyInput.touches[39] && !KeyInput.touches[37] && !KeyInput.touches[38] && !fall && !KeyInput.touches[40])
			animation = Animation.playerStand;
		
		animation.update();
		xTmp = 0;
		yTmp = 0;
		
		if (KeyInput.touches[39])
			xTmp += 75 * Time.getTime();
		if (KeyInput.touches[37])
			xTmp -= 75 * Time.getTime();
		if (KeyInput.touches[38] && !fall){
			jumpValue = 200;
			Musique.sonJump.jouer();
		} else {
			Musique.sonJump.setready();
		}
			
		if (KeyInput.touches[40])
			jumpValue = 0;
		
		if (jumpValue < 0) jumpValue = 0;
		
		yTmp -= jumpValue*Time.getTime();
		jumpValue -= jumpValue*Time.getTime();
		
		
		if (fall){
			if (fallValue == 0)
				fallValue = 10;
			else if (fallValue < 9000){
				fallValue += 100 * Time.getTime();
			}
		}else{
			fallValue = 0;
			if (jumpValue < 40)
				jumpValue = 0;
		}
		
		yTmp += fallValue * Time.getTime();
		
		if (yTmp > 0)
			fallValue += 200 * Time.getTime();

		fall = true;
		
	}
	
	public void move (int[] deplacement) {
		x += deplacement[0];
		y += deplacement[1];
	}
	
	public void render (Screen screen) {
		screen.drawIMG(animation.getFrame(), (int)x, (int)y, 1);
	}

	@Override
	public boolean collision(Entity entity) {
		
//		if ((collision.getX() + xC >= x + box.getX() && collision.getX() + xC <= x + box.getX() + box.getWidth())
//				|| (collision.getX()  + xC + collision.getWidth() <= x + box.getX() + box.getWidth() && collision.getX() + xC + collision.getWidth() >= x + box.getX()))
//			if ((collision.getY() + yC >= y + box.getY() && collision.getY() + yC <= y + box.getY() + box.getHeight())
//					|| (collision.getY() + yC + collision.getHeight() <= y + box.getY() + box.getHeight() && collision.getY() + yC + collision.getHeight() >= y + box.getY())){
//				
//		if ((box.getX() + x >= xC + collision.getX() && box.getX() + x <= xC + collision.getX() + collision.getWidth())
//				|| (box.getX()  + x + box.getWidth() <= xC + collision.getX() + collision.getWidth() && box.getX() + x + box.getWidth() >= x + box.getX()))
//			if ((box.getY() + y >= yC + collision.getY() && box.getY() + y <= yC + collision.getY() + collision.getHeight())
//					|| (box.getY() + y + box.getHeight() <= yC + collision.getY() + collision.getHeight() && box.getY() + y + box.getHeight() >= yC + collision.getY())){
				
				
//				if (collision.isSolid()){
//					if (collision.getY() + yC < box.getY() + y + box.getHeight())
//						fall = false;
//				}
		
//		if (((box.getY() + y > collision.getY() + yC && box.getY() + y < collision.getY() + yC + collision.getHeight())
//				|| (box.getY() + y + box.getHeight() > collision.getY() + yC && box.getY() + y + box.getHeight() < collision.getY() + yC + collision.getHeight()))){
//			if (box.getX() + x > collision.getX() + xC && box.getX() + x < collision.getX() + xC + collision.getWidth()){
//				
//			}
//			if (box.getX() + x + box.getWidth() > collision.getX() + xC && box.getX() + x + box.getWidth() < collision.getX() + xC + collision.getWidth()){
//				
//			}
//		}
		
//		if (((box.getY() + y > collision.getY() + yC && box.getY() + y < collision.getY() + yC + collision.getHeight())
//				|| (box.getY() + y + box.getHeight() > collision.getY() + yC && box.getY() + y + box.getHeight() < collision.getY() + yC + collision.getHeight()))
//			&&
//			(((box.getX() + x > collision.getX() + xC && box.getX() + x < collision.getX() + xC + collision.getWidth())
//					|| (box.getX() + x + box.getWidth() > collision.getX() + xC && box.getX() + x + box.getWidth() < collision.getX() + xC + collision.getWidth()))))
//		{
//			if (box.getY() + y > collision.getY() + yC && box.getY() + y < collision.getY() + yC + collision.getHeight())
//				canGoU = false;
//			if(box.getY() + y + box.getHeight() > collision.getY() + yC && box.getY() + y + box.getHeight() < collision.getY() + yC + collision.getHeight())
//				canGoD = fall = false;
//			if(box.getX() + x > collision.getX() + xC && box.getX() + x < collision.getX() + xC + collision.getWidth())
//				canGoL = false;
//			if(box.getX() + x + box.getWidth() > collision.getX() + xC && box.getX() + x + box.getWidth() < collision.getX() + xC + collision.getWidth())
//				canGoR = false;
//			
//			if ((!canGoU && !canGoD && !canGoL) ||  (!canGoD && !canGoL) ||  (!canGoU && !canGoL))
//				x+=1;
//			if ((!canGoD && !canGoL && !canGoR) ||  (!canGoD && !canGoR) ||  (!canGoD && !canGoL))
//				y-=1;
//			if ((!canGoL && !canGoR && !canGoU) ||  (!canGoU && !canGoL) ||  (!canGoU && !canGoR))
//				y+=1;
//			if ((!canGoR && !canGoU && !canGoD) ||  (!canGoD && !canGoR) ||  (!canGoU && !canGoR))
//				x-=1;
//			
//			
//			return true;
//		}
		
		
		
		BoxCollider collision = ((Collisionable)entity).getBoxCollider();
		double xC = entity.getX();
		double yC = entity.getY();
		
		if (((box.getY() + y > collision.getY() + yC && box.getY() + y < collision.getY() + yC + collision.getHeight())
				|| (box.getY() + y + box.getHeight() > collision.getY() + yC && box.getY() + y + box.getHeight() < collision.getY() + yC + collision.getHeight()))
			&&
			(((box.getX() + x + xTmp > collision.getX() + xC && box.getX() + x + xTmp < collision.getX() + xC + collision.getWidth())
					|| (box.getX() + x + xTmp + box.getWidth() > collision.getX() + xC && box.getX() + x + xTmp + box.getWidth() < collision.getX() + xC + collision.getWidth()))))
		{
			if (collision.isSolid()) {
				if (xTmp < 0)
					x = collision.getX() + collision.getWidth() + xC - box.getX(); 
				else
					x = collision.getX() + xC - box.getWidth() - box.getX();
				
				xTmp = 0;
			} else if (entity instanceof Collectable)
				collectableEvent(entity,((Collectable)entity).getValue());

			return true;
		}
		
		if (((box.getY() + y + yTmp> collision.getY() + yC && box.getY() + y + yTmp< collision.getY() + yC + collision.getHeight())
				|| (box.getY() + y + yTmp + box.getHeight() > collision.getY() + yC && box.getY() + y + yTmp + box.getHeight() < collision.getY() + yC + collision.getHeight()))
			&&
			(((box.getX() + x > collision.getX() + xC && box.getX() + x < collision.getX() + xC + collision.getWidth())
					|| (box.getX() + x + box.getWidth() > collision.getX() + xC && box.getX() + x + box.getWidth() < collision.getX() + xC + collision.getWidth()))))
		{
			if (collision.isSolid()) {
				if (yTmp < 0){
					y = collision.getY() + collision.getHeight() + yC - box.getY(); 
					jumpValue = 0;
				}else{
					y = collision.getY() + yC - box.getHeight() - box.getY();
					fall = false;
				}
				yTmp = 0;
				
			} else if (entity instanceof Collectable)
				collectableEvent(entity,((Collectable)entity).getValue());
			
			
			
			return true;
		}
				
		return false;
	}

	@Deprecated
	@Override
	public int[] correctPosition(BoxCollider collision, double xC, double yC) {
		int xc = 0;
		int yc = 0;
		
//		if (y + box.getY() + box.getHeight() < collision.getY() + yC + collision.getHeight() && y + box.getY() + box.getHeight() > collision.getY() + yC)
//			yc = (int) (collision.getY() + yC - y - box.getY() - box.getHeight());
//		if (y + box.getY() < collision.getY() + yC + collision.getHeight() && y + box.getY() > collision.getY() + yC)
//			yc = (int) (collision.getY() + collision.getHeight() + yC - y - box.getY());
//		if (x + box.getX() + box.getWidth() < collision.getX() + xC + collision.getWidth() && x + box.getX() + box.getWidth() > collision.getX() + xC)
//			xc = (int) (collision.getX() + xC - x - box.getWidth() - box.getX());
//		if (x + box.getX() < collision.getX() + xC + collision.getWidth() && x + box.getX() > collision.getX() + xC)
//			xc = (int) (collision.getX() + xC + collision.getWidth() - x - box.getX());
//		if (!collision(collision, xC, yC))
//			return new int[] {0,0};
//		
//		if (collision.getY() + yC < y + box.getY() + box.getHeight() && collision.getY() + yC > y + box.getY())
//			yc -= y + box.getY() + box.getHeight() - collision.getY() - yC ;
//		else if (collision.getY() + yC + collision.getHeight() > y + box.getY() && collision.getY() + yC + collision.getHeight() < y + box.getY())
//			yc += collision.getY() + yC + collision.getHeight() - y - box.getY();
//		else if (collision.getX() + xC < x + box.getX() + box.getWidth() && collision.getX() + xC > x + box.getX())
//			xc -= x + box.getX() + box.getWidth() - collision.getX() - xC;
//		else if (collision.getX() + xC + collision.getWidth() > x + box.getX() && collision.getX() + xC + collision.getWidth() < x + box.getX())
//			xc += collision.getX() + xC + collision.getWidth() - x - box.getX();
		
		return new int[] {xc,yc};
	}
	
	private void collectableEvent (Entity entity, int value) {
		
		Musique.sonGet.jouer();
		
		if (entity instanceof ItemMultiPosition){
			ItemMultiPosition e = (ItemMultiPosition)entity;
			if (!e.next()){
				Menu.menuJeu.levelUp();
				Menu.changeMenu(Menu.menuDialogue);
			}
		}
		
		Collectable e = (Collectable) entity;
		switch (e.getValue()) {
			case 1:
				Menu.menuJeu.setEnd();
//				Menu.menuJeu.levelUp();
//				Menu.changeMenu(Menu.menuDialogue);
				break;
		}
		
	}
	
}
