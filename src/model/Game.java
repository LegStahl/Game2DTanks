package model;



import java.util.LinkedList;

import view.Display;



public class Game implements Runnable {
	
	public static final int WIDTH = 816; 
	
	public static final int HIGHT = 640; 
	
	public static boolean GAMEON = true;
	
	public static final String TITLE = "Tanks"; 
	
	public static final float COUNT_UPDATE = 60.0f;
	
	public static final float UPDATE_INTERVAL = 1000000000 / COUNT_UPDATE;
	
	public static final long SLEEP_TIME = 1000; 
	
	public static final long	IDLE_TIME		= 1;
	
	public static final long	SECOND	= 1000000000l;

	public static final int COUNT_OF_ENEMIES = 10;
	
	public static final int COUNT_OF_POSITION = 4;
	
	public static final int COUNT_OF_ITEMS = 5;
	
	
	private Display ourWindow;
	
	
	
	private Thread gameThread;

	private Player player;
	
	private LinkedList<Enemy> enemies;
	
	private LinkedList<Items> items;
	
	private MapGame MapGames;
	
	private LinkedList<Shot> shots;
	
	public static int currentEnem;
	
	public static int currentItems;
	 
	public static boolean PVP;
	
	private long TIME;
	
	private long TIME_FOR_ITEMS;
	
	private int counterY;
	
	private int counterX;
	
	private int coor_x[] = {664, 170, 726, 100, 300};
	
	private int coor_y[] = {56, 552, 500, 80, 300};
	
	public Game() {
		
		
		
		shots = new LinkedList<Shot>();
		
		enemies = new LinkedList<Enemy>();
		
		items = new LinkedList<Items>();
		
		player = new Player();
		
		MapGames = new MapGame();
		
		ourWindow = new Display(WIDTH, HIGHT, TITLE, MapGames, shots, enemies, player, items);
		
		currentEnem = 0;
		
		currentItems = 0;
		
		
	}
	
	public synchronized  void start() {
	
		counterY = 0;
		
		counterX = 0;
		
		gameThread = new Thread(this);
		
		gameThread.start();
	}
	

	
	private void update() {
	
			long time = System.nanoTime();
			
			
	
			if(  time - TIME > SECOND * 5  && COUNT_OF_ENEMIES > currentEnem ) {
				TIME = System.nanoTime();
				time = System.nanoTime();
				enemies.add(new Enemy (coor_x[(counterX ++ ) % (coor_x.length)],coor_y[(counterY ++) % coor_x.length],counterX % 4));
				currentEnem++;
			
			}else if(currentEnem == COUNT_OF_ENEMIES) {
				TIME = System.nanoTime();
			}
			
			long time_for_items = System.nanoTime();
			
			if(  time_for_items - TIME_FOR_ITEMS > SECOND * 15  && COUNT_OF_ITEMS > currentItems ) {
				TIME_FOR_ITEMS = System.nanoTime();
				time_for_items = System.nanoTime();
				items.add(new Items (coor_x[(counterX ) % (coor_x.length)],coor_y[(counterY) % coor_x.length]));
				currentItems++;
			
			}else if(currentEnem == COUNT_OF_ENEMIES) {
				TIME_FOR_ITEMS  = System.nanoTime();
			}
			
			
			for(int i = 0; i < enemies.size(); i++) {
				enemies.get(i).moveEnem(MapGames, shots);
			}
			
			
			for(int i = 0; i < items.size(); i++) {
				items.get(i).checkTake(player);
			}
			
			for(int i = 0; i < shots.size(); i++) {
				shots.get(i).calculate(MapGames, enemies, player);
			}
			
		

			

	}
	

	
	private void render() {
		
			ourWindow.render();
		
	}
	
	public void run() {
		int fps = 0;
		int upd = 0;
		int updl = 0;

		long count = 0;

		float delta = 0;
		


		long lastTime = System.nanoTime();
		while (player.getLive()) {
	
				long now = System.nanoTime();
				long elapsedTime = now - lastTime;
				lastTime = now;

	
		
	
				boolean render = false;
		
					count += elapsedTime;
					delta += (elapsedTime / UPDATE_INTERVAL);
					while (delta > 1) {
						if(GAMEON)
							update();
						upd++;
						delta--;
						if (render) {
							updl++;
						} else {
							render = true;
						}
					}
				

		
					if (render) {
						if(GAMEON)
							render();
						fps++;
					} else {
						try {
							Thread.sleep(IDLE_TIME);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
			
					if (count >= SECOND) {
						ourWindow.setTitle(TITLE + " || Fps: " + fps + " | Upd: " + upd + " | Updl: " + updl + " Record: " + player.getRecord());
						upd = 0;
						fps = 0;
						updl = 0;
						count = 0;
					}

		}
		ourWindow.end(player.getRecord());
	}
	

}
