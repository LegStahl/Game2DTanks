package view;

import java.awt.Graphics;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import java.util.LinkedList;

import javax.swing.JComponent;



import IO.Texture;
import model.Enemy;
import model.Game;
import model.Grass;
import model.Items;
import model.MapGame;
import model.Player;
import model.Shot;

public class MapGameView extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MapGame ourMap;
	
	private BufferedImage GRASS;
	
	private BufferedImage BLOCK;
	
	private BufferedImage EMPTY;
	
	private BufferedImage METALL;
	
	private BufferedImage WATER;
	
	private EnemyView enemiesView;
	
	private Player PLAYER;
	
	private LinkedList<Shot> shots;
	
	private ItemsView itemsView;
	
	private PlayerView playerView;

	private int posShot;
	
	private LinkedList<Grass> grasses;
	
	private ShotView shotsView;
	
	private boolean grass = true;

	
	public MapGameView(MapGame ourMap, Texture a, Display window, LinkedList<Shot> shots, LinkedList<Enemy> enemies, Player player, LinkedList<Items> items) {
			super();
			this.ourMap = ourMap;
			
			GRASS = a.sendGrass();
			
			BLOCK = a.sendBlock();
			
			EMPTY = a.sendEmpty();
			
			METALL = a.sendMetall();
			
			WATER = a.sendWater();
			
			this.PLAYER = player;
			
			playerView = new PlayerView(PLAYER);
			
			shotsView = new ShotView(shots);
			
			itemsView = new ItemsView(items);
			
			MyKeyListener m1 = new MyKeyListener();
			
			window.addKeyListener(m1);
			
			setDoubleBuffered(true);
			
			grasses = new LinkedList<Grass>();
			
			this.shots = shots;
			
			this.enemiesView = new EnemyView(enemies);
		
		}
	
	private class MyKeyListener implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(Game.GAMEON) {
			if(e.getKeyCode()== KeyEvent.VK_UP) {
				posShot = 0;
				PLAYER.setCurPos(0);
				playerView.changeCurrent(0);
			

		
				
				if( ourMap.getValue((PLAYER.getY() -2) / 8, (PLAYER.getX())  / 8 ) == 0 && ourMap.getValue((PLAYER.getY() - 2)/8 , (PLAYER.getX() + 7)  / 8 ) ==0 &&  ourMap.getValue((PLAYER.getY() - 2)/8 , (PLAYER.getX() + 15)  / 8 ) ==0 && PLAYER.getY() > 10) {
					PLAYER.driveUp();
					return;
				}if(ourMap.getValue((PLAYER.getY() -2) / 8, (PLAYER.getX())  / 8 ) == 4 && ourMap.getValue((PLAYER.getY() - 2)/8 , (PLAYER.getX() + 7)  / 8 ) == 4 &&  ourMap.getValue((PLAYER.getY() - 2)/8 , (PLAYER.getX() + 15)  / 8 ) == 4 && PLAYER.getY() > 10) {
					PLAYER.driveUp();
					return;
				}else {
					return;
				}
				
	
				
			
			}else if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
				posShot = 1;
				PLAYER.setCurPos(2);
				playerView.changeCurrent(2);
				if(PLAYER.getX() == 784) {
					//player.x = 784;
					return;
				}
				
			
		
				if( ourMap.getValue((PLAYER.getY()) / 8, (PLAYER.getX() + 17)  / 8 ) == 0 && ourMap.getValue((PLAYER.getY() + 7)/8 , (PLAYER.getX() + 17)  / 8 ) ==0 && ourMap.getValue((PLAYER.getY() + 15)/8 , (PLAYER.getX() + 17)  / 8 ) ==0 && PLAYER.getX() < 800) {
					PLAYER.driveRight(); 
					return;
				}if(ourMap.getValue((PLAYER.getY()) / 8, (PLAYER.getX() + 17)  / 8 ) == 4 && ourMap.getValue((PLAYER.getY() + 7)/8 , (PLAYER.getX() + 17)  / 8 ) ==4 && ourMap.getValue((PLAYER.getY() + 15)/8 , (PLAYER.getX() + 17)  / 8 ) ==4 && PLAYER.getX() < 800){
					PLAYER.driveRight(); 
					return;
				}else {
					return;
				}
				
			
			
			}else if(e.getKeyCode()== KeyEvent.VK_LEFT) {
				posShot = 3;
				PLAYER.setCurPos(3);
				playerView.changeCurrent(3);
				if(PLAYER.getX() == 0) {
					
					return;
				}
				
			
				if( ourMap.getValue((PLAYER.getY()) / 8, (PLAYER.getX() - 2)  / 8 ) == 0 && ourMap.getValue((PLAYER.getY() + 7)/8 , (PLAYER.getX() - 2)  / 8 ) ==0 &&  ourMap.getValue((PLAYER.getY() + 15)/8 , (PLAYER.getX() - 2)  / 8 ) ==0 && PLAYER.getX() > 3) {
					PLAYER.driveLeft(); 
					return;
				}if(ourMap.getValue((PLAYER.getY()) / 8, (PLAYER.getX() - 2)  / 8 ) == 4 && ourMap.getValue((PLAYER.getY() + 7)/8 , (PLAYER.getX() - 2)  / 8 ) ==4 &&  ourMap.getValue((PLAYER.getY() + 15)/8 , (PLAYER.getX() - 2)  / 8 ) == 4 && PLAYER.getX() > 3) {
					PLAYER.driveLeft();
					return;
				}else {
					return;
				}
			}else if(e.getKeyCode()== KeyEvent.VK_DOWN) {
				playerView.changeCurrent(1);
				posShot = 2;
				PLAYER.setCurPos(1);
				if(PLAYER.getY() == 584) {
					
					return;
				}
			
				if(  ourMap.getValue((PLAYER.getY() + 17) / 8, (PLAYER.getX())   / 8 ) == 0 &&  ourMap.getValue((PLAYER.getY() + 17)/8 , (PLAYER.getX() + 7)  / 8 ) ==0 && ourMap.getValue((PLAYER.getY() + 17)/8 , (PLAYER.getX() + 15)  / 8 ) == 0 && PLAYER.getY() < 760) {
					PLAYER.driveDown(); 
					return;
				}if( ourMap.getValue((PLAYER.getY() + 17) / 8, (PLAYER.getX())   / 8 ) == 4 &&  ourMap.getValue((PLAYER.getY() + 17)/8 , (PLAYER.getX() + 7)  / 8 ) ==4 && ourMap.getValue((PLAYER.getY() + 17)/8 , (PLAYER.getX() + 15)  / 8 ) == 4 && PLAYER.getY() < 760) {
					PLAYER.driveDown();
					return;
				}else {
					return;
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			
				if(posShot == 0) {
					shots.add(new Shot(PLAYER.getX() + 3, PLAYER.getY() - 8,posShot, false ));
				}else if(posShot == 1) {
				
					shots.add(new Shot(PLAYER.getX() + 15, PLAYER.getY() + 4,posShot, false ));
				}else if(posShot == 2) {
					
					shots.add(new Shot(PLAYER.getX() + 3, PLAYER.getY() + 16,posShot, false ));
				}else if(posShot == 3){
	
					shots.add(new Shot(PLAYER.getX() - 6, PLAYER.getY() + 4,posShot, false ));
				}
				
			}
			}
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				Game.GAMEON = !Game.GAMEON;
			}
		
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	
	
		for(int i = 0; i < ourMap.getSizeWidth();i++) {
			for(int j = 0;j < ourMap.getSizeLength();j++) {
				if(ourMap.getValue(i, j) == 0) {
					g.drawImage(EMPTY, j * 8, i * 8, null);
				}
				else if(ourMap.getValue(i, j) == 1) {
					g.drawImage(BLOCK, j * 8,i * 8, null);
				}
				else if(ourMap.getValue(i, j) == 2) {
					g.drawImage(METALL, j * 8, i * 8, null);
				}
				else if(ourMap.getValue(i, j) == 3) {
					
					g.drawImage(WATER, j * 8, i * 8, null);
				}
				
				else if((ourMap.getValue(i, j) == 4) && grass) {
					grasses.add(new Grass(i, j));
	
				}
				
			}
		}

		grass = false;
		//g.drawImage(playerView.curPos(), PLAYER.getX(), PLAYER.getY(), null);
		shotsView.drawShots(g);
		playerView.drawPlayer(g);
		enemiesView.drawEnemies(g);
		for(int i = 0;i < grasses.size(); i++) {
			g.drawImage(GRASS, grasses.get(i).getY() * 8, grasses.get(i).getX() * 8, null);
		}
	
		itemsView.drawItems(g);
		
	}
	
	public void example() {
		repaint();
	}
}
