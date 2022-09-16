package test;

import java.util.LinkedList;

import model.Enemy;
import model.MapGame;
import model.Player;
import model.Shot;

public class TestShots {
	private static int total;
    private static int failed;
    private static LinkedList<Enemy> enemies;
    private static LinkedList<Shot> shots;
    private static Player player;
    private static MapGame map;

    public static void showStat() {
        if (failed == 0) {
            System.out.println("\nOK");
        }
        else
            System.out.println(failed + " tests of " + total + " failed.");
    }

    private static void checkMetal() {
        total++;
        shots.add(new Shot(176, 80, 0, false ));
        if((shots.get(0).calculate(map, enemies, player)) == 4) {
        	System.out.println("SUCCESS");
        	shots.remove(0);
        }
        else {
        	failed++;
        	shots.remove(0);
        }
        
    }

    public static void checkPlayerDead() {
    	total++;
        shots.add(new Shot(250, 252, 0, true ));
        if((shots.get(0).calculate(map, enemies, player)) == 2) {
        	System.out.println("SUCCESS");
        	shots.remove(0);
        }
        else {
        	failed++;
        	shots.remove(0);
        }
    }

    public static void checkEnemyDead() {
    	total++;
        shots.add(new Shot(250, 252, 0, false ));
        enemies.add(new Enemy(249, 250, 0));
        if((shots.get(0).calculate(map, enemies, player)) == 1) {
        	System.out.println("SUCCESS");
        	shots.remove(0);
        	enemies.remove(0);
        }
        else {
        	failed++;
        	shots.remove(0);
        	enemies.remove(0);
        }
    }
    
    public static void checkEmpty() {
    	total++;
        shots.add(new Shot(3, 3, 0, true ));
        if((shots.get(0).calculate(map, enemies, player)) == 4) {
        	System.out.println("SUCCESS");
        	shots.remove(0);
        }
        else {
        	failed++;
        	shots.remove(0);
        }
    }
    
    public static void runTests() {
    	TestShots.checkMetal();
    	TestShots.checkBlock();
    	TestShots.checkPlayerDead();
    	TestShots.checkEnemyDead();
    	TestShots.checkEmpty();
    }

    public static void checkBlock() {
        total++;
        shots.add(new Shot(296, 82, 0, false ));
        if((shots.get(0).calculate(map, enemies, player)) == 3) {
        	System.out.println("SUCCESS");
        	shots.remove(0);
        }
        else {
        	failed++;
        	shots.remove(0);
        }
    }

    public static void main(String[] args) {

		enemies = new LinkedList<Enemy>();
		shots = new LinkedList<Shot>();
		player = new Player();
		player.setX(250);
		player.setY(250);
		map = new MapGame();
        TestShots.runTests();
        TestShots.showStat();
    }
}
