package Game;

import java.util.ArrayList;

public class Choice {

	private String text;
	private String[] choices;
	private ArrayList<String> items;
	private int choiceKey;
	
	public Choice(String text, String choices, String items, int choiceKey) {
		this.text = text;
		this.choices = choices.split(",");
		this.items = addItems(items);
		this.choiceKey = choiceKey;
	}
	
	public ArrayList<String> addItems(String items) {
		ArrayList<String> itemList = new ArrayList<String>();
		String[] list = items.toLowerCase().split(",");

		for (int i = 0; i < list.length; i++) {
			list[i] = list[i].substring(0, 1).toUpperCase() + list[i].substring(1);
			itemList.add(list[i]);
		}
		
		return itemList;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String[] getChoices() {
		return choices;
	}

	public void setChoices(String[] choices) {
		this.choices = choices;
	}
	
	public ArrayList<String> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<String> items) {
		this.items = items;
	}

	public int getChoiceKey() {
		return choiceKey;
	}

	public void setChoiceKey(int choiceKey) {
		this.choiceKey = choiceKey;
	}
	
	public String toString() {
		String options = "";
		for (int i = 0; i < this.choices.length; i++) {
			options += "[" + (i + 1) + "] " + this.choices[i] + "\n";
		}
		return text + "\n" + options;
	}
	
}
