import java.util.ArrayList;
import java.util.Scanner;

public class TextSystem {

	private Scanner sc = new Scanner(System.in);
	private Inventory inv = new Inventory();

	public TextSystem(Inventory inv) {
		this.inv = inv;
	}

	public void print(String text, String items) throws InterruptedException {
		ArrayList<String> itemList = new ArrayList<String>();
		String input = "";

		if (!items.equals("")) {
			String[] list = items.split(",");

			for (String s : list) {
				itemList.add(s);
			}
		}

		while (!input.equalsIgnoreCase("e")) {
			printScroll(text);
			input = sc.nextLine();
			read(input.split(" "), itemList);
		}
	}

	public void read(String[] response, ArrayList<String> itemList) {

		if (response[0].equals("take")) {
			for (int i = 1; i < response.length; i++) {
				if (!itemList.contains(response[i])) {
					System.out.println("Unknown item: " + response[i]);
					break;
				} else {
					inv.addItem(response[i]);
					itemList.remove(response[i]);
				}
			}
		} else if (response[0].equals("talkto")) {
			System.out.println("TALKTO NOT FINISHED");
		} else if (response[0].equals("search")) {
			if (itemList.isEmpty()) {
				System.out.println("Nothing here");
			} else {
				for (String s : itemList) {
					System.out.println(s);
				}
			}
		} else if (response[0].equals("fight") || response[0].equals("f")) {
			System.out.println("FIGHT NOT FINISHED");
		} else if (response[0].equals("use")) {
			System.out.println("USE NOT FINISHED");
		} else if (response[0].equals("drop")) {
			inv.removeItem(response[1]);
		} else if (response[0].equals("help") || response[0].equals("h")) {
			System.out.println("Possible commands:\n" + "take     talkto   use      f(ight)\n"
					+ "search   d(rop)   m(enu)   i(nv)\n" + "e(xit)");
		} else if (response[0].equals("menu") || response[0].equals("m")) {
			System.out.println("MENU NOT FINISHED"); // need to design menu
		} else if (response[0].equals("inv") || response[0].equals("i")) {
			System.out.println(inv.toString());
		} else if (response[0].equals("e") || response[0].equals("exit")) {

		} else {
			System.out.println("Could you repeat that? Type help for commands.");
		}

	}

	public void printScroll(String text) throws InterruptedException {
		if (text.contains("\n")) {
			String[] texts = text.split("\n");
			for (int i = 0; i < texts.length; i++) {
				for (int j = 0; j < texts[i].length(); j++) {
					System.out.print(texts[i].charAt(j));
					Thread.sleep(0);
				}
				System.out.println();
			}
		} else {
			for (int i = 0; i < text.length(); i++) {
				System.out.print(text.charAt(i));
				Thread.sleep(0);
			}
			System.out.println();
		}
	}

	/*
	 * System to allow for endless item/text interaction while looking for q to exit
	 * ArrayList to always check if itemlist is empty Then have a message read if it
	 * is empty and you try to pick something up
	 * 
	 */

}
