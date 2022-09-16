package model;


public class Player {
	
	private boolean LIVE;
	private int coor_x;
	private int coor_y;
	private boolean DEFEND;
	private int record;
	private int currentPos;
	
	
	public Player() {
		
		coor_x = 260;
		
		coor_y = 240;
		
		record = 0;
		
		LIVE = true;
		
		DEFEND = false;
		
		currentPos = 0;
	}
	
	public void driveUp() {
		coor_y--;
	}
	
	public void driveDown() {
		coor_y++;
	}
	
	public void driveRight() {
		coor_x++;
	}
	
	public void driveLeft() {
		coor_x--;
	}
	
	public void setX(int x) {
		coor_x = x;
	}
	
	public void setY(int y) {
		coor_y = y;
	}
	
	public void killOne() {
		record++;
	}
	
	public void setDefend() {
		DEFEND = true;
	}
	
	public void deleteDefend() {
		DEFEND = false;
	}
	
	public int getRecord() {
		return record;
	}
	
	public int getX() {
		return coor_x;
	}
	
	public int getY() {
		return coor_y;
	}
	
	public boolean getDefend() {
		return DEFEND;
	}
	
	public void setCurPos(int i) {
		currentPos = i;
	}
	
	public int getCurPos() {
		return currentPos;
	}
	
	
	public boolean getLive() {
		return LIVE;
	}
	
	public void deadPlayer() {
		LIVE = !LIVE;
	}
}
