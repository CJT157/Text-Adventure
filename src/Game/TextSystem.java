package Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Character.Player;

public class TextSystem {

	private Player p = new Player("", 0, 0, 0);
	private ArrayList<String> itemList = new ArrayList<String>();
	private Map<String, Choice> choiceList = new HashMap<String, Choice>();
	private Choice currChoice;
	private String choiceHist;

	public TextSystem() {
		this.choiceHist = "";
	}

	public void initChoices() throws InterruptedException {
		choiceList.put("1", new Choice(
				"Hello! Welcome!\n"
				+ "This is some test dialogue, please choose which path you would like to go down.",
				"The right path,The left path", "apple,carrot", 1));
		
		choiceList.put("11", new Choice("Ah, the right path, very good job!\n"
				+ "What would you like to do now?",
				"Continue walking,Stop and look around", "apple", 11));
		
		choiceList.put("111",
				new Choice("Oooh alright you're in a hurry, let's see what the right path has to offer!", "This is the end of this branch", "apple", 111));
		
		choiceList.put("112", new Choice("Great! This gives me some time to tell you useful information.\n"
				+ "Trying entering [s] to search for any items around here.\n"
				+ "Enter your next choice after you've looked around",
				"This is the end of this branch", "apple,carrot", 112));

		choiceList.put("12", new Choice("Ah, the left path, my favorite!\n" + "What would you like to do now?",
				"Continue walking,Stop and look around", "carrot", 12));
		
		choiceList.put("121",
				new Choice("Oh somebody's excited! Let's keep moing and see what we can find.", "This is the end of this branch", "carrot", 121));
		
		choiceList.put("122",
				new Choice("Great! This gives me some time to tell you useful information.\n"
						+ "Trying entering [s] to search for any items around here.\n"
						+ "Enter your next choice after you've looked around",
						"This is the end of this branch", "apple,carrot", 112));
	}

	public void read(String input) {

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
					Main.println("Nothing here\n");
				} else {
					String str = "";
					for (String s : itemList) {
						str += s + " ";
					}
					str += "\n";
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
						+ "search     d(rop)     m(enu)     i(nv)\n" + "c(ontinue)\n");
			} else if (response[0].equals("Menu") || response[0].equals("M")) {
				p.menu();
			} else if (response[0].equals("Inv") || response[0].equals("I")) {
				Main.println(p.printInv());
			} else if (response[0].equals("Exit") || response[0].equals("E")) {

			} else {
				try {
					if (input.length() > 1) {
						Main.println("Only type one number at a time please.\n");
					} else {
						this.choiceHist += Integer.parseInt(input);
						if (choiceList.containsKey(this.choiceHist)) {
							
							this.currChoice = choiceList.get(choiceHist);
							this.itemList = this.currChoice.getItems();
							
							Main.println(this.currChoice.toString());
							
						} else {
							Main.println("Sorry, [" + this.choiceHist.charAt(this.choiceHist.length() - 1) + "] isn't an option.\n");
							this.choiceHist = this.choiceHist.substring(0, (this.choiceHist.length() - 1));
						}
					}
				} catch (Exception e) {
					Main.println("Could you repeat that? Type help for commands.");
				}
			}
		}
	}

	/**
	 * Needed for allowing actions to be done in lower and upper case, defaults to upper case
	 * 
	 * @param input : user text input
	 * @return string with all words capitalized
	 */
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
