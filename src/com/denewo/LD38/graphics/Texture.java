package com.denewo.LD38.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {

	protected BufferedImage img;
	private int[][] pixels;

	private int width;
	private int height;

	public static final int HORIZONTAL = 1;
	public static final int VERTICAL = 2;
	public static final int D90 = 3;

	public static Texture[] boutonPlay = new Texture[] { new Texture("/images/ui-button.png", 2, 2, 211, 41),
			new Texture("/images/ui-button.png", 2, 46, 212, 41),
			new Texture("/images/ui-button.png", 2, 90, 212, 41) };

	public static Texture[] boutonQuitter = new Texture[] {
			new Texture("/images/ui-button.png", 2, 134, 212, 41),
			new Texture("/images/ui-button.png", 2, 178, 212, 41),
			new Texture("/images/ui-button.png", 2, 222, 212, 41) };

	public static Texture[] boutonResume = new Texture[] {
			new Texture("/images/ui-button.png", 2, 266, 212, 41),
			new Texture("/images/ui-button.png", 2, 310, 212, 41),
			new Texture("/images/ui-button.png", 2, 354, 212, 41) };
	
	public static Texture[] boutonTryAgain = new Texture[] {
			new Texture("/images/ui-button.png", 2, 662, 212, 41),
			new Texture("/images/ui-button.png", 2, 702, 212, 41),
			new Texture("/images/ui-button.png", 2, 750, 212, 41) };

	public static Texture[] boutonSon = new Texture[] { new Texture("/images/ui-button.png", 216, 2, 41, 41),
			new Texture("/images/ui-button.png", 260, 2, 41, 41) };
	public static Texture[] boutonContinue = new Texture[] {
			new Texture("/images/ui-button.png", 2, 530, 212, 41),
			new Texture("/images/ui-button.png", 2, 574, 212, 41),
			new Texture("/images/ui-button.png", 2, 618, 212, 41) };
	public static Texture[] bouton3points = new Texture[] {
			new Texture("/images/ui-button.png", 2, 398, 212, 41),
			new Texture("/images/ui-button.png", 2, 442, 212, 41),
			new Texture("/images/ui-button.png", 2, 486, 212, 41) };
	public static Texture playertest = new Texture("/images/testplayer01.png");
	
	public static Texture tree = new Texture("/images/other_decorations.png", 0, 0, 30, 38);
	public static Texture pilier = new Texture("/images/other_decorations.png", 35, 1, 32, 106);
	public static Texture fond = new Texture("/images/texture.png", 0, 0, 64, 64);
	public static Texture go = new Texture("/images/gomenu.png", 0, 0, 1000, 600);
	
	public static Texture[] block = new Texture[] {
			new Texture("/images/matter.png", 0, 2, 34, 32),
			new Texture("/images/matter.png", 36, 2, 34, 32),
			new Texture("/images/matter.png", 70, 2, 34, 32),
			new Texture("/images/matter.png", 106, 2, 34, 32),
			new Texture("/images/matter.png", 142, 2, 36, 18),
			new Texture("/images/matter.png", 2, 36, 32, 32),
			new Texture("/images/matter.png", 36, 36, 32, 32),
			new Texture("/images/matter.png", 70, 36, 32, 32),
			new Texture("/images/matter.png", 104, 36, 32, 32),
			new Texture("/images/matter.png", 138, 36, 32, 32),
			new Texture("/images/matter.png", 172, 36, 32, 32),
			new Texture("/images/matter.png", 36, 36, 32, 32).revert(D90).revert(VERTICAL),
			new Texture("/images/matter.png", 180, 2, 36, 18),
			tree,
			pilier,
			new Texture("/images/other_decorations.png", 1, 46, 32, 32)};
	
	public static Texture[] ruby = new Texture[] {
			new Texture("/images/ruby-w16xh16.png", 0, 0, 16, 16),
			new Texture("/images/ruby-w16xh16.png", 16, 0, 16, 16),
			new Texture("/images/ruby-w16xh16.png", 32, 0, 16, 16),
			new Texture("/images/ruby-w16xh16.png", 48, 0, 16, 16),
			new Texture("/images/ruby-w16xh16.png", 48, 0, 16, 16).revert(VERTICAL),
			new Texture("/images/ruby-w16xh16.png", 32, 0, 16, 16).revert(VERTICAL),
			new Texture("/images/ruby-w16xh16.png", 16, 0, 16, 16).revert(VERTICAL)};
	
	public static TextureAtlas explosion = new TextureAtlas("/images/exp-w200xh200.png", 200, 200);
	
	public static TextureAtlas terre = new TextureAtlas("/images/genterre-w90xh90.png", 90, 90);

	public static Texture slab = new Texture("/images/matter.png", 142, 2, 36, 18);
	
	public static Texture title = new Texture("/images/title-menup.png", 0, 0, 752, 118);
	
	public static Texture pageFin1 = new Texture("/images/pagefin01.png", 0, 0, 1000, 600);
	
	public static Texture pageFin2 = new Texture("/images/pagefin02.png", 0, 0, 1000, 600);
	
	
	public static Texture[] star = new Texture[] {
			new Texture("/images/matter.png", 206, 38, 14 + 4, 14 + 4),
			new Texture("/images/matter.png", 226, 38, 14 + 6, 14 + 6),
			new Texture("/images/matter.png", 246, 38, 14 + 8, 14 + 8)};
	
	public static TextureAtlas theStar = new TextureAtlas("/images/star-w17xh17.png", 17, 17);

	public static TextureAtlas debug = new TextureAtlas("/images/debug.png", 30, 20);
	
	

	public static TextureAtlas playerMoveRight = new TextureAtlas("/images/pp01-w16xh16.png", 16, 16);
	public static TextureAtlas playerMoveLeft = new TextureAtlas("/images/pp01-w16xh16.png", 16, 16)
			.revertAll(VERTICAL);
	public static Texture[] playerJumpRight = new Texture[] {
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 0, 0, 16, 16),
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 16, 0, 16, 16) };
	public static Texture[] playerJumpLeft = new Texture[] {
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 0, 0, 16, 16).revert(VERTICAL),
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 16, 0, 16, 16).revert(VERTICAL) };
	public static Texture[] playerFallRight = new Texture[] {
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 32, 0, 16, 16),
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 48, 0, 16, 16) };
	public static Texture[] playerFallLeft = new Texture[] {
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 32, 0, 16, 16).revert(VERTICAL),
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 48, 0, 16, 16).revert(VERTICAL) };

	public static Texture[] playerStand = new Texture[] {
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 4 * 16, 0, 16, 16),
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 5 * 16, 0, 16, 16),
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 6 * 16, 0, 16, 16),
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 7 * 16, 0, 16, 16),
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 8 * 16, 0, 16, 16) };
	
	public static Texture[] playerStandMenu = new Texture[] {
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 4 * 16, 0, 16, 16).revert(Texture.VERTICAL),
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 5 * 16, 0, 16, 16).revert(Texture.VERTICAL),
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 6 * 16, 0, 16, 16).revert(Texture.VERTICAL),
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 7 * 16, 0, 16, 16).revert(Texture.VERTICAL),
			new Texture("/images/pp01jumpandsleep-w16xh16.png", 8 * 16, 0, 16, 16).revert(Texture.VERTICAL) };

	public Texture(String path) {
		
		try {
			img = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			System.err.println("Erreur l'image n'a pas pu être chargée !");
			return;
		}

		width = img.getWidth();
		height = img.getHeight();

		pixels = new int[width][height];

		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				pixels[x][y] = img.getRGB(x, y);

	}

	public Texture(String path, int x, int y, int w, int h) {
		try {
			img = ImageIO.read(getClass().getResourceAsStream((path)));
		} catch (IOException e) {
			System.err.println("Erreur l'image n'a pas pu être chargée !");
			return;
		}

		width = w;
		height = h;

		pixels = new int[width][height];

		for (int xt = 0; xt < w; xt++)
			for (int yt = 0; yt < h; yt++)
				pixels[xt][yt] = img.getRGB(x + xt, y + yt);
	}

	public Texture(BufferedImage img, int x, int y, int w, int h) {
		this.img = img;

		width = w;
		height = h;

		pixels = new int[width][height];

		for (int xt = 0; xt < w; xt++)
			for (int yt = 0; yt < h; yt++)
				pixels[xt][yt] = img.getRGB(x + xt, y + yt);
	}

	public Texture revert(int option) {

		int[][] pixels2 = new int[width][height];
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				pixels2[x][y] = pixels[x][y];

		if (option == HORIZONTAL) {

			for (int xt = 0; xt < width; xt++)
				for (int yt = 0; yt < height; yt++)
					pixels[xt][yt] = pixels2[xt][height - yt - 1];

		} else if (option == VERTICAL) {

			for (int xt = 0; xt < width; xt++)
				for (int yt = 0; yt < height; yt++)
					pixels[xt][yt] = pixels2[width - xt - 1][yt];

		} else if (option == D90 && width == height) {

			for (int xt = 0; xt < width; xt++)
				for (int yt = 0; yt < height; yt++)
					pixels[xt][yt] = pixels2[yt][xt];

		} else
			System.err.println("Mauvais paramètre !!");
		return this;
	}

	public int[][] getPixels() {
		return pixels;
	}

	public int getPixel(int x, int y) {
		return pixels[x][y];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
