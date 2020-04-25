package Game;

public class Item {

	private String name;
	private int hp;
	private int damage;
	private String material;
	private int stack;
	private int maxStack;
	
	public Item(int id) {
		this.name = "";
		this.damage = 0;
		this.hp = 0;
		this.material = "";
		this.stack = 0;
		this.maxStack = 0;
		setDefaults(id);
	}
	
	public void setDefaults(int id) {
		if (id == 1) {
			this.name = "Apple";
			this.hp = 5;
			this.maxStack = 100;
		} else if (id == 2) {
			this.name = "Carrot";
			this.hp = 4;
			this.maxStack = 100;
		} else if (id == 3) {
			this.name = "Stick";
			this.maxStack = 1;
		} else if (id == 4) {
			this.name = "Bat";
			this.damage = 8;
			this.maxStack = 1;
		} else if (id == 5) {
			this.name = "Sword";
			this.damage = 12;
			this.maxStack = 1;
		} else if (id == 6) {
			this.name = "Can";
			this.material = "metal";
			this.maxStack = 100;
		} else if (id == 7) {
			this.name = "Key";
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

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
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
