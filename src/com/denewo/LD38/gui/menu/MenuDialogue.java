package com.denewo.LD38.gui.menu;

import com.denewo.LD38.Main;
import com.denewo.LD38.Musique;
import com.denewo.LD38.dialogues.Dialogues;
import com.denewo.LD38.graphics.Screen;
import com.denewo.LD38.graphics.Texture;
import com.denewo.LD38.gui.Bouton;
import com.denewo.LD38.input.MouseInput;

public class MenuDialogue extends Menu{

	Musique musique = Musique.musiqueDialogues;
	Bouton bouton = Bouton.bouton3points;
	
	Dialogues[][] dialogue;
	int token = 0;
	
	public MenuDialogue () {
		bouton.setX(400);
		bouton.setY(400);
	}
	
	@Override
	public void update() {
		
		bouton.update();
		if(bouton.isHover() && MouseInput.click) {
			MouseInput.click = false;
			Musique.sonClic.jouer();
			if (++token<dialogue.length){
				Main.dialogue = dialogue[token];
				if (token == dialogue.length-1)
					bouton = Bouton.boutonContinue;
			} else {
				Main.dialogue = null;
				Menu.changeMenu(menuJeu);
				Musique.sonClic.jouer();
			}
		} else Musique.sonClic.setready();
	}

	@Override
	public void render(Screen screen) {
		
		for (int x = 0; x <= Main.WIDTH/Texture.fond.getWidth(); x++)
			for (int y = 0; y <= Main.HEIGHT/Texture.fond.getHeight(); y++)
				screen.drawIMG(Texture.fond, x*Texture.fond.getWidth(), y*Texture.fond.getHeight());
		
		bouton.render(screen);
	}

	@Override
	public void sleep() {
		musique.stop();
	}
	
	public MenuDialogue setDialogues (Dialogues[][]dialogue) {
		this.dialogue = dialogue;
		return this;
	}

	@Override
	public void wakeUp() {
		musique.loop();
		bouton = Bouton.bouton3points;
	}

	public MenuDialogue setToken (int token){
		if (token >= dialogue.length) return this;
		this.token = token;
		Main.dialogue = dialogue[token];
		return this;
	}
	
}
