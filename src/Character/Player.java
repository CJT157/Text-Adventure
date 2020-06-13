package Character;

import Game.Main;

public class Player extends Character {
	
	/*
	 * TODO: Pretty much everything this is so under developed
	 */

	public Player(String name, int health, int damage, int defense) {
		super(name, health, damage, defense);
	}
	
	public void takeItem(String item, int numItems) {
		inv.addItem(item, numItems);
	}
	
	public void dropItem(String item, int numItems) {
		inv.removeItem(item, numItems);
	}
	
	public void talkTo() {
		Main.println("TALKTO NOT FINISHED");
	}
	
	public void fight() {
		Main.println("FIGHT NOT FINISHED");
	}
	
	public void use() {
		Main.println("USE NOT FINISHED");
	}
	
	public String printInv() {
		return inv.toString();
	}
}
