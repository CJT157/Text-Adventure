

public class Item {

	private String name;
	private int stack;
	private int maxStack;
	private int hp;
	private int damage;
	
	public Item(int id) {
		this.name = "";
		this.stack = 0;
		this.maxStack = 0;
		this.hp = 0;
		this.damage = 0;
		setDefaults(id);
	}
	
	public void setDefaults(int id) {
		if (id == 1) {
			this.name = "Apple";
			this.maxStack = 100;
		} else if (id == 2) {
			this.name = "Carrot";
			this.maxStack = 100;
		} else if (id == 3) {
			this.name = "Stick";
			this.maxStack = 1;
		} else if (id == 4) {
			this.name = "Bat";
			this.maxStack = 1;
		} else if (id == 5) {
			this.name = "Sword";
			this.maxStack = 1;
		} else if (id == 6) {
			this.name = "Can";
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

	public int getStack() {
		return stack;
	}

	public void setStack(int stack) {
		this.stack = stack;
	}

	public String toString() {
		return name + ": " + stack;
	}
}
