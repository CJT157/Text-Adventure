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
			String[] list = items.toLowerCase().split(",");

			for (int i = 0; i < list.length; i++) {
				list[i] = list[i].substring(0, 1).toUpperCase() + list[i].substring(1);
				itemList.add(list[i]);
			}
		}

		while (!input.equalsIgnoreCase("e")) {
			printScroll(text);
			input = wordCasing(sc.nextLine());
			read(input.trim().split(" "), itemList);
		}
	}

	public void read(String[] response, ArrayList<String> itemList) {

		if (response[0].equals("Take") || response[0].equals("T")) {
			for (int i = 1; i < response.length; i++) {
				if (!itemList.contains(response[i])) {
					System.out.println("Unknown item: " + response[i]);
					break;
				} else {
					inv.addItem(response[i]);
					itemList.remove(response[i]);
				}
			}
		} else if (response[0].equals("Talkto")) {
			System.out.println("TALKTO NOT FINISHED");
		} else if (response[0].equals("Search") || response[0].equals("S")) {
			if (itemList.isEmpty()) {
				System.out.println("Nothing here");
			} else {
				for (String s : itemList) {
					System.out.print(s + " ");
				}
				System.out.println();
			}
		} else if (response[0].equals("Fight") || response[0].equals("F")) {
			System.out.println("FIGHT NOT FINISHED");
		} else if (response[0].equals("Use")) {
			System.out.println("USE NOT FINISHED");
		} else if (response[0].equals("Drop")) {
			inv.removeItem(response[1]);
		} else if (response[0].equals("Help") || response[0].equals("H")) {
			System.out.println("Possible commands:\n"
					+ "take       talkto     use        f(ight)\n"
					+ "search     d(rop)     m(enu)     i(nv)\n"
					+ "c(ontinue)");
		} else if (response[0].equals("Menu") || response[0].equals("M")) {
			System.out.println("MENU NOT FINISHED"); // need to design menu
		} else if (response[0].equals("Inv") || response[0].equals("I")) {
			System.out.println(inv.toString());
		} else if (response[0].equals("E") || response[0].equals("Exit")) {

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
	
	public String wordCasing(String input) {
		String[] newInput = input.toLowerCase().split(" ");
		String result = "";
		for (int i = 0; i < newInput.length; i++) {
			result += newInput[i].substring(0, 1).toUpperCase() + newInput[i].substring(1) + " ";
		}
		
		return result;
	}
}
