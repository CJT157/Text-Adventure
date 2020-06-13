package Game;

import java.util.HashMap;
import java.util.Map;

import Character.Player;
import Game.Choice.TextType;

public class TextSystem {

	private Player player = new Player("", 0, 0, 0);
	private HashMap<String, Integer> itemList = new HashMap<String, Integer>();
	private Map<String, Choice> choiceList = new HashMap<String, Choice>();
	private Choice currChoice;
	private String choiceHist;
	private int helpHelpCounter;

	public TextSystem() {
		this.currChoice = new Choice("blank",
		"The right path,The left path", "apple3,carrot1,stick1", 1, TextType.Choice);
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
		this.choiceList.putAll(ChoiceCompiler.getChoices(choiceHist));
	}

	public void read(String input) throws InterruptedException {

		String[] response;

		if (!input.equals("")) {
			response = wordCasing(input).split(" ");

			switch (currChoice.getTextType()) {
			case Choice:
				switch (response[0]) {
				case "Take":
				case "T":
					for (int i = 1; i < response.length; i++) {
						if (response[i].equals("All")) {
							for (Map.Entry<String, Integer> entry : itemList.entrySet()) {
								player.takeItem(entry.getKey(), entry.getValue());
							}
							itemList.clear();
						} else if (!itemList.containsKey(response[i])) {
							Main.println("Unknown item: " + response[i]);
							break;
						} else {
							try {
								int numItems = Integer.parseInt(response[i + 1]);
								player.takeItem(response[i], numItems);
								addToInventory(response[i], numItems);
								i++;
							} catch (Exception e) {
								player.takeItem(response[i], 1);
								addToInventory(response[i], 1);
							}
						}
					}
					break;
				case "Talkto":
					player.talkTo();
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
					player.fight();
					break;
				case "Use":
					player.use();
					break;
				case "Drop":
				case "D":
					for (int i = 1; i < response.length; i++) {
						if (response[i].equals("All")) {
							//not finished
							for (int j = 0; j < 1; j++) {
								Main.println("DROP ALL NOT FINISHED");
							}
						} else if (!player.getInv().hasItem(response[i])) {
							Main.println("Unknown item: " + response[i]);
							break;
						} else {
							try {
								int numItems = Integer.parseInt(response[i + 1]);
								player.getInv().removeItem(response[i], numItems);
								addToList(response[i], numItems);
								i++;
							} catch (Exception e) {
								player.getInv().removeItem(response[i], 1);
								addToList(response[i], 1);
							}
						}
					}
					break;
				case "Help":
				case "H":
					try {
						helpInfo(response[1]);
					}
					catch (Exception e) {
						Main.println("Possible commands:\n" + "take       talkto     use        f(ight)\n"
								+ "search     d(rop)     m(enu)\n\n"
								+ "Type h or help [command] for more info.\n");
					}
					break;
				case "Exit":
				case "E":
					Main.println("Exiting the game");
					Main.ta.clear();
					this.itemList.clear();
					this.choiceList.clear();
					this.currChoice = new Choice("blank","blank", "blank2", 1, TextType.Choice);
					this.choiceHist = "";
					Main.primaryStage.setScene(Main.titleScene);
					Main.initMain();
					break;
				default:
					try {
						if (input.length() > 1) {
							Main.println("Only type one number at a time please.\n");
						} else {
							this.choiceHist += Integer.parseInt(input); 
							
							/* Helps compile only one major branch rather than every single branch at a time
							*  Could be improved in the compiler to update it after every choiceHist update
							*  Not sure how resource intensive that would be, but it feels like only searching 
							*  through a couple choices would be better than literally every single one.
							*  
							*  Not an immediate issue though
							*/
							if (this.choiceHist.length() == 1) {
								this.choiceList.putAll(ChoiceCompiler.getChoices(choiceHist));
							}
							
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
				break;
			case Battle:
				Main.println("Hey battle worked");
				break;
			case Input:
				Main.println("Hey input worked");
				break;
			default:
				break;
			}
		}
	}

	public String getInventory() {
		return player.printInv();
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
	
	public void helpInfo(String command) {
		switch (command) {
		case "Drop":
		case "D":
			Main.println("Allows user to drop items from their inventory.\n"
					+ "drop [itemName] [numItems]\n"
					+ "EX: drop apple 1 stick 2\n"
					+ "EX: d apple all\n");
			break;
		case "Exit":
		case "E":
			Main.println("Lets you exit to the title screen but doesn't close the window.\n"
					+ "'exit'\n"
					+ "EX: exit\n"
					+ "EX: e\n");
			break;
		case "Fight":
		case "F":
			Main.println("Starts a fight with the designated character\n"
					+ "'fight [name]'\n"
					+ "EX: fight rock\n"
					+ "EX: f rock\n");
			break;
		case "Help":
		case "H":
			this.helpHelpCounter++;
			if (this.helpHelpCounter == 1) {
				Main.println("No.\n");
			} else if (this.helpHelpCounter == 2) {
				Main.println("I already told you, no.\n");
			} else if (this.helpHelpCounter == 10) {
				Main.println("Seriously? Please just stop already.\n");
			} else {
				Main.println("Please stop.\n");
			}
			break;
		case "Search":
		case "S":
			Main.println("Allows user to look at items around them.\n"
					+ "'search'\n"
					+ "EX: search\n"
					+ "EX: s\n");
			break;
		case "Take":
		case "T":
			Main.println("Allows user to take items from the ground.\n"
					+ "'take [itemName] [numItems]'\n"
					+ "EX: take apple 1 stick 2\n"
					+ "EX: t apple all\n");
			break;
		case "Talkto":
			Main.println("Lets you talk to a nearby character.\n"
					+ "'talkto [name]'\n"
					+ "EX: talkto void\n");
			break;
		case "Use":
			Main.println("No functionality yet\n"
					+ "Lets you use an item.\n"
					+ "'use [item]'\n"
					+ "EX: use apple\n"
					+ "EX: u apple\n");
			break;
		default:
			Main.println("Unknown command, did you enter it wrong?");
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
