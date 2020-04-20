import java.io.FileNotFoundException;

public class Story {
	
	public Inventory inv = new Inventory();
	public TextSystem ts = new TextSystem(inv);
	
	public void Start() throws InterruptedException, FileNotFoundException {
		inv.readItems();
		ts.print("You enter a room with blood on the wall.\n"
				+ "you see a light coming from a nearby doorway.", "apple,carrot,apple,apple");
		ts.print("You continue moving onto the next room.\n"
				+ "There are some things on the floor", "key,can,stick");
	}
}
