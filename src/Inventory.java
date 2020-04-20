import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Items.*;

public class Inventory {

	private Map<String, Item> items = new HashMap<String, Item>();
	private Set<Item> inv = new HashSet<Item>();

	public void readItems() throws FileNotFoundException {
		File f = new File("dictionary.txt");
		Scanner sc = new Scanner(f);
		String[] item = new String[4];
		sc.nextLine();
		while (sc.hasNextLine()) {
			item = sc.nextLine().split(",");
			switch (item[0]) {
			case "thing":
				items.put(item[1], new Thing(item[1], Integer.parseInt(item[2])));
				break;
			case "vegetable":
				items.put(item[1], new Vegetable(item[1], Integer.parseInt(item[2]), Integer.parseInt(item[3])));
				break;
			case "fruit":
				items.put(item[1], new Fruit(item[1], Integer.parseInt(item[2]), Integer.parseInt(item[3])));
				break;
			case "weapon":
				items.put(item[1], new Weapon(item[1], Integer.parseInt(item[2]), Integer.parseInt(item[3])));
			}
		}
		sc.close();
	}

	public void addItem(String name) {
		Item item = getItem(name);
		if (!this.hasItem(name)) {
			inv.add(item);
		}
		item.addCount(1);
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
		for (Item i : inv) {
			inventory += i + "\n";
		}
		return inventory;
	}

}
