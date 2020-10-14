package com.denewo.LD38.gui.menu;

import com.denewo.LD38.Musique;
import com.denewo.LD38.graphics.Screen;
import com.denewo.LD38.graphics.Texture;
import com.denewo.LD38.gui.Bouton;
import com.denewo.LD38.input.MouseInput;

public class MenuPerdu extends Menu{

	Bouton boutonTryAgain = Bouton.boutonTryAgain;
	Bouton boutonQuitter = Bouton.boutonQuit;
	
	@Override
	public void update() {
		boutonQuitter.update();
		boutonTryAgain.update();
		
		if(boutonTryAgain.isHover() && MouseInput.click)
		{
			menuJeu.reset();
			Menu.changeMenu(menuDialogue);
			Musique.sonClic.jouer();
			MouseInput.click = false;
		}
		else if(boutonQuitter.isHover() && MouseInput.click)
		{
			Musique.sonClic.jouer();
			System.exit(0);
		}
	}

	@Override
	public void render(Screen screen) {
		screen.drawIMG(Texture.go, 0, 0);
		boutonQuitter.render(screen);
		boutonTryAgain.render(screen);
	}

	@Override
	public void sleep() {
		Musique.musiqueGO.close();
	}

	@Override
	public void wakeUp() {
		Musique.musiqueGO.loop();
		boutonTryAgain.setX(120);
		boutonTryAgain.setY(350);
		boutonQuitter.setX(660);
		boutonQuitter.setY(350);
	}

}
