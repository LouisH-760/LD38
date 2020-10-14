package com.denewo.LD38.graphics;

public class TextureAtlas extends Texture{

	private Texture[][] textures;
	private int nbWidth;
	private int nbHeight;
	
	
	public TextureAtlas(String path, int width, int height) {
		super(path);
		if (img.getWidth()%width != 0 || img.getHeight()%height != 0){
			System.err.println("La taille de la texture n'est pas bonne par rapport aux textures demandées !");
			return;
		}
		
		nbWidth = img.getWidth()/width;
		nbHeight = img.getHeight()/height;

		textures = new Texture [nbWidth][nbHeight];
		
		for (int x = 0; x < nbWidth; x ++)
			for (int y = 0; y < nbHeight; y ++)
				textures[x][y] = new Texture(img, x * width, y * height, width, height);
	}
	
//	public TextureAtlas(String path, int width, int height, int start, int end) {
//		super(path);
//		if (img.getWidth()%width != 0 || img.getHeight()%height != 0){
//			System.err.println("La taille de la texture n'est pas bonne par rapport aux textures demandées !");
//			return;
//		}
//		
//		nbWidth = img.getWidth()/width;
//		nbHeight = img.getHeight()/height;
//
//		textures = new Texture [nbWidth][nbHeight];
//		
//		int x = start;
//		int y = 0;
//		
//		while (x < nbWidth) {
//			x -= nbWidth;
//			y++;
//		}
//		
//		for (; x < nbWidth; x ++)
//			for (; y < nbHeight; y ++)
//				if (x + y * nbWidth <= end)
//					textures[x][y] = new Texture(img, x * width, y * height, width, height);
//				else
//					return;
//	}
//	
	public Texture getTexture (int x, int y){
		return textures[x][y];
	}
	
	public Texture[][] getTextures () {
		return textures;
	}
	
	public Texture[] getTexturesSimple () {
		Texture[] t = new Texture[nbWidth*nbHeight];
		
		for (int x = 0; x < nbWidth; x++)
			for (int y = 0; y < nbHeight; y++)
				t[x + y*nbWidth] = textures[x][y];
		
		return t;
	}
	
	public int getNbHeight () {
		return nbHeight;
	}
	public int getNbWidth () {
		return nbWidth;
	}
	
	public int size () {
		return nbWidth*nbHeight;
	}
	
	public TextureAtlas revertAll (int option) {
		for (int x = 0; x < nbWidth; x++)
			for (int y = 0; y < nbHeight; y++)
				textures[x][y].revert(option);
		return this;
	}

}
