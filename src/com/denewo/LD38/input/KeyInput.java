package com.denewo.LD38.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.denewo.LD38.Main;
import com.denewo.LD38.gui.menu.Menu;

public class KeyInput extends KeyAdapter {
public int action; //Un nombre diff�rent par action � faire
/* actions:
echap/pause > �chap:-1
monter/avancer > W et fl�che haute:1
reculer/descendre > S et fl�che basse:2
gauche > A et fl�che gauche:3
droite > D et fl�che droite :4
touche sp�ciale 1 > E: 5
touche sp�ciale 2 > I: 6
touche sp�ciale 3 > T: 7
s'accroupir/touche sp�ciale 4 > shift GAUCHE: 8
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
//		case 38://fl�che du haut
//			action = 1;
//			break;
//		case 83://S
//			action = 2;
//			break;
//		case 40://fl�che du bas
//			action = 2;
//			break;
//		case 65://A
//			action = 3;
//			break;
//		case 37://fl�che de gauche
//			action = 3;
//			break;
//		case 68://D
//			action = 4;
//			break;
//		case 39://fl�che de droite
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
//		case 38://fl�che du haut
//			action = 1;
//			break;
//		case 83://S
//			action = 2;
//			break;
//		case 40://fl�che du bas
//			action = 2;
//			break;
//		case 65://A
//			action = 3;
//			break;
//		case 37://fl�che de gauche
//			action = 3;
//			break;
//		case 68://D
//			action = 4;
//			break;
//		case 39://fl�che de droite
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
