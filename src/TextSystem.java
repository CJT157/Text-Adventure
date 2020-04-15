import java.util.ArrayList;
import java.util.Scanner;

public class TextSystem {

	protected Scanner sc = new Scanner(System.in);
	protected Inventory inv = new Inventory();
	
	public TextSystem(Inventory inv) {
		this.inv = inv;
	}
	
	public void print(String text, String items) {
		String[] list = items.split(","); 
		ArrayList<String> itemList = new ArrayList<String>();
		
		for (String s : list) {
			itemList.add(s);
		}
		
		String input = "";
		while (!input.equalsIgnoreCase("e")) {
			System.out.println(text);
			input = sc.nextLine();
			if (itemList.isEmpty()) {
				
			}
			else {
				read(input.split(" "), itemList);
			}
		}
	}
	
	public void read(String[] response, ArrayList<String> itemList) {
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
	
	/*
	 * System to allow for endless item/text interaction
	 * while looking for q to exit
	 * ArrayList to always check if itemlist is empty
	 * 	Then have a message read if it is empty and you try to pick something up
	 * 
	 */
	
}
