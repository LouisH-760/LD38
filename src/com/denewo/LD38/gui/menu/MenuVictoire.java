package com.denewo.LD38.gui.menu;

import com.denewo.LD38.Main;
import com.denewo.LD38.Musique;
import com.denewo.LD38.Time;
import com.denewo.LD38.dialogues.Dialogues;
import com.denewo.LD38.graphics.Animation;
import com.denewo.LD38.graphics.Screen;
import com.denewo.LD38.graphics.Texture;
import com.denewo.LD38.input.MouseInput;

public class MenuVictoire extends Menu{

	private int value = 1;
	private double time = 0;
	private boolean pass = false;
	
	@Override
	public void update() {
		
		if(MouseInput.click && pass) {
			MouseInput.click = false;
			Musique.sonClic.jouer();
			value++;
		}
		
		if (value == 1)
			Animation.terre.update();
		if (value == 4)
			Main.dialogue = Dialogues.credits_1;
		if (value == 5){
			Main.dialogue = null;
			Menu.changeMenu(menuPrincipal);
		}
		
		if (time >= 0)
			time += Time.getTime();
		if (time > 5){
			pass = true;
			time = -1;
			value++;
		}
	}

	@Override
	public void render(Screen screen) {
		
		switch (value) {
		case 1:
			screen.drawIMG(Animation.terre.getFrame(), Main.WIDTH/2 - 45, Main.HEIGHT/2 - 45);
			break;
		case 2:
			screen.drawIMG(Texture.pageFin1, 0, 0);
			break;
		case 3:
			screen.drawIMG(Texture.pageFin2, 0, 0);
			break;
		}
		
	}

	@Override
	public void sleep() {
		Musique.musiqueFin.stop();
	}

	@Override
	public void wakeUp() {
		Musique.musiqueFin.loop();
	}

}
