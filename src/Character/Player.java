package Character;

import Game.Main;

public class Player extends Character {

	public Player(String name, int health, int damage, int defense) {
		super(name, health, damage, defense);
	}
	
	public void takeItem(String item) {
		inv.addItem(item);
	}
	
	public void dropItem(String item) {
		inv.removeItem(item);
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
	
	public void menu() {
		Main.println("MENU NOT FINISHED");
	}
	
	public String printInv() {
		return inv.toString();
	}
}
