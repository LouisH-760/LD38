package com.denewo.LD38.gui.menu;

import java.util.Random;

import com.denewo.LD38.Musique;
import com.denewo.LD38.etoiles.Etoiles;
import com.denewo.LD38.graphics.Screen;
import com.denewo.LD38.graphics.Texture;
import com.denewo.LD38.gui.Bouton;
import com.denewo.LD38.input.MouseInput;

public class MenuPause extends Menu{
	Random rand = new Random();
	Bouton boutonSon = Bouton.boutonSon;
	Bouton boutonResume = Bouton.boutonResume;
	Bouton boutonQuitter = Bouton.boutonQuit;
	
	private Musique musique = Musique.musiqueMenu;
	

	@Override
	public void update() {
		boutonSon.update();
		boutonResume.update();
		boutonQuitter.update();
		if(boutonResume.isHover() && MouseInput.click)
		{
			Menu.changeMenu(menuJeu);
			Musique.sonClic.jouer();
			MouseInput.click = false;
		}
		else if(boutonQuitter.isHover() && MouseInput.click)
		{
			Musique.sonClic.jouer();
			System.exit(0);
		}
		else
			Musique.sonClic.setready();
		
	}

	@Override
	public void render(Screen screen) {
		for(int i = 1; i<1000/32; i++)
		{
			for(int j = 1; j<600/32; j++)
			{
				if(gen.etoiles[i][j] == 1)
					if(gen.etoiles[i][j] == 1)
						if(i%2 == 0)
							screen.drawIMG(Texture.star[Etoiles.size[i][j]], i*Etoiles.pas[i][j], j*Etoiles.pas[i][j]);
						else
							screen.drawIMG(Texture.star[Etoiles.size[i][j]], i*Etoiles.pas2[i][j], j*Etoiles.pas2[i][j]);
				}
			
		}
		boutonSon.render(screen);
		boutonResume.render(screen);
		boutonQuitter.render(screen);
		
	}
	@Override
	public void sleep() {
		musique.stop();
	}
	@Override
	public void wakeUp() {
		musique.loop();
		Musique.musiqueJeu.stop();
		
		boutonSon.setX(1000 - 41);
		boutonSon.setY(0);
		boutonResume.setX(500 - (211/2));
		boutonResume.setY(300 - (41/2));
		boutonQuitter.setX(500 - (211/2));
		boutonQuitter.setY(300-(41/2)+41+10);
	}

}
