import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static Inventory inv = new Inventory();
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		inv.readItems();
		
		String[] items;

		print("There is an apple, carrot, and can on the ground", "apple,carrot,can");
		System.out.println(inv.toString());
		print("test test", "");
	}
	
	public static void read(String[] response, String[] itemList) {
		boolean inList = false;
		
		for (String i : itemList) {
			if (response[1].equals(i)) {
				inList = true;
				break;
			}
		}
		
		if (response[0].equals("take")) {
			inv.addItem(response[1]);
		}
	}
	
	public static void print(String text, String items) {
		String[] itemList = items.split(","); 
		System.out.println(text);
		read(sc.nextLine().split(" "), itemList);
	}
}
