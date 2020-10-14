package com.denewo.LD38.gui.menu;

import java.util.ArrayList;
import java.util.Random;

import com.denewo.LD38.Main;
import com.denewo.LD38.Musique;
import com.denewo.LD38.Time;
import com.denewo.LD38.collision.Collisionable;
import com.denewo.LD38.dialogues.Dialogues;
import com.denewo.LD38.entity.Block;
import com.denewo.LD38.entity.Collectable;
import com.denewo.LD38.entity.Entity;
import com.denewo.LD38.entity.ItemMultiPosition;
import com.denewo.LD38.entity.Player;
import com.denewo.LD38.etoiles.Etoiles;
import com.denewo.LD38.graphics.Animation;
import com.denewo.LD38.graphics.Screen;
import com.denewo.LD38.graphics.Texture;
import com.denewo.LD38.map.Map;

public class MenuJeu extends Menu{
	
	private int level = 1;

	private ArrayList<Entity> entityPassives = new ArrayList<Entity>();
	private ArrayList<Entity> entityActives = new ArrayList<Entity>();
	
	private Musique musique = Musique.musiqueJeu;
	
	private double fallingline = Main.HEIGHT;
	private double vitesseFallingLine = 10;
	private boolean fallingLineActive = false;
	
	private boolean end = false;
	private double time = 0;
	
	@Override
	public void update() {
		
		for (Entity entity : entityPassives)
			entity.update();
		for (Entity entity : entityActives)
			entity.update();
		
		for (Entity actives : entityActives)
			for (Entity passives : entityPassives)
				if (actives instanceof Collisionable && passives instanceof Collisionable)
					((Collisionable)actives).collision(passives);
			
		
		for (int i = 0; i < entityActives.size(); i++)
			for (int j = i + 1; j < entityActives.size(); j++)
				if (entityActives.get(i) instanceof Collisionable && entityActives.get(j) instanceof Collisionable)
					((Collisionable)entityActives.get(i)).collision(entityActives.get(j));
			
		for (int i = 0; i < entityActives.size(); i++)
			if (entityActives.get(i).getY() > 600){
				if (entityActives.get(i) instanceof Player && !end)
					changeMenu(menuPerdu);
				entityActives.remove(i);
				i--;
			}
		if (fallingLineActive ){
			Random r = new Random();
			fallingline -= vitesseFallingLine*Time.getTime();
			for (int i = 0; i < entityPassives.size(); i++ )
				if (entityPassives.get(i) instanceof Block && entityPassives.get(i).getY() > fallingline)
					if (r.nextInt(10000) == 1){
						for (int j = 0; j < entityPassives.size(); j++)
							if (entityPassives.get(j) instanceof Block){
								int bv = ((Block)entityPassives.get(j)).getVersion();
								
								if (bv == 13 && entityPassives.get(i).getY() - 32 - entityPassives.get(j).getY() == 0.0 && entityPassives.get(i).getX() == entityPassives.get(j).getX()){
									((Block)entityPassives.get(j)).setFalling();
									entityActives.add(entityPassives.get(j));
									entityPassives.remove(j);
									if (i > j) i--;
								} else if (bv == 14 && entityPassives.get(i).getY() - 96 - entityPassives.get(j).getY() == 0.0 && entityPassives.get(i).getX() == entityPassives.get(j).getX()){
									((Block)entityPassives.get(j)).setFalling();
									entityActives.add(entityPassives.get(j));
									entityPassives.remove(j);
									if (i > j) i--;
								}
							}
							
							
						
						((Block)entityPassives.get(i)).setFalling();
						entityActives.add(entityPassives.get(i));
						entityPassives.remove(i);
						i--;
					}
				
		}
		
		if (end){
			fallingline = 0;
			Animation.explosions.update();
			time += Time.getTime();
			if (time > 5){
				end = false;
				Menu.changeMenu(Menu.menuVictoire);
			}
		}
		
	}


	@Override
	public void render(Screen screen) {
		for(int i = 1; i<1000/32; i++)
		{
			for(int j = 1; j<600/32; j++)
			{
				if(gen.etoiles[i][j] == 1)
					if(gen.etoiles[i][j] == 1)
						if(i%2 == 0)
							screen.drawIMG(Texture.star[Etoiles.size[i][j]], i*Etoiles.pas[i][j], j*Etoiles.pas[i][j]);
						else
							screen.drawIMG(Texture.star[Etoiles.size[i][j]], i*Etoiles.pas2[i][j], j*Etoiles.pas2[i][j]);
				}
			
		}
		for (Entity entity : entityPassives)
			entity.render(screen);
		for (Entity entity : entityActives)
			entity.render(screen);
		
		if (end) {
			screen.drawIMG(Animation.explosions.getFrame(), 10, 125);
			screen.drawIMG(Animation.explosions.getFrame(), 562, 200);
			screen.drawIMG(Animation.explosions.getFrame(), 400, 251);
			screen.drawIMG(Animation.explosions.getFrame(), 100, 457);
			screen.drawIMG(Animation.explosions.getFrame(), 454, 125);
			screen.drawIMG(Animation.explosions.getFrame(), 52, 200);
			screen.drawIMG(Animation.explosions.getFrame(), 400, 251);
			screen.drawIMG(Animation.explosions.getFrame(), 180, 457);
			screen.drawIMG(Animation.explosions.getFrame(), 0, 300);
			screen.drawIMG(Animation.explosions.getFrame(), 545, 20);
			screen.drawIMG(Animation.explosions.getFrame(), 800, 251);
			screen.drawIMG(Animation.explosions.getFrame(), 700, 457);
		}
		
	}
	
	public void addActiveEntity (Entity entity) {
		entityActives.add(entity);
	}
	public void addActiveEntitys (ArrayList<Entity> entitys) {
		entityActives.addAll(entitys);
	}
	public void addPassivesEntity (Entity entity) {
		entityPassives.add(entity);
	}
	public void addPassivesEntitys (ArrayList<Entity> entitys) {
		entityPassives.addAll(entitys);
	}
	
	public void rmActiveEntity (Entity entity) {
		entityActives.remove(entity);
	}
	public void rmPassivesEntity (Entity entity) {
		entityPassives.remove(entity);
	}


	@Override
	public void sleep() {
		musique.stop();
	}


	@Override
	public void wakeUp() {
		musique.loop();
	}
	
	public void levelUp () {
		level++;
		fallingLineActive = false;
		entityPassives = new ArrayList<Entity>();
		entityActives = new ArrayList<Entity>();
		ItemMultiPosition.ruby.rmAllPosition();
		fallingline = Main.HEIGHT;
		switch (level) {
		case 2:
			ItemMultiPosition.ruby.setX(490);//490
			ItemMultiPosition.ruby.setY(50);//50
			addPassivesEntity(ItemMultiPosition.ruby
					.addPosition(170, 127)
					.addPosition(750, 45)
					);
			addPassivesEntitys(Map.LoadMap(Map.nv2));
			menuDialogue.setDialogues(Dialogues.dialogues2).setToken(0);
			addActiveEntity(Player.player);
			break;
		case 3:
			ItemMultiPosition.ruby.setX(490);
			ItemMultiPosition.ruby.setY(50);
			addPassivesEntity(ItemMultiPosition.ruby
					.addPosition(170, 127)
					.addPosition(750, 45)
					);
			addPassivesEntitys(Map.LoadMap(Map.nv3));
			menuDialogue.setDialogues(Dialogues.dialogues3).setToken(0);
			addActiveEntity(Player.player);
			break;
			
		case 4:
			ItemMultiPosition.ruby.setX(490);
			ItemMultiPosition.ruby.setY(50);
			addPassivesEntity(ItemMultiPosition.ruby
					.addPosition(170, 127)
					.addPosition(750, 45)
					);
			addPassivesEntitys(Map.LoadMap(Map.nv4));
			menuDialogue.setDialogues(Dialogues.dialogues4).setToken(0);
			addActiveEntity(Player.player);
			break;
		case 5:
			ItemMultiPosition.ruby.setX(490);
			ItemMultiPosition.ruby.setY(50);
			addPassivesEntity(ItemMultiPosition.ruby
					.addPosition(170, 127)
					.addPosition(750, 45)
					);
			addPassivesEntitys(Map.LoadMap(Map.nv5));
			menuDialogue.setDialogues(Dialogues.dialogues5).setToken(0);
			addActiveEntity(Player.player);
			break;
		case 6:
			fallingLineActive = true;
			addPassivesEntitys(Map.LoadMap(Map.nv6));
			Collectable.theStar.setX(490);
			Collectable.theStar.setY(50);
			addPassivesEntity(Collectable.theStar);
			menuDialogue.setDialogues(Dialogues.dialogues6).setToken(0);
			addActiveEntity(Player.player);
			break;
		case 7:
			menuDialogue.setDialogues(Dialogues.fin).setToken(0);
			addPassivesEntity(new Collectable(Main.WIDTH/2 - 45, Main.HEIGHT/2 - 45, 90, 90).setAni(Animation.terre));
			break;
		}
	}
	
	public MenuJeu reset () {
		time = 0;
		fallingLineActive = false;
		fallingline = Main.HEIGHT;
		entityPassives = new ArrayList<Entity>();
		entityActives = new ArrayList<Entity>();
		level = 1;
		menuDialogue.setDialogues(Dialogues.dialogues1).setToken(0);
		addPassivesEntitys(Map.LoadMap(Map.nv1));
		ItemMultiPosition.ruby.rmAllPosition();
		ItemMultiPosition.ruby.setX(250);
		ItemMultiPosition.ruby.setY(100);
		addPassivesEntity(ItemMultiPosition.ruby
				.addPosition(200, 200)
				.addPosition(750, 450)
				);
		addActiveEntity(Player.player);
		return this;
	}


	public double getFallingline() {
		return fallingline;
	}


	public void setFallingline(double fallingline) {
		this.fallingline = fallingline;
	}


	public double getVitesseFallingLine() {
		return vitesseFallingLine;
	}


	public void setVitesseFallingLine(double vitesseFallingLine) {
		this.vitesseFallingLine = vitesseFallingLine;
	}


	public boolean isFallingLineActive() {
		return fallingLineActive;
	}


	public void setFallingLineActive(boolean fallingLineActive) {
		this.fallingLineActive = fallingLineActive;
	}
	
	public void setEnd () {
		end = true;
	}

}
