package com.denewo.LD38;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.denewo.LD38.dialogues.Dialogues;
import com.denewo.LD38.etoiles.Etoiles;
import com.denewo.LD38.graphics.Screen;
import com.denewo.LD38.gui.Bouton;
import com.denewo.LD38.gui.menu.Menu;
import com.denewo.LD38.input.KeyInput;
import com.denewo.LD38.input.MouseInput;

public class Main extends Canvas implements Runnable{

	private static final long serialVersionUID = 5429528569763295249L;

	public static boolean running = false;
	private Screen screen;
	private BufferedImage image;
	

	private long wait = 1 * 10;
	
	public static boolean fullScreen = false;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 600;
	
	public static boolean sonActif = true;
	
	public Etoiles test = new Etoiles();
	
	public static Menu menu;
	
	public static Dialogues[] dialogue;
	
	public Main (int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		screen = new Screen(width, height);
	}
	
	@Override
	public void run() {
		Time.reset();
		long tmp = System.currentTimeMillis();
		menu.wakeUp();
		while(running) {
			update();
			if (System.currentTimeMillis() > wait + tmp){
				screen.resetScreen();
				render();
				tmp = System.currentTimeMillis();
				
			}
		}
		
	}
	
	public void update () {
		Time.next();
		sonActif = Bouton.boutonSon.isActive();
		if (!sonActif) {
			menu.sleep();
		} else {
			menu.wakeUp();
		}
		menu.update();
	}
	
	public void render () {
		
		menu.render(screen);

		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		image.setRGB(0, 0, screen.width, screen.height, screen.getPixels(), 0, screen.width);
		
		Graphics graphics = bs.getDrawGraphics();
		graphics.drawImage(image, 0, 0, screen.width, screen.height, null);
		
		if (dialogue != null){
			for (Dialogues d : dialogue){
				graphics.setFont(new Font("Arial", Font.PLAIN, d.getSize()));
				graphics.setColor(d.getColor());
				graphics.drawString(d.getTexte(), d.getX(), d.getY());
			}
		}
		bs.show();
	}
	
	public void start () {
		running = true;
		addKeyListener(new KeyInput());
		MouseInput mi = new MouseInput();
		addMouseListener(mi);
		addMouseMotionListener(mi);
		
		menu = Menu.menuPrincipal;
		
		new Thread(this, "Main Thread").start();
	}
	
	public static void main (String[] args){
		JFrame frame = new JFrame("La dernière étoile");
		Dimension dimension = new Dimension(WIDTH, HEIGHT);
		Main main = new Main((int)dimension.getWidth(), (int)dimension.getHeight());
		
		main.setMinimumSize(dimension);
		main.setPreferredSize(dimension);
		main.setMaximumSize(dimension);
		
		frame.setResizable(false);
		if (fullScreen)
			frame.setUndecorated(true);
		frame.add(main);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		frame.setIconImage(new ImageIcon("ressources/images/icon_64.png").getImage());
		
		main.requestFocus();
		
		if (fullScreen){
			GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			if (device.isFullScreenSupported())
				device.setFullScreenWindow(frame);
			else
				System.err.println("le plein écran n'est pas supporté !");
		}
		main.start();
		
	}
	
}
