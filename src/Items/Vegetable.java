package Items;

public class Vegetable extends Food {

	public Vegetable(String name, int num, int hp) {
		super(name, num, num);
	}

	@Override
	public int eat() {
		return this.hp;
	}

}
