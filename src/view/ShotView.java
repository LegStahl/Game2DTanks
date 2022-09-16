package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import IO.Texture;
import model.Shot;

public class ShotView {
	
	private BufferedImage shotUp;
	
	private BufferedImage shotRight;
	
	private BufferedImage shotLeft;
	
	private BufferedImage shotDown;
	
	private LinkedList<Shot> shots;
	
	public ShotView(LinkedList<Shot> shots ) {
		Texture sprite = new Texture();
		this.shots = shots;
		shotUp = sprite.sendShoot();
		shotRight = sprite.sendShootRight();
		shotLeft = sprite.sendShootLeft();
		shotDown = sprite.sendShootDown();
	}
	
	public void drawShots(Graphics g) {
		for(int i = 0; i < shots.size(); i++)
			if(shots.get(i).getCondition()) {
				if(shots.get(i).getDirection() == 0 )
					g.drawImage(shotUp, shots.get(i).getX()  , shots.get(i).getY() ,null);
				if(shots.get(i).getDirection() == 1 )
					g.drawImage(shotRight, shots.get(i).getX()  , shots.get(i).getY() ,null);
				if(shots.get(i).getDirection() == 2 )
					g.drawImage(shotDown, shots.get(i).getX()  , shots.get(i).getY() ,null);
				if(shots.get(i).getDirection() == 3 )
					g.drawImage(shotLeft, shots.get(i).getX()  , shots.get(i).getY() ,null);
			}
			else {
				shots.remove(i);
			}
	}
	
}
