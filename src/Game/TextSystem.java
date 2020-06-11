package Game;

import java.util.HashMap;
import java.util.Map;

import Character.Player;

public class TextSystem {

	private Player p = new Player("", 0, 0, 0);
	private HashMap<String, Integer> itemList = new HashMap<String, Integer>();
	private Map<String, Choice> choiceList = new HashMap<String, Choice>();
	private Choice currChoice;
	private String choiceHist;

	public TextSystem() {
		this.choiceHist = "";
	}
	
	/*
	 * TODO: So this stuff right here really shouldn't be on the same page as the important system stuff
	 * 		 	I think it should just be outsourced to another doc to free up space here
	 * 
	 * TODO: Text system needs to be more dynamic (I know) to allow for specific sections such as, setting player 
	 * 			info, character dialogue, special occurences I want to spice up gameplay, etc.
	 * 
	 * TODO: Room system (check your notes for full details)
	 * 
	 * TODO: Battle system (plan out mostly before starting that)
	 * 
	 * TODO: 
	 */

	public void initChoices() throws InterruptedException {
		choiceList.put("1",
				new Choice(
						"Hello! Welcome!\n"
								+ "This is some test dialogue, please choose which path you would like to go down.",
						"The right path,The left path", "apple3,carrot1,stick1", 1));

		choiceList.put("11", new Choice("Ah, the right path, very good job!\n" + "What would you like to do now?",
				"Continue walking,Stop and look around,Hi Kaylee pick this one!", "apple1,carrot1", 11));

		choiceList.put("111", new Choice("Oooh alright you're in a hurry, let's see what the right path has to offer!",
				"This is the end of this branch", "apple1", 111));

		choiceList.put("112",
				new Choice(
						"Great! This gives me some time to tell you useful information.\n"
								+ "Trying entering [s] to search for any items around here.\n"
								+ "Enter your next choice after you've looked around",
						"This is the end of this branch", "apple1,carrot1", 112));

		choiceList.put("113",
				new Choice(
						"Hi Kaylee! Hehe I wanted to say hi and that I love you and that I\n"
						+ "wrote this section for you <3\n"
						+ "If you want, enter [s] to see what stuff I've left around here for you.\n"
						+ "Oh and then enter [t] and then the name of the item to pick it up!\n"
						+ "Hehe then pick the next choice to continue down my branch of love.\n",
						"Hehe pick me!,Hehe no pick this one", "blueberry2,rock1", 113));
		
		choiceList.put("1131",
				new Choice(
						"Hehe so I wanted to tell you how beautiful you are and that you become\n"
						+ "more beautiful everytime we see each other<3\n"
						+ "I know I tell you all the time but I just really love your smile,\n"
						+ "it's so perfect and I love how big it is and how your whole face lights\n"
						+ "up whenever you smile and I just really love being able to make you smile.\n\n"
						+ "hehe also make sure to look around again\n",
						"Hehe pick me!,Hehe no pick this one", "popcorn2,fancy-rock1", 1131));
		choiceList.put("1132",
				new Choice(
						"Hehe so fun fact, I wrote all of this during my lunch break and is why\n"
						+ "I was having trouble getting back to you for a bit.\n"
						+ "Hehe also, did you know that I love ",
						"Hehe pick me!,Hehe no pick this one", "blueberry2,rock1", 1132));

		choiceList.put("12", new Choice("Ah, the left path, my favorite!\n" + "What would you like to do now?",
				"Continue walking,Stop and look around", "carrot1", 12));

		choiceList.put("121", new Choice("Oh somebody's excited! Let's keep moing and see what we can find.",
				"This is the end of this branch", "carrot1", 121));

		choiceList.put("122",
				new Choice(
						"Great! This gives me some time to tell you useful information.\n"
								+ "Trying entering [s] to search for any items around here.\n"
								+ "Enter your next choice after you've looked around",
						"This is the end of this branch", "apple1,carrot1", 112));
	}

	public void read(String input) {

		String[] response;

		if (!input.equals("")) {
			response = wordCasing(input).split(" ");

			switch (response[0]) {
			case "Take":
			case "T":
				for (int i = 1; i < response.length; i++) {
					if (response[i].equals("All")) {
						for (Map.Entry<String, Integer> entry : itemList.entrySet()) {
							p.takeItem(entry.getKey(), entry.getValue());
						}
						itemList.clear();
					} else if (!itemList.containsKey(response[i])) {
						Main.println("Unknown item: " + response[i]);
						break;
					} else {
						try {
							int numItems = Integer.parseInt(response[i + 1]);
							p.takeItem(response[i], numItems);
							addToInventory(response[i], numItems);
							i++;
						} catch (Exception e) {
							p.takeItem(response[i], 1);
							addToInventory(response[i], 1);
						}
					}
				}
				break;
			case "Talkto":
				p.talkTo();
				break;
			case "Search":
			case "S":
				if (itemList.isEmpty()) {
					Main.println("Nothing here\n");
				} else {
					String str = "----------------\n";
					for (Map.Entry<String, Integer> entry : itemList.entrySet()) {
						str += entry.getValue() + ": " + entry.getKey() + "\n";
					}
					str += "----------------\n";
					Main.println(str);
				}
				break;
			case "Fight":
			case "F":
				p.fight();
				break;
			case "Use":
				p.use();
				break;
			case "Drop":
			case "D":
				for (int i = 1; i < response.length; i++) {
					if (!p.getInv().hasItem(response[i])) {
						Main.println("Unknown item: " + response[i]);
						break;
					} else {
						try {
							int numItems = Integer.parseInt(response[i + 1]);
							p.getInv().removeItem(response[i], numItems);
							addToList(response[i], numItems);
							i++;
						} catch (Exception e) {
							p.getInv().removeItem(response[i], 1);
							addToList(response[i], 1);
						}
					}
				}
				break;
			case "Help":
			case "H":
				Main.println("Possible commands:\n" + "take       talkto     use        f(ight)\n"
						+ "search     d(rop)     m(enu)\n");
				break;
			case "Menu":
			case "M":
				p.menu();
				break;
			case "Exit":
			case "E":
				break;
			default:
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
							Main.println("Sorry, [" + this.choiceHist.charAt(this.choiceHist.length() - 1)
									+ "] isn't an option.\n");
							this.choiceHist = this.choiceHist.substring(0, (this.choiceHist.length() - 1));
						}
					}
				} catch (Exception e) {
					Main.println("Could you repeat that? Type help for commands.");
				}
			}
		}
	}

	public String getInventory() {
		return p.printInv();
	}

	public void addToInventory(String input, int numItems) {
		if (itemList.get(input) > numItems) {
			itemList.put(input, itemList.get(input) - numItems);
		} else {
			itemList.remove(input);
		}
	}
	
	public void addToList(String input, int numItems) {
		if (itemList.containsKey(input)) {
			itemList.put(input, itemList.get(input) + numItems);
		} else {
			itemList.put(input, numItems);
		}
	}

	/**
	 * Needed for allowing actions to be done in lower and upper case, defaults to
	 * upper case
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
