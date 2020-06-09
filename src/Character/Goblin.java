package Character;

import java.util.HashMap;
import java.util.Map;

import Game.Item;

public class Goblin extends Enemy {

	private Map<Item, Double> lootTable = new HashMap<Item, Double>();
	
	public Goblin(String name, int health, int damage, int defense, String table) {
		super(name, health, damage, defense);
		invInit();
		generateLootTable(table);
	}
	
	public void generateLootTable(String table) {
		String[] loot = table.split(",");
		double dropChance = 0;
		for (int i = 1; i < loot.length; i++) {
			if (i % 2 == 0) {
				Item item = inv.getItem(loot[i]);
				this.lootTable.put(item, dropChance);
			} else {
				dropChance = Double.parseDouble(loot[i]);
			}
		}
	}
}
