package Game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Character.Player;

public class TextSystem {
	
	private Player p = new Player("", 0, 0, 0);
	private ArrayList<String> itemList = new ArrayList<String>();
	private Map<Integer, String> choiceList = new HashMap<Integer, String>();
	
	public void Start() throws InterruptedException{
		print("Welcome to my first decent Choose Your Own Adventure Game\n", "Go left,Go right", "apple,carrot");
		
	}
	
	public void print(String text, String choices, String items) throws InterruptedException {
		itemList.clear();
		choiceList.clear();
		if (!items.equals("")) {
			String[] list = items.toLowerCase().split(",");

			for (int i = 0; i < list.length; i++) {
				list[i] = list[i].substring(0, 1).toUpperCase() + list[i].substring(1);
				itemList.add(list[i]);
			}
		}
		if (!choices.equals("")) {
			String[] list = choices.trim().split(",");
			
			for (int i = 0; i < list.length; i++) {
				choiceList.put(i+1, list[i]);
				text += "[" + (i + 1) + "] " + list[i] + "\n";
			}
		}
		
		Main.println(text);
	}
	
	public int read(String input) {

		String[] response;

		if (!input.equals("")) {
			response = wordCasing(input).split(" ");

			if (response[0].equals("Take") || response[0].equals("T")) {
				for (int i = 1; i < response.length; i++) {
					if (!itemList.contains(response[i])) {
						Main.println("Unknown item: " + response[i]);
						break;
					} else {
						p.takeItem(response[i]);
						itemList.remove(response[i]);
					}
				}
			} else if (response[0].equals("Talkto")) {
				p.talkTo();
			} else if (response[0].equals("Search") || response[0].equals("S")) {
				if (itemList.isEmpty()) {
					Main.println("Nothing here");
				} else {
					String str = "";
					for (String s : itemList) {
						str += s + " ";
					}
					Main.println(str);
				}
			} else if (response[0].equals("Fight") || response[0].equals("F")) {
				p.fight();
			} else if (response[0].equals("Use")) {
				p.use();
			} else if (response[0].equals("Drop")) {
				p.dropItem(response[1]);
			} else if (response[0].equals("Help") || response[0].equals("H")) {
				Main.println("Possible commands:\n" + "take       talkto     use        f(ight)\n"
						+ "search     d(rop)     m(enu)     i(nv)\n" + "c(ontinue)");
			} else if (response[0].equals("Menu") || response[0].equals("M")) {
				p.menu();
			} else if (response[0].equals("Inv") || response[0].equals("I")) {
				Main.println(p.printInv());
			} else if (response[0].equals("Exit") || response[0].equals("E")) {

			} else {
				try {
					int choice = Integer.parseInt(input);
					if (choiceList.containsKey(choice)) {
						return choice;
					} else {
						Main.println("Sorry, [" + choice + "] isn't an option.");
					}
				} catch (Exception e) {
					Main.println("Could you repeat that? Type help for commands.");
				}
			}
		}
		
		return -1;
	}

	public String wordCasing(String input) {
		if (!input.equals("")) {
			String[] newInput = input.toLowerCase().split(" ");
			String result = "";
			for (int i = 0; i < newInput.length; i++) {
				result += newInput[i].substring(0, 1).toUpperCase() + newInput[i].substring(1) + " ";
			}

			return result;
		}
		return "";
	}
}
