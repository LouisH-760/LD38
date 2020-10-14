package com.denewo.LD38.gui;

import com.denewo.LD38.entity.RandU;
import com.denewo.LD38.graphics.Texture;
import com.denewo.LD38.input.MouseInput;

public abstract class Bouton implements RandU {
	
	protected int x;//coordonées X
	protected int y;//coordonées Y
	protected int width;//largeur
	protected int height;//hauteur
	
	protected boolean hover = false;
	
	

	public static BoutonSwitch boutonSon = new BoutonSwitch(200, 200, 41, 41).setTextureAcive(Texture.boutonSon[0]).setTextureNonActive(Texture.boutonSon[1]);
	public static BoutonEphemere boutonPlay = new BoutonEphemere(400, 400, 211, 41).setTextureNormal(Texture.boutonPlay[0]).setTextureClick(Texture.boutonPlay[1]).setTextureHover(Texture.boutonPlay[2]);
	public static BoutonEphemere boutonQuit = new BoutonEphemere(400, 400, 211, 41).setTextureNormal(Texture.boutonQuitter[0]).setTextureClick(Texture.boutonQuitter[1]).setTextureHover(Texture.boutonQuitter[2]);
	public static BoutonEphemere boutonResume = new BoutonEphemere(400, 400, 211, 41).setTextureNormal(Texture.boutonResume[0]).setTextureClick(Texture.boutonResume[1]).setTextureHover(Texture.boutonResume[2]);
	public static BoutonEphemere boutonContinue= new BoutonEphemere(400, 400, 211, 41).setTextureNormal(Texture.boutonContinue[0]).setTextureClick(Texture.boutonContinue[1]).setTextureHover(Texture.boutonContinue[2]);
	public static BoutonEphemere bouton3points = new BoutonEphemere(400, 400, 211, 41).setTextureNormal(Texture.bouton3points[0]).setTextureClick(Texture.bouton3points[1]).setTextureHover(Texture.bouton3points[2]);
	public static BoutonEphemere boutonTryAgain = new BoutonEphemere(400, 400, 211, 41).setTextureNormal(Texture.boutonTryAgain[0]).setTextureClick(Texture.boutonTryAgain[1]).setTextureHover(Texture.boutonTryAgain[2]);
	
	public Bouton(int x, int y, int width, int height){ //crée un bouton avec des coordonées X et Y, et sa hauteur et largeur.
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Boolean verifCollision(){
	
		int mx = (int)MouseInput.mouseX;
		int my = (int)MouseInput.mouseY;
				
		if (mx < x + width && mx > x && my > y && my < y + height)
			return true;
		return false;
	}
	

	@Override
	public void update() {
		hover = verifCollision();
	}

	public boolean isHover() {
		return hover;
	}

	public void setHover(boolean hover) {
		this.hover = hover;
	}

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
}
