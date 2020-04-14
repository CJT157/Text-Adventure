package Items;

public abstract class Item {

	protected String name;
	protected int stack;

	public Item(String name, int stack) {
		this.name = name;
		this.stack = stack;
	}

	abstract void use();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return stack;
	}

	public void setNum(int stack) {
		this.stack = stack;
	}

	public String toString() {
		return name + ": " + stack;
	}
}
