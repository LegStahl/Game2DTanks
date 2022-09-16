package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import IO.Texture;
import model.Enemy;
import model.Game;


public class EnemyView  {
	private BufferedImage up;
	
	private BufferedImage down;
	
	private BufferedImage right;
	
	private BufferedImage left;
	
	private LinkedList<Enemy> enemies;
	

	
	public EnemyView(LinkedList<Enemy> enemy) {
		
		this.enemies = enemy;
		
		Texture texture = new Texture();
		
		up = texture.sendEnemyUp();
		
		down = texture.sendEnemyDown();
		
		right = texture.sendEnemyRight();
		
		left = texture.sendEnemyLeft();
	}
	

	

	
	public void drawEnemies(Graphics g) {
		for(int i = 0; i < enemies.size(); i++) {
			if(enemies.get(i).getLive()) {
				if(enemies.get(i).getDirection() == 0)
					g.drawImage(up, enemies.get(i).getX(),enemies.get(i).getY(),null);
				if(enemies.get(i).getDirection() == 1)
					g.drawImage(right, enemies.get(i).getX(),enemies.get(i).getY(),null);
				if(enemies.get(i).getDirection() == 2)
					g.drawImage(down, enemies.get(i).getX(),enemies.get(i).getY(),null);
				if(enemies.get(i).getDirection() == 3)
					g.drawImage(left, enemies.get(i).getX(),enemies.get(i).getY(),null);
			}else {
				enemies.remove(i);
				Game.currentEnem--;
			}
		}
	}
	

}
