package Character;

import Game.Main;

public class Player extends Character {

	public Player(String name, int health, int damage, int defense) {
		super(name, health, damage, defense);
	}
	
	public void takeItem(String item, int numItems) {
		inv.addItem(item, numItems);
	}
	
	public void dropItem(String item, int numItems) {
		inv.removeItem(item, numItems);
	}
	
	public void talkTo() throws InterruptedException {
		Main.println("TALKTO NOT FINISHED");
	}
	
	public void fight() throws InterruptedException {
		Main.println("FIGHT NOT FINISHED");
	}
	
	public void use() throws InterruptedException {
		Main.println("USE NOT FINISHED");
	}
	
	public String printInv() {
		return inv.toString();
	}
}
