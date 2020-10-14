package com.denewo.LD38.dialogues;

import java.awt.Color;

public class Dialogues {
	

	public static Dialogues[] dialogues1_1 = {//intro
			new Dialogues (50, 50, 20,"Oh! something strange is going on in this world! Look at that red thing...")
	};
	
	public static Dialogues[] dialogues1_2 = {//intro
			new Dialogues (50, 50, 20,"It wouldn't be such a big deal if it wasn't able to get close to the last star holding this planet together..."),
			new Dialogues (50, 85, 20,"If this star was to be moved, our whole world would be completely changed, corrupted,"),
			new Dialogues (50, 105, 20,"and some say that it could even collapse!")
	};
	
	public static Dialogues[]dialogues1_3 = {//début jour 1 /intro
			new Dialogues (50, 50, 20, "Would you mind taking a look around the world, and grabbing that thing to show it to us?"),
			new Dialogues (430, 300, 50, "DAY : 1", Color.YELLOW),
			new Dialogues (50, 125, 15, "Hint: press Arrow_Down to cut your jump, ie when you didn't intend to jump and want to get back down quick.")
			};
	
	public static Dialogues[][] dialogues1 = {
			dialogues1_1,
			dialogues1_2,
			dialogues1_3
	};
	
	public static Dialogues[] dialogues2_1 = {//début du jour 2
			new Dialogues (50, 50, 20,"Oh! I'm tired of chasing this thing. I'll get back to it tommorow.")
	};
	public static Dialogues[] dialogues2_2 = {//suite début jour 2
			new Dialogues (50, 50, 20,"But... but what does this mean? Our world changed a lot! It must be this strange red thing."),
			new Dialogues (50, 75, 20, "I'll catch it anyways! resistance is futile!"),
			new Dialogues (430, 300, 50,"DAY : 2", Color.YELLOW)
	};
	
	public static Dialogues[][] dialogues2 = {
			dialogues2_1,
			dialogues2_2
	};
	
	public static Dialogues[] dialogues3_1 = {//début jour 3
			new Dialogues (50, 50, 20, "Uh? Our planet changed again!? And what are those green things?"),
			new Dialogues (50, 85, 20, "It looks like I can go through them."),
			new Dialogues (430, 300, 50,"DAY : 3", Color.YELLOW)
	};
	
	public static Dialogues[][] dialogues3 = {
			dialogues3_1
	};
	
	public static Dialogues[] dialogues4_1 = {//début du jour 4
			new Dialogues (50, 50, 20, "Uh oh! New stuff again! But this time it's long and white."),
			new Dialogues (50, 95, 20, "I can go through it's body, but use it's top as a platform if i go slow enough on it. Else I fall down."),
			new Dialogues (430, 300, 50,"DAY : 4", Color.YELLOW)
	};
	
	public static Dialogues[] dialogues5_1 = {//début jour 5
			new Dialogues (50, 50, 20, "Good! there's no weird stuff today! That red thing must be gone...finally!"),
			new Dialogues (50, 85, 20, "Oh wait.. No it isn't gone! it's still there. Well I guess i'm going to grab it."),
			new Dialogues (430, 300, 50,"DAY : 5", Color.YELLOW)
	};
	public static Dialogues[] dialogues6_1 = {//début jour 6
			new Dialogues (50, 50, 20, "Oh! this time the weird red thing is really gone! But ..."),
			new Dialogues (50, 85, 20, "Oh no! the star has been moved! I need to get it back real quick!"),
			new Dialogues (50, 110, 20, "I guess it could be worse...The world could have collapsed."),
			new Dialogues (430, 300, 50,"DAY : 6", Color.YELLOW)
	};
	
	public static Dialogues[][] dialogues4 = {
			dialogues4_1
	};
	
	public static Dialogues[][] dialogues5 = {
			dialogues5_1
	};
	public static Dialogues[][] dialogues6 = {
			dialogues6_1
	};
	
	
	public static Dialogues[] fin_1 = {
			new Dialogues (50, 50, 20, "But... But why were we all killed? To build this.. this thing?"),
			new Dialogues (50, 95, 20,  "Have we done something wrong?"),
			new Dialogues (50, 200, 50, "The End")
	};
	public static Dialogues[][] fin = {
			fin_1
	};
	
	public static Dialogues[] credits_1 = {
			new Dialogues (50, 50, 30,"You won the game!"),
			new Dialogues(50, 95, 20, "Credits :"),
			new Dialogues (50, 140, 20,"Code: Vincent Carpentier, Louis Hermier "),
			new Dialogues(50, 185, 20, "Scenario: Vincent Carpentier, Corentin Duchêne, Louis Hermier"),
			new Dialogues(50, 230, 20, "Dialogs and Translation: Louis Hermier"),
			new Dialogues(50, 275, 20, "Graphic and sfx assets: Corentin Duchêne"),
			new Dialogues(50, 320, 20, "Music: Louis Hermier"),
			new Dialogues(50, 365, 20, "Game Over music: Vincent Carpentier"),
			new Dialogues (50, 410, 20,"Made in around 48h for Ludum Dare 38 Jam"),
			new Dialogues(50, 455, 20, "Built from scratch in java without external libraries"),
			new Dialogues(50, 500, 20, "Made using Eclipse, photoshop, sfxr, bosca ceoil"),
			new Dialogues(50, 545, 20, "Thanks for playing !")
	};
	public static Dialogues[][] credits = {
			credits_1
	};
	

	
	private int size;
	private Color color;
	private String texte;
	private int x;
	private int y;
	
	public Dialogues (int x, int y, int size, String texte) {
		this(x, y, size, texte, Color.WHITE);
	}
	
	public Dialogues (int x, int y, int size, String texte, Color color) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.texte = texte;
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public Color getColor() {
		return color;
	}

	public String getTexte() {
		return texte;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
