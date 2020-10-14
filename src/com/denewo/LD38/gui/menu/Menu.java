package com.denewo.LD38.gui.menu;

import com.denewo.LD38.Main;
import com.denewo.LD38.entity.RandU;
import java.util.Random;

import com.denewo.LD38.etoiles.Etoiles;

public abstract class Menu implements RandU{
	protected Random rand = new Random();
	public static MenuPause menuPause = new MenuPause();
	public static MenuPrincipal menuPrincipal = new MenuPrincipal();
	public static MenuJeu menuJeu = new MenuJeu();
	public static MenuDialogue menuDialogue = new MenuDialogue();
	public static MenuPerdu menuPerdu = new MenuPerdu();
	public static MenuVictoire menuVictoire = new MenuVictoire();
	Etoiles gen = new Etoiles();
	
	public abstract void sleep ();
	
	public abstract void wakeUp ();
	
	public static void changeMenu(Menu menu) {
		Main.menu.sleep();
		Main.menu = menu;
		Main.menu.wakeUp();
	}
	
	
}
