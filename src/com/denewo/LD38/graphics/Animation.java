package com.denewo.LD38.graphics;

import java.util.ArrayList;

public class Animation {
	
	public static Animation playerMoveRight = new Animation(50).addFrame(Texture.playerMoveRight.getTexturesSimple());
	public static Animation playerMoveLeft = new Animation(50).addFrame(Texture.playerMoveLeft.getTexturesSimple());
	public static Animation playerJumpRight = new Animation(500).addFrame(Texture.playerJumpRight);
	public static Animation playerJumpLeft = new Animation(500).addFrame(Texture.playerJumpLeft);
	public static Animation playerFallRight = new Animation(500).addFrame(Texture.playerFallRight);
	public static Animation playerFallLeft = new Animation(500).addFrame(Texture.playerFallLeft);
	public static Animation playerStand = new Animation(200).addFrame(Texture.playerStand);
	public static Animation playerStandMenu = new Animation(400).addFrame(Texture.playerStandMenu);
	public static Animation theStar = new Animation(200).addFrame(Texture.theStar.getTexturesSimple());
	public static Animation ruby = new Animation(200).addFrame(Texture.ruby);
	public static Animation terre = new Animation(200).addFrame(Texture.terre.getTexturesSimple()).noRepeate();
	public static Animation explosions = new Animation(200).addFrame(Texture.explosion.getTexturesSimple()).noRepeate();
	
	public ArrayList<Texture> textures;
	private double wait;
	private double tmp;
	private int frame = 0;
	private boolean repeate = true;
	
	public Animation (double wait_ms){
		wait = wait_ms;
		tmp = System.currentTimeMillis();
		textures = new ArrayList<Texture>();
	}
	
	public void update () {
		if (repeate || frame != textures.size()-1)
			if (tmp + wait < System.currentTimeMillis()){
				tmp = System.currentTimeMillis();
				if (++frame >= textures.size()) frame = 0;
			}
	}
	
	public Texture getFrame () {
		return textures.get(frame);
	}
	
	public void setFrame (int number) {
		if (number >= textures.size())
			System.err.println("La texture portant ce nombre n'existe pas !");
		else
			frame = number;
	}
	
	public Animation addFrame (Texture texture) {
		textures.add(texture);
		return this;
	}
	
	public Animation addFrame (Texture[] texture) {
		for (int i = 0; i < texture.length; i++)
			textures.add(texture[i]);
		return this;
	}
	
	public void delFrame (int number) {
		if (number >= textures.size())
			System.err.println("La texture portant ce nombre n'existe pas !");
		else
			textures.remove(number);
	}
	
	public Animation noRepeate () {
		repeate = false;
		return this;
	}
	
}
