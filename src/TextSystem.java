import java.util.ArrayList;

public class TextSystem {
	
	public Inventory inv = new Inventory();
	private ArrayList<String> itemList = new ArrayList<String>();
	
	public void Start() throws InterruptedException{
		inv.readItems();
		print("Welcome to my first decent Choose Your Own Adventure Game", "apple");
		print("This is me testing that it will do one at a time", "carrot");
	}
	
	public void print(String text, String items) {
		itemList.clear();
		if (!items.equals("")) {
			String[] list = items.toLowerCase().split(",");

			for (int i = 0; i < list.length; i++) {
				list[i] = list[i].substring(0, 1).toUpperCase() + list[i].substring(1);
				itemList.add(list[i]);
			}
		}
		
		Main.println(text);
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
						inv.addItem(response[i]);
						itemList.remove(response[i]);
					}
				}
			} else if (response[0].equals("Talkto")) {
				Main.println("TALKTO NOT FINISHED");
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
				Main.println("FIGHT NOT FINISHED");
			} else if (response[0].equals("Use")) {
				Main.println("USE NOT FINISHED");
			} else if (response[0].equals("Drop")) {
				inv.removeItem(response[1]);
			} else if (response[0].equals("Help") || response[0].equals("H")) {
				Main.println("Possible commands:\n" + "take       talkto     use        f(ight)\n"
						+ "search     d(rop)     m(enu)     i(nv)\n" + "c(ontinue)");
			} else if (response[0].equals("Menu") || response[0].equals("M")) {
				Main.println("MENU NOT FINISHED"); // need to design menu
			} else if (response[0].equals("Inv") || response[0].equals("I")) {
				Main.println(inv.toString());
			} else if (response[0].equals("Exit") || response[0].equals("E")) {

			} else {
				Main.println("Could you repeat that? Type help for commands.");
			}
		}

	}

	//Unused until it can be reimplemented
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
