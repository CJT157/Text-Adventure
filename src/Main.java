import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		Inventory inv = new Inventory();
		inv.readItems();

		System.out.println("Hello, there's a carrot, apple, and can on the ground");
		
	}
	
	public static void read(String response) {
		
	}
}
