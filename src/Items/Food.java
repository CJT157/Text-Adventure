package Items;
abstract class Food extends Item {

	protected int hp;

	public Food(String name, int num, int hp) {
		super(name, num);
		this.hp = hp;
	}

	abstract public int eat();

	@Override
	public void use() {
		eat();
	}

}
