package com.denewo.LD38.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.denewo.LD38.Main;
import com.denewo.LD38.gui.menu.Menu;

public class KeyInput extends KeyAdapter {
public int action; //Un nombre différent par action à faire
/* actions:
echap/pause > échap:-1
monter/avancer > W et flèche haute:1
reculer/descendre > S et flèche basse:2
gauche > A et flèche gauche:3
droite > D et flèche droite :4
touche spéciale 1 > E: 5
touche spéciale 2 > I: 6
touche spéciale 3 > T: 7
s'accroupir/touche spéciale 4 > shift GAUCHE: 8
 */

	public static boolean[] touches = new boolean[100];

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() < 100)
			touches[e.getKeyCode()] = true;
		
		if (e.getKeyCode() == 27 && Main.menu == Menu.menuJeu)
			Menu.changeMenu(Menu.menuPause);
		
//		if (e.getKeyCode() == 87 && Main.menu == Menu.menuJeu){
//			Menu.menuJeu.levelUp();
//			Menu.changeMenu(Menu.menuDialogue);
//		}
//		switch(e.getKeyCode()){
//		case 27://echap
//			action = -1;
//			break;
//		case 87: //W
//			action = 1;
//			break;
//		case 38://flèche du haut
//			action = 1;
//			break;
//		case 83://S
//			action = 2;
//			break;
//		case 40://flèche du bas
//			action = 2;
//			break;
//		case 65://A
//			action = 3;
//			break;
//		case 37://flèche de gauche
//			action = 3;
//			break;
//		case 68://D
//			action = 4;
//			break;
//		case 39://flèche de droite
//			action = 4;
//			break;
//		case 69://E
//			action = 5;
//			break;
//		case 73://I
//			action = 6;
//			break;
//		case 84://T
//			action = 7;
//			break;
//		case 16://LEFT_SHIFT (shift GAUCHE!)
//			action = 8;
//			break;
			
//		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if (e.getKeyCode() < 100)
			touches[e.getKeyCode()] = false;
		
		
//		switch(e.getKeyCode()){
//		case 27://echap
//			action = -1;
//			break;
//		case 87: //W
//			action = 1;
//			break;
//		case 38://flèche du haut
//			action = 1;
//			break;
//		case 83://S
//			action = 2;
//			break;
//		case 40://flèche du bas
//			action = 2;
//			break;
//		case 65://A
//			action = 3;
//			break;
//		case 37://flèche de gauche
//			action = 3;
//			break;
//		case 68://D
//			action = 4;
//			break;
//		case 39://flèche de droite
//			action = 4;
//			break;
//		case 69://E
//			action = 5;
//			break;
//		case 73://I
//			action = 6;
//			break;
//		case 84://T
//			action = 7;
//			break;
//		case 16://LEFT_SHIFT (shift GAUCHE!)
//			action = 8;
//			break;
			
//		}
	}
	/*
	@Override
	public void keyTyped(KeyEvent e) {

	}*/


}
