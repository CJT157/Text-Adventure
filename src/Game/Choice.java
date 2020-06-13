package Game;

import java.util.HashMap;

public class Choice {

	private String text;
	private String[] choices;
	private HashMap<String, Integer> items = new HashMap<String, Integer>();
	private int choiceKey;
	private TextType textType;
	
	enum TextType {
		Choice, Battle, Input;
	}
	
	public Choice(String text, String choices, String items, int choiceKey, TextType textType) {
		this.text = text;
		this.choices = choices.split(",");
		this.items = addItems(items);
		this.choiceKey = choiceKey;
		this.textType = textType;
	}
	
	public HashMap<String, Integer> addItems(String items) {
		HashMap<String, Integer> itemList = new HashMap<String, Integer>();
		String[] list = items.toLowerCase().split(",");

		for (int i = 0; i < list.length; i++) {
			list[i] = list[i].substring(0, 1).toUpperCase() + list[i].substring(1);
			
			int numItems = Integer.parseInt(list[i].substring(list[i].length() - 1));
			
			itemList.put(list[i].substring(0, list[i].length() - 1), numItems);
		}
		
		return itemList;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String[] getChoices() {
		return this.choices;
	}

	public void setChoices(String[] choices) {
		this.choices = choices;
	}
	
	public HashMap<String, Integer> getItems() {
		return this.items;
	}
	
	public void setItems(HashMap<String, Integer> items) {
		this.items = items;
	}

	public int getChoiceKey() {
		return this.choiceKey;
	}

	public void setChoiceKey(int choiceKey) {
		this.choiceKey = choiceKey;
	}
	
	public TextType getTextType() {
		return this.textType;
	}

	public void setTextType(TextType textType) {
		this.textType = textType;
	}
	
	
	public String toString() {
		String options = "";
		for (int i = 0; i < this.choices.length; i++) {
			options += "[" + (i + 1) + "] " + this.choices[i] + "\n";
		}
		return text + "\n" + options;
	}
	
}
