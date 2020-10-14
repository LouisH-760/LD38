package com.denewo.LD38;

import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Musique {
	private Clip son;
	private boolean enabled = true;

	public boolean ready = true;

	public static Musique musique = new Musique("/sons/test.wav", true);
	public static Musique sonClic = new Musique("/sons/click.wav", true);
	public static Musique musiqueDialogues = new Musique("/sons/musiqueDialogues.wav", true);
	public static Musique musiqueJeu = new Musique("/sons/musiqueJeu.wav", true);
	public static Musique musiqueFin = new Musique("/sons/musiqueFin.wav", true);
	public static Musique musiqueMenu = new Musique("/sons/musiqueMenu.wav", true);
	public static Musique musiqueGO = new Musique("/sons/musiquego.wav", true);
	public static Musique sonGet = new Musique("/sons/pickup.wav", true);
	public static Musique sonJump = new Musique("/sons/saut.wav", true);
	
	public Musique(String url, Boolean enabled) { // charger un son à
													// partir d'un fichier
		this.enabled = enabled;
		try {
			final URL adresse = Musique.class.getResource(url);
			son = AudioSystem.getClip();
			son.open(AudioSystem.getAudioInputStream(adresse));
		} catch (Exception e) {
			System.err.println("Le son n'a pas pu être chargé !");
		}
	}

	public void jouer() { // jouer le son une fois

		if (!Main.sonActif)
			ready = false;

		if (enabled && ready) {
			son.setFramePosition(0);
			son.start();
			ready = false;
			try {
				Thread.sleep(son.getMicrosecondLength() / 100000);
			} catch (InterruptedException e) {
				System.out.println("erreur de pause du thread");
			}
		}

	}

	public void stop() {// arréter de jouer le son.
		if (enabled){
			son.setFramePosition(0);
			son.stop();
		}
	}
	
	public void loop() {
		if (!Main.sonActif)
			return;
		if (enabled)
			son.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void close() {
		if (enabled)
			son.close();
	}

	public Musique setready() {
		ready = true;
		return this;
	}
}
