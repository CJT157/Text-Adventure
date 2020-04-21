
public class Story {
	
	public Inventory inv = new Inventory();
	public TextSystem ts = new TextSystem(inv);
	
	public void Start() throws InterruptedException{
		inv.readItems();
		ts.print("This is a test run of my text game\n"
				+ "Type e and [Enter] to move on to the next room.", "");
		ts.print("You enter a dark room, type s or search to look around.\n"
				+ "After this, type t or take and the item to grab it.\n"
				+ "Remember to type e after being done in each room.", "stick,apple,carrot");
		ts.print("To check your inventory, type i or inv to check it.\n"
				+ "Also if you ever forget any command, type h or help to list off all available\n"
				+ "Some are not implemented yet.", "can,key");
		ts.print("There's nothing in this room sorry.", "");
	}
}
