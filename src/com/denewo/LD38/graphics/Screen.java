package com.denewo.LD38.graphics;

public class Screen {
	
	public int[][] pixels;
	public int width;
	public int height;
	
	public Screen (int width, int height){
		this.width = width;
		this.height = height;
		
		pixels = new int[width][height];
		
		for (int x = 0; x<width; x++)
			for (int y = 0; y<height; y++)
				pixels[x][y] = 0xFF01001a;
	}
	
	public void resetScreen () {
		for (int x = 0; x<width; x++)
			for (int y = 0; y<height; y++)
				pixels[x][y] = 0xFF01001a;
	}
	
	public void drawRect (int posX, int posY, int w, int h, int color) {
		for (int x = posX; x < w + posX; x++)
			for (int y = posY; y < h + posY; y++)
				pixels[x][y] = color;
	}
	
	public void drawIMG (Texture texture, int posX, int posY) {
		
		if (posX > width || posY > height || (posX + texture.getWidth()) < 0 || posY + texture.getHeight() < 0)return;
		
		for (int x = (posX>0)?0:-posX; x < texture.getWidth() && x + posX < width; x++)
			for (int y = (posY>0)?0:-posY; y < texture.getHeight() && y + posY < height; y++)
					pixels[x + posX][y + posY] = pixelSupperposition (texture.getPixel(x, y), pixels[x + posX][y + posY]);
	
	}
	
	public void drawIMG (Texture texture, int posX, int posY, int scale) {
		
		if (posX > width || posY > height || posX + texture.getWidth()*scale < 0 || posY + texture.getHeight()*scale < 0)return;
		
		for (int x = 0; x < texture.getWidth(); x++)
			for (int y = 0; y < texture.getHeight(); y++){
				
				int xp = x*scale+posX;
				int yp = y*scale+posY;
				
				for (int xs = 0; xs < scale && xp+xs >= 0 && xp+xs < width; xs++){
					for (int ys = 0; ys < scale && yp+ys >= 0 && yp+ys < height; ys++)
							pixels[xs + xp][ys + yp] = pixelSupperposition(texture.getPixel(x, y), pixels[xs + xp][ys + yp]);
				}
			}
	
		
	}
	
	public int[] getPixels () {
		int[] px = new int[width*height];
		
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
				px[x + y*width] = pixels[x][y];
		return px;
	}
	
	private int pixelSupperposition (int a, int b) {
		int aa = a >> 24 & 0xFF;
		
		int ra = (a >> 16) & 0xFF;
		int ga = (a >> 8) & 0xFF;
		int ba = a & 0xFF;
		
		int rb = (b >> 16) & 0xFF;
		int gb = (b >> 8) & 0xFF;
		int bb = b & 0xFF;
		
		double rapport = (double)aa/255;
		
		return (0xFF << 24) | 
				(int)((ra*rapport) + rb*(1-rapport)) << 16 | 
				(int)(ga*rapport + gb*(1-rapport)) << 8 | 
				(int)(ba*rapport + bb*(1-rapport));
		
		//couleurDevant*(alpha/255) + couleurDerriere*(1-(alpha/255));
	}
}
