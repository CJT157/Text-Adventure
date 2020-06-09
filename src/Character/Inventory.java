package Character;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Game.Item;

public class Inventory {

	/*
	 * TODO: Make it so it is possible to drop/add multiple items at a time
	 */
	
	private Map<String, Item> items = new HashMap<String, Item>();
	private Set<Item> inv = new HashSet<Item>();

	public void readItems(){
		for (int i = 1; i <= 8; i++) {
			Item item = new Item(i);
			items.put(item.getName(), item);
		}
	}

	public void addItem(String name, int numItems) {
		Item item = getItem(name);
		if (!this.hasItem(name)) {
			inv.add(item);
		}
		item.addCount(numItems);
	}

	public Item getItem(String name) {
		return items.get(name);
	}

	public void removeItem(String name) {
		Item item = getItem(name);
		if (this.hasItem(name)) {
			if (item.getStack() <= 1) {
				inv.remove(item);
			} else {
				item.subtractCount(1);
			}
		}
	}

	public boolean hasItem(String name) {
		if (inv.contains(getItem(name))) {
			return true;
		}
		return false;
	}

	public String toString() {
		String inventory = "";
		if (!inv.isEmpty()) {
			for (Item i : inv) {
				inventory += i + "\n";
			}
			
		} else {
			inventory += "Empty\n";
		}
		return inventory;
	}

}
