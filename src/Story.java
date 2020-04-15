
public class Story {
	
	public Inventory inv = new Inventory();
	public TextSystem ts = new TextSystem(inv);
	
	public void Start() {
		ts.print("Hello hello hello", "apple,carrot");
		ts.print("text", "");
	}
}
