package com.denewo.LD38.gui;

import com.denewo.LD38.graphics.Screen;
import com.denewo.LD38.graphics.Texture;
import com.denewo.LD38.input.MouseInput;

public class BoutonEphemere extends Bouton{
	
	private Texture[] textures = new Texture[3];

	public BoutonEphemere(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void render(Screen screen) {
		if (hover)
			if (MouseInput.click)
				screen.drawIMG(textures[1], x, y);
			else
				screen.drawIMG(textures[2], x, y);
		else
			screen.drawIMG(textures[0], x, y);		
	}
	
	public BoutonEphemere setTextureHover (Texture texture) {
		textures[2] = texture;
		return this;
	}
	
	public BoutonEphemere setTextureClick (Texture texture) {
		textures[1] = texture;
		return this;
	}

	public BoutonEphemere setTextureNormal (Texture texture) {
		textures[0] = texture;
		return this;
	}

}
