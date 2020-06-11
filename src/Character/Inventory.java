package Character;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Game.Item;

public class Inventory {
	
	private Map<String, Item> items = new HashMap<String, Item>();
	private Set<Item> inv = new HashSet<Item>();

	/*
	 * TODO: This is bad and needs to be redone
	 * 			All character inventories need to be redone to not require all items to be added to this hashmap.
	 * 			12 am idea, create item objects but have the main one keep a dict of all item id's and searches it to match the name
	 * 			Then get the item from that(somehow) and add it to the inventory
	 * 			I really don't know how that would work but I think the workflow makes sense
	 * 			anything to get rid of what's below this
	 */
	
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
