package Character;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Game.Item;

public class Inventory {
	
	private Map<String, Item> items = new HashMap<String, Item>();
	private ArrayList<Item> inv = new ArrayList<Item>();

	public void readItems(){
		for (int i = 1; i <= 16; i++) {
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

	public void removeItem(String name, int numItems) {
		Item item = getItem(name);
		if (this.hasItem(name)) {
			if (item.getStack() <= numItems) {
				inv.remove(item);
			} else {
				item.subtractCount(numItems);
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
