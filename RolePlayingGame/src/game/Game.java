package game;

import java.util.ArrayList;
import java.util.List;

import enemies.*;
import treasure.*;

public class Game {
	
	private GameType gameType = GameType.DESERT;
	private List<Enemy> enemies = new ArrayList<Enemy>();

	private List<Treasure> inventory = new ArrayList<Treasure>();
	public void start(){
		for(int i=0; i<5; i++) {
			System.out.println("Adding Enemy...");
			addNewEnemy(gameType);
		}
		for(int i=0; i<5; i++) {
			System.out.println("Adding Treasure...");
			addNewTreasure(gameType);
		}
		for(Enemy enemy: enemies){
			System.out.println("Class of Enemy: " + enemy.getClass());
		}
		for(Treasure treasure: inventory){
			System.out.println("Class of Treasure: " + treasure.getClass());
		}
		// TODO: implement entertaining game
	}
	
	public void addNewEnemy(GameType gameType) {
		Enemy enemy = null; 
	    if (gameType == GameType.DESERT) {
	      enemy = new Scorpion();  
	    } else if (gameType == GameType.SPACE) {
	      enemy = new Alien();
	    } else if (gameType == GameType.FANTASY) {
	      enemy = new Skeleton();  
	    }
	    enemies.add(enemy);
	}
	public void addNewTreasure(GameType gameType) {
		Treasure treasure = null; 
		if (gameType == GameType.DESERT) {
			treasure = new Cigarette();  
	    } else if (gameType == GameType.SPACE) {
	    	treasure = new AlienArtifact();
	    } else if (gameType == GameType.FANTASY) {
	    	treasure = new SilverCoin();  
	    }
		inventory.add(treasure);
	}
}
