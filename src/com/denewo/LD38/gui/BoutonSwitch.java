package com.denewo.LD38.gui;

import com.denewo.LD38.graphics.Screen;
import com.denewo.LD38.graphics.Texture;
import com.denewo.LD38.input.MouseInput;

public class BoutonSwitch extends Bouton {

	private boolean active = true;
	private boolean resetActive = true;
	
	private Texture[] textures = new Texture[2];
	
	public BoutonSwitch(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update() {
		super.update();
		if (hover && MouseInput.click && resetActive) {
			active = !active;
			resetActive = false;
		}
		
		if (!hover || !MouseInput.click)
			resetActive = true;
	}
	
	@Override
	public void render(Screen screen) {
		if (active)
			screen.drawIMG(Texture.boutonSon[0], x, y);
		else
			screen.drawIMG(Texture.boutonSon[1], x, y);
	}
	
	public BoutonSwitch setTextureNonActive (Texture texture) {
		textures[1] = texture;
		return this;
	}
	
	public BoutonSwitch setTextureAcive (Texture texture) {
		textures[0] = texture;
		return this;
	}

	public boolean isActive() {
		return active;
	}
	
}
