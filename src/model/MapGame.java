package model;

import java.io.FileInputStream;
import java.io.IOException;

public class MapGame {
	
	private  String PATH = "res/";
	
	private  String NAMEFILE = "Somethimg.txt";
	
	private  int [][] map;
	public MapGame() {
		try {
		map = new int[Game.HIGHT/8][Game.WIDTH/8];
		FileInputStream fin = new FileInputStream(PATH + NAMEFILE);
		int width = 0;
		int sort = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length * 2 + 1;j++) {
				
				sort = fin.read();

			
				if(sort < 48) {
					continue;
				}else {
					map[i][width] = sort - 48;
					width++;
				}
				
			}
		
	
			width = 0;
			
		}
		
		fin.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getValue(int i, int j) {
		return map[i][j];
	}
	
	public int getSizeWidth() {
		return map.length;
	}
	
	public int getSizeLength() {
		return map[0].length;
	}
	
	public void set(int x, int y) {
		map[x][y] = 0;
	}
}
