package model;

import java.util.LinkedList;

public class Enemy {
	
	private int coor_x;
	
	private int coor_y;
	
	private int countingTurning[];
	
	private float speed;
	
	private boolean live;
	
	private long Time;
	
	private long timeTurn;
	
	private int curDirection;
	
	public Enemy(int coor_x, int coor_y, int curDirection) {
		this.coor_x = coor_x;
		
		countingTurning = new int[4];
		
		Time = System.nanoTime();
		
		timeTurn = System.nanoTime();
		
		this.coor_y = coor_y;
		
		live = true;
		
		this.curDirection = curDirection;
		
	}
	
	public void moveEnem(MapGame map, LinkedList<Shot> shots) {
		if(live) {
			if(curDirection == 0) {
				
				if( (map.getValue((coor_y - 2) / 8, (coor_x)  / 8 ) == 0 ||  map.getValue((coor_y - 2)/8  , (coor_x + 7)  / 8 ) == 4) && ((map.getValue((coor_y - 2) / 8, (coor_x)  / 8 ) == 4) || (map.getValue((coor_y - 2) / 8, (coor_x)  / 8 ) == 0)) &&  (map.getValue((coor_y - 2)/8  , (coor_x + 7)  / 8 ) ==0 || map.getValue((coor_y - 2)/8  , (coor_x + 7)  / 8 ) ==4 ) &&  map.getValue((coor_y - 2)/8 , (coor_x + 15)  / 8 ) ==0 && coor_y > 10) {
					speed += 0.5;
					if(speed > 2) {
						coor_y--;
						speed = speed - 1.25f;
					}
					
			
					if(System.nanoTime() - Time > Game.SECOND * 3){
						shots.add(new Shot( coor_x + 3, coor_y - 8, curDirection, true));
					
						Time = System.nanoTime();
					}
					
					if(System.nanoTime() - timeTurn > Game.SECOND * (int) 3 + Math.random() * 5  && (int)Math.random() * 4 == 0 ) {
						timeTurn = System.nanoTime();
						curDirection = 2;
					}
					
					return;
				}
				else {
					curDirection = (int) (Math.random() * 4);
					countingTurning[curDirection] += 1;
					return;
				}
				
			}else if(curDirection == 1) {
				if( (map.getValue((coor_y) / 8, (coor_x + 17)  / 8 ) == 0 || map.getValue((coor_y) / 8, (coor_x + 17)  / 8 ) == 4) &&  (map.getValue((coor_y+7)/8 , (coor_x + 17)  / 8 ) == 0 || map.getValue((coor_y+7)/8 , (coor_x + 17)  / 8 ) == 4 ) && ( map.getValue((coor_y + 15)/8 , (coor_x + 17)  / 8 ) == 0 || map.getValue((coor_y + 15)/8 , (coor_x + 17)  / 8 ) == 4) && coor_x < 784) {
					speed += 0.5;
					if(speed > 2) {
						coor_x++;
						speed = speed - 1.25f;
					}
					
					
				if(System.nanoTime() - Time > Game.SECOND * 3){
					shots.add(new Shot( coor_x + 15, coor_y + 4, curDirection, true));
					
					Time = System.nanoTime();
				}
					
				if(System.nanoTime() - timeTurn > Game.SECOND * (int) 3 + Math.random() * 5 && (int)Math.random() * 4 == 0 ) {
					timeTurn = System.nanoTime();
					curDirection = (int) (Math.random() * 4 );
				}
					return;
				}else {
					curDirection =(int) (Math.random() * 4 );
					countingTurning[curDirection] += 1;
					return;
				}
				
			}else if(curDirection == 2) {
				if((map.getValue((coor_y + 17)/8, (coor_x)/8 ) == 0 || map.getValue((coor_y + 17)/8, (coor_x)/8 ) == 4 ) &&  (map.getValue((coor_y + 17)/8 , (coor_x + 7)/8 ) == 0 || map.getValue((coor_y + 17)/8 , (coor_x + 7)/8 ) == 4) &&  (map.getValue((coor_y + 17)/8 , (coor_x + 15)/8) == 0 || map.getValue((coor_y + 17)/8 , (coor_x + 15)/8) == 4) && coor_y < 760) {
					speed += 0.5;
					if(speed > 2) {
						coor_y++;
						speed = speed - 1.25f;
					}
					
				
					
					if(System.nanoTime() - Time > Game.SECOND * 3){
						shots.add(new Shot( coor_x + 3, coor_y + 16, curDirection, true));
					
						Time = System.nanoTime();
					}
					
					if((System.nanoTime() - timeTurn > Game.SECOND * (int) 3 + Math.random() * 5 ) && (int)Math.random() * 7 == 0 ) {
						timeTurn = System.nanoTime();
						curDirection = (int) (Math.random() * 4);
					}
					
					return;
				}else {
					curDirection =(int) (Math.random() * 4);
					countingTurning[curDirection] += 1;
					return;
				}
				
			}else if(curDirection == 3) {
				if((map.getValue((coor_y) / 8, (coor_x - 2)  / 8 ) == 0 || map.getValue((coor_y) / 8, (coor_x - 2)  / 8 ) == 4 ) &&  (map.getValue((coor_y + 7)/8 , (coor_x - 2)  / 8 ) == 0 || map.getValue((coor_y + 7)/8 , (coor_x - 2)  / 8 ) == 4) &&  (map.getValue((coor_y + 15)/8 , (coor_x - 2)  / 8 ) == 0 || map.getValue((coor_y + 15)/8 , (coor_x - 2)  / 8 ) == 4) && coor_x > 10) {
					speed += 0.5;
					if(speed > 2) {
						coor_x--;
						speed = speed - 1.25f;
					}
					
			
					if(System.nanoTime() - Time > Game.SECOND * 3){
						shots.add(new Shot( coor_x - 6, coor_y + 4, curDirection, true));
					
						Time = System.nanoTime();
					}
					
					if(System.nanoTime() - timeTurn > Game.SECOND * (int) 3 + Math.random() * 5  && (int)Math.random() * 4 == 0 ) {
						
						curDirection = (int) (Math.random() * 4);
						timeTurn = System.nanoTime();
					}
					
					return;
				}else {
					curDirection =(int) (Math.random() * 4);
					countingTurning[curDirection] += 1;
					return;
				}
			}
		}
		else {
			return;
		}
	}
	
	public int getX() {
		return coor_x;
		
	}
	
	public int getY() {
		return coor_y;
	}
	
	
	public boolean getLive() {
		return live;
	}
	
	
	public void setDead() {
		live = false;
	}

	
	public int getDirection() {
		return curDirection;
	}
}
