package Game;

import java.util.HashMap;
import java.util.Map;

/**
 * To add new dialogue/choice options, follow the format of choiceList.put
 * 	and match the first number sequence with where it comes in the line of choices.
 * @author cjayt
 *
 */
public class ChoiceCompiler {
	
	private static Map<String, Input> choiceList = new HashMap<String, Input>();
	
	public static Map<String, Input> getChoices(String firstChoice) {
		switch (firstChoice) {
		case "":
			getZero();
			break;
		case "1":
			getOne();
			break;
		case "2":
			getTwo();
			break;
		}
		
		return choiceList;
	}
	
	public static void getZero() {
		choiceList.put("1",
				new Input(
						"Hello! Welcome!\n"
								+ "This is some test dialogue, please choose which path you would like to go down.",
						"The right path,The left path", "apple3,carrot1,stick1", 1));
		choiceList.put("2",
				new Input(
						"This is just some test dialogue to see how the second",
						"The right path,The left path", "apple3,carrot1,stick1", 2));
	}
	
	public static void getOne() {
		choiceList.put("11", new Input("Ah, the right path, very good job!\n" + "What would you like to do now?",
				"Continue walking,Stop and look around", "apple1,carrot1", 11));

		choiceList.put("111", new Input("Oooh alright you're in a hurry, let's see what the right path has to offer!",
				"This is the end of this branch", "apple1", 111));

		choiceList.put("112",
				new Input(
						"Great! This gives me some time to tell you useful information.\n"
								+ "Trying entering [s] to search for any items around here.\n"
								+ "Enter your next choice after you've looked around",
						"This is the end of this branch", "apple1,carrot1", 112));
	}
	
	public static void getTwo() {
		choiceList.put("21",
				new Input(
						"I have some test dialogue right here",
						"The right path,The left path", "apple3,carrot1,stick1", 21));
		choiceList.put("22",
				new Input(
						"Here is some test  dialogue",
						"The right path,The left path", "apple3,carrot1,stick1", 22));
	}
}
