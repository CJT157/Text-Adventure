package Items;

public class Fruit extends Food {

	public Fruit(String name, int num, int hp) {
		super(name, num, hp);
	}

	@Override
	public int eat() {
		return this.hp;
	}

}
