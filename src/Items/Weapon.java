package Items;

public class Weapon extends Item {

	protected int damage;

	public Weapon(String name, int num, int damage) {
		super(name, num);
		this.damage = damage;
	}

	@Override
	void use() {
		// TODO Auto-generated method stub

	}

}