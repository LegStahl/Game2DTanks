package model;

public class Items {
	private int x;
	
	private boolean tookThis;
	
	private int y;
	
	public Items(int x, int y) {
		
		tookThis = false;
		
		this.x = x;
		
		this.y = y;
		
	}
	
	public int getX() {
		return x;
	}
	
	public boolean getTook() {
		return tookThis;
	}
	
	public void playerTook() {
		tookThis = true;
	}
	
	public void checkTake(Player player) {
		if(((player.getX() - 2) < x) && ((player.getX() + 18) > x) && ((player.getY() - 2) < y) && ((player.getY() + 18) > y)){
			this.playerTook();
			player.setDefend();
			Game.currentItems--;
		}
	}
	
	public int getY() {
		return y;
	}
	
}
