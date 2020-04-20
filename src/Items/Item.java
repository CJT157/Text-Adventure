package Items;

public abstract class Item {

	protected String name;
	protected int stack;

	public Item(String name, int stack) {
		this.name = name;
		this.stack = stack;
	}

	abstract void use();

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
