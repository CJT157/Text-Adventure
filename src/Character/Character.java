package Character;

public abstract class Character {
	
	protected String name;
	protected int health;
	protected int damage;
	protected int defense;
	protected Inventory inv = new Inventory();
	
	public Character(String name, int health, int damage, int defense) {
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.defense = defense;
		invInit();
	}
	
	public boolean isDead() {
		if (health <= 0) {
			return true;
		}
		return false;
	}
	
	public void invInit() {
		this.inv.readItems();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

}
