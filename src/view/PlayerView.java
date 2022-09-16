package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import IO.Texture;
import model.Player;

public class PlayerView {
	
	private Player PLAYER;
	
	private BufferedImage currentPos;
	
	private BufferedImage RIGHT;
	
	private BufferedImage LEFT;
	
	private BufferedImage DOWN;
	
	private BufferedImage UP;
	
	private BufferedImage RIGHTDEFEND;
	
	private BufferedImage LEFTDEFEND;
	
	private BufferedImage DOWNDEFEND;
	
	private BufferedImage UPDEFEND;
	
	public PlayerView(Player player) {
		
		PLAYER = player;
		
		Texture image = new Texture();
		
		RIGHT = image.goRight();
		
		LEFT = image.goLeft();
		
		UP = image.goUp();
		
		DOWN = image.goDown();
		
		RIGHTDEFEND = image.goRightDefend();
		
		LEFTDEFEND = image.goLeftDefend();
		
		DOWNDEFEND = image.goDownDefend();
		
		UPDEFEND = image.goUpDefend();
		
		currentPos = UP;
	}
	
	public void drawPlayer(Graphics g) {
	
		this.changeCurrent(PLAYER.getCurPos());
		g.drawImage(currentPos, PLAYER.getX(), PLAYER.getY(), null);
	}
	
	public void changeCurrent(int i) {
		if(!PLAYER.getDefend()) {
			if(i == 0) {
				currentPos = UP;
			}
			else if(i == 1) {
				currentPos = DOWN;
			}
			else if(i == 2) {
				currentPos = RIGHT;
			}
			else if(i == 3) {
				currentPos = LEFT;
			}
		}else {
			if(i == 0) {
				currentPos = UPDEFEND;
			}
			else if(i == 1) {
				currentPos = DOWNDEFEND;
			}
			else if(i == 2) {
				currentPos = RIGHTDEFEND;
			}
			else if(i == 3) {
				currentPos = LEFTDEFEND;
			}
		}
	}
	

	
	public BufferedImage curPos() {
		return currentPos;
	}
}
