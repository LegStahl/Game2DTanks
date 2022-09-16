package model;



import java.util.LinkedList;



public class Shot {
	

	private boolean got;
	
	private int coor_x;
	
	private int coor_y;
	
	private int direction;
	
	private boolean enemy;
	

	
	public Shot( int x, int y, int direction, boolean enem) {
		coor_x = x;
		coor_y = y;
		this.direction = direction;
	
		got = true;
		enemy = enem;
	}
	
	public int calculate(MapGame map, LinkedList<Enemy >enemies, Player player) {
		if(got) {

			
			if(direction == 0) {
				if((map.getValue((coor_y - 2) / 8, (coor_x) /8 ) == 0 || map.getValue((coor_y - 2) / 8, (coor_x) /8 ) == 4) &&  (map.getValue(coor_y/8 , (coor_x + 4)  / 8 ) == 0 || map.getValue(coor_y/8 , (coor_x + 4)  / 8 ) == 4 ) && ( map.getValue((coor_y)/8 , (coor_x + 7)  / 8 ) == 0 || map.getValue((coor_y)/8 , (coor_x + 7)  / 8 ) == 4 ) && coor_y > 10) {
					if(!enemy) {
					for(int i = 0; i < enemies.size(); i++)
						if(((coor_y < enemies.get(i).getY() + 16) && coor_y > enemies.get(i).getY()) && (( enemies.get(i).getX() - 5 < coor_x) && (coor_x < (enemies.get(i).getX() + 16))) ) {
							enemies.get(i).setDead();
							player.killOne();
							got = false;
							
							return 1;
					
						}
					}
					if(enemy) {
						if(((coor_y < player.getY() + 16) && coor_y > player.getY()) && (( player.getX() < coor_x + 4) && (coor_x + 4 < (player.getX() + 16)))) {
							if(!(player.getDefend())){
								got = false;
								player.deadPlayer();
								return 2;
							}else{
								got = false;
								player.deleteDefend();
								return 2;
							}
						}
					}
					coor_y--;
					if(map.getValue((coor_y - 2) / 8, (coor_x + 4)  / 8 ) == 1  ){
						map.set((coor_y - 2)/8, (coor_x + 4)/8);
						
						got = false;
						return 3;
					}if(map.getValue((coor_y - 2)/8  , (coor_x)  / 8 ) == 1) {
						map.set((coor_y - 2)/8, (coor_x)/8);
						
						got = false;
						return 3;
					}if(map.getValue((coor_y - 2)/8 , (coor_x + 7)  / 8 ) == 1) {
						map.set((coor_y - 2)/8, (coor_x + 7)/8);
						
						got = false;
						return 3;
					}
				}
				else {
					got = false;
					return 4;
				}
				
			}else if(direction == 1) {
					if(( map.getValue((coor_y + 1) / 8, (coor_x + 8)  / 8 ) == 0 || map.getValue((coor_y + 1) / 8, (coor_x + 8)  / 8 ) == 4) &&  (map.getValue((coor_y + 4)/8 , (coor_x + 8)  / 8 ) == 0 || map.getValue((coor_y + 4)/8 , (coor_x + 8)  / 8 ) == 4) &&  (map.getValue((coor_y + 7)/8 , (coor_x + 8)  / 8 ) == 0 || map.getValue((coor_y + 7)/8 , (coor_x + 8)  / 8 ) == 4 ) && coor_x < 808) {
						if(!enemy) {
						for(int i = 0; i < enemies.size(); i++)
							if((coor_y > enemies.get(i).getY() && coor_y < enemies.get(i).getY() + 16) && (( enemies.get(i).getX() < coor_x) && (coor_x < (enemies.get(i).getX() + 16))) ) {
								enemies.get(i).setDead();
								player.killOne();
								got = false;
								
								return 1;
						
							}
						}
						if(enemy) {
							if((coor_y + 4 > player.getY() && coor_y + 4 < player.getY() + 16) && (( player.getX() < coor_x + 4) && (coor_x + 4 < (player.getX() + 16))) ) {
								if(!(player.getDefend())){
									got = false;
									player.deadPlayer();
									return 2;
								}else{
									got = false;
									player.deleteDefend();
									return 2;
								}
							}
						}
						coor_x++;
						if(map.getValue((coor_y + 4) / 8, (coor_x + 8)  / 8 ) == 1  ){
							map.set((coor_y + 4)/8, (coor_x+ 8)/8);
							
							got = false;
							return 3;
						}if(map.getValue((coor_y + 1)/8  , (coor_x + 8)  / 8 ) == 1) {
							map.set((coor_y + 1)/8, (coor_x + 8)/8);
							
							got = false;
							return 3;
						}if(map.getValue((coor_y + 7 )/8 , (coor_x + 8)  / 8 ) == 1) {
							map.set((coor_y + 7)/8, (coor_x + 8)/8);
							
							got = false;
							return 3;
						}
					}
					else {
						got = false;
						return 4;
					}
			}else if(direction == 2) {
				if((map.getValue((coor_y + 7) / 8, (coor_x + 1)  / 8 ) == 0 || map.getValue((coor_y + 7) / 8, (coor_x + 1)  / 8 ) == 4 ) &&  (map.getValue((coor_y + 7)/8 , (coor_x + 4)  / 8 ) == 0 || map.getValue((coor_y + 7)/8 , (coor_x + 4)  / 8 ) == 4 ) &&  (map.getValue((coor_y + 7)/8 , (coor_x + 8)  / 8 ) == 0 || map.getValue((coor_y + 7)/8 , (coor_x + 8)  / 8 ) == 4 ) && coor_y < 650) {
					if(!enemy) {
					for(int i = 0; i < enemies.size(); i++)
						if((coor_y + 7 > enemies.get(i).getY() && coor_y + 7 < enemies.get(i).getY() + 16) && (( enemies.get(i).getX() < coor_x + 4) && (coor_x + 4 < (enemies.get(i).getX() + 16))) ) {
							enemies.get(i).setDead();
							player.killOne();
							got = false;
							
							return 1;
						}
					}
							if(enemy) {
								if((coor_y + 7 > player.getY() && coor_y + 7 < player.getY() + 16) && (( player.getX() - 2 < coor_x + 4) && (coor_x + 4 < (player.getX() + 16))) ) {
									if(!(player.getDefend())){
										got = false;
										player.deadPlayer();
										return 2;
									}else{
										got = false;
										player.deleteDefend();
										return 2;
									}
								}
							}
							coor_y++;
							if(map.getValue((coor_y + 7) / 8, (coor_x + 4)  / 8 ) == 1  ){
								map.set((coor_y + 7)/8, (coor_x + 4)/8);
								
								got = false;
								return 3;
							}if(map.getValue((coor_y + 7)/8  , (coor_x + 1)  / 8 ) == 1) {
								map.set((coor_y + 7)/8, (coor_x + 1)/8);
								
								got = false;
								return 3;
							}if(map.getValue((coor_y + 7 )/8 , (coor_x + 8)  / 8 ) == 1) {
								map.set((coor_y + 7)/8, (coor_x + 8)/8);
								
								got = false;
								return 3;
							}
						}
						else {
							got = false;
							return 4;
						}
			}else if(direction == 3) {
				if((map.getValue((coor_y - 1) / 8, (coor_x)  / 8 ) == 0 || map.getValue((coor_y - 1) / 8, (coor_x)  / 8 ) == 4 ) &&  (map.getValue((coor_y + 4)/8 , (coor_x)  / 8 ) == 0 || map.getValue((coor_y + 4)/8 , (coor_x)  / 8 ) == 4) &&  (map.getValue((coor_y + 7)/8 , (coor_x)  / 8 ) == 0 || map.getValue((coor_y + 7)/8 , (coor_x)  / 8 ) == 4  ) && coor_x > 5) {
					if(!enemy) {
					for(int i = 0; i < enemies.size(); i++)
						if(((coor_y > enemies.get(i).getY()) && (coor_y < enemies.get(i).getY() + 16)) && (( enemies.get(i).getX() < coor_x) && (coor_x < (enemies.get(i).getX() + 16))) ) {
							enemies.get(i).setDead();
							player.killOne();
							got = false;
							return 1;
						}
					}
					if(enemy) {
						if(((coor_y + 4 > player.getY()) && (coor_y + 4 < player.getY() + 16)) && (( player.getX() < coor_x) && (coor_x < (player.getX() + 16)))) {
							if(!(player.getDefend())){
								got = false;
								player.deadPlayer();
								return 2;
							}else{
								got = false;
								player.deleteDefend();
								return 2;
							}
						}
					}
					coor_x--;
					if(map.getValue((coor_y + 4) / 8, (coor_x)  / 8 ) == 1  ){
						map.set((coor_y + 4)/8, (coor_x )/8);
						
						got = false;
						return 3;
					}if(map.getValue((coor_y + 1)/8  , (coor_x)  / 8 ) == 1) {
						map.set((coor_y + 1)/8, (coor_x)/8);
						
						got = false;
						return 3;
					}if(map.getValue((coor_y + 7 )/8 , (coor_x)  / 8 ) == 1) {
						map.set((coor_y + 7)/8, (coor_x)/8);
						
						got = false;
						return 3;
					}

				}else {
					got = false;
					return 4;
				}
			}
		}
		else {
			return 5;
		}
		return 0;
	}
	
	public boolean getCondition() {
		return got;
	}
	

	
	public void setX(int i) {
		coor_x = i;
	}
	
	public void setY(int i) {
		coor_y = i;
	}
	
	public int getX() {
		return coor_x;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public int getY() {
		return coor_y;
	}
}
