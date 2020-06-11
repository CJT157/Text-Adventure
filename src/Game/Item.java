package Game;

public class Item {
	
	/*
	 * TODO: Be ready for this to be overhauled to allowed items to be used and have specific functions.
	 * 			May result in needing to abstract this stuff out but this system works so far
	 */

	private String name;
	private int heal;
	private int damage;
	private int stack;
	private int maxStack;
	private Material material;
	
	enum Material {
		None, Wood, Stone, Metal;
	}
	
	public Item(int id) {
		this.name = "";
		this.damage = 0;
		this.heal = 0;
		this.material = Material.None;
		this.stack = 0;
		this.maxStack = 0;
		setDefaults(id);
	}
	
	public void setDefaults(int id) {
		if (id == 1) {
			this.name = "Apple";
			this.heal = 5;
			this.maxStack = 100;
		} else if (id == 2) {
			this.name = "Carrot";
			this.heal = 4;
			this.maxStack = 100;
		} else if (id == 3) {
			this.name = "Blueberry";
			this.heal = 7;
			this.maxStack = 100;
		} else if (id == 4) {
			this.name = "Strawberry";
			this.heal = 7;
			this.maxStack = 100;
		} else if (id == 5) {
			this.name = "Peach";
			this.heal = 6;
			this.maxStack = 100;
		} else if (id == 6) {
			this.name = "Popcorn";
			this.heal = 8;
			this.maxStack = 100;
		} else if (id == 7) {
			this.name = "Key";
			this.maxStack = 100;
		} else if (id == 8) {
			this.name = "Sword";
			this.damage = 12;
			this.maxStack = 1;
		} else if (id == 9) {
			this.name = "Stick";
			this.material = Material.Wood;
			this.maxStack = 1;
		} else if (id == 10) {
			this.name = "Bat";
			this.damage = 8;
			this.maxStack = 1;
		} else if (id == 11) {
			this.name = "Flower-ring";
			this.maxStack = 100;
		} else if (id == 12) {
			this.name = "Water-bottle";
			this.heal = 5;
			this.maxStack = 100;
		} else if (id == 13) {
			this.name = "Fuzzy-socks";
			this.maxStack = 100;
		} else if (id == 14) {
			this.name = "Rock";
			this.material = Material.Stone;
			this.maxStack = 100;
		} else if (id == 15) {
			this.name = "Fancy-rock";
			this.material = Material.Stone;
			this.maxStack = 100;
		} else if (id == 16) {
			this.name = "Can";
			this.material = Material.Metal;
			this.maxStack = 100;
		}
	}
	
	public void addCount(int num) {
		this.stack += num;
	}

	public void subtractCount(int num) {
		this.stack -= num;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeal() {
		return heal;
	}

	public void setHeal(int heal) {
		this.heal = heal;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public int getStack() {
		return stack;
	}

	public void setStack(int stack) {
		this.stack = stack;
	}
	
	public int getMaxStack() {
		return maxStack;
	}

	public void setMaxStack(int maxStack) {
		this.maxStack = maxStack;
	}

	public String toString() {
		return name + ": " + stack;
	}
}
