package com.denewo.LD38.gui.menu;

import java.util.Random;

import com.denewo.LD38.Main;
import com.denewo.LD38.Musique;
import com.denewo.LD38.dialogues.Dialogues;
import com.denewo.LD38.etoiles.Etoiles;
import com.denewo.LD38.graphics.Animation;
import com.denewo.LD38.graphics.Screen;
import com.denewo.LD38.graphics.Texture;
import com.denewo.LD38.gui.Bouton;
import com.denewo.LD38.input.MouseInput;

public class MenuPrincipal extends Menu {
	Random rand = new Random();
	Bouton boutonSon = Bouton.boutonSon;
	Bouton boutonPlay = Bouton.boutonPlay;
	Bouton boutonQuitter = Bouton.boutonQuit;
	
	private Musique musique = Musique.musiqueMenu;
	
	@Override
	public void update() {
		boutonSon.update();
		boutonPlay.update();
		boutonQuitter.update();
		Animation.theStar.update();
		Animation.playerStandMenu.update();
		if(boutonPlay.isHover() && MouseInput.click)
		{
			menuJeu.reset();
			Menu.menuDialogue.setDialogues(Dialogues.dialogues1).setToken(0);
			Menu.changeMenu(menuDialogue);
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
					if(i%2 == 0)
						screen.drawIMG(Texture.star[Etoiles.size[i][j]], i*Etoiles.pas[i][j], j*Etoiles.pas[i][j]);
					else
						screen.drawIMG(Texture.star[Etoiles.size[i][j]], i*Etoiles.pas2[i][j], j*Etoiles.pas2[i][j]);
			}
			
		}
		
		boutonSon.render(screen);
		boutonPlay.render(screen);
		boutonQuitter.render(screen);
		
		screen.drawIMG(Texture.tree, 38, 267, 8);
		screen.drawIMG(Animation.playerStandMenu.getFrame(), 802, 472, 6);
		screen.drawIMG(Texture.title, 153-29,181-43);
		screen.drawIMG(Animation.theStar.getFrame(), 700, 30, 10);
		
		for (int x = 0; x <= Main.WIDTH/32; x++)
			screen.drawIMG(Texture.block[9],x*32 ,Main.HEIGHT-32);
		
	}

	@Override
	public void sleep() {
		musique.stop();
	}

	@Override
	public void wakeUp() {
		musique.loop();
		
		boutonSon.setX(1000 - 41);
		boutonSon.setY(0);
		boutonPlay.setX(500 - (211/2));
		boutonPlay.setY(300 - (41/2));
		boutonQuitter.setX(500 - (211/2));
		boutonQuitter.setY(300-(41/2)+41+10);
	}

	
	
}
