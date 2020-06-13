package Game;

import java.util.HashMap;
import java.util.Map;

import Game.Choice.TextType;

/**
 * Serves as a slightly more optimized way of loading the choiceList
 * @author cjayt
 *
 */
public class ChoiceCompiler {
	
	private static Map<String, Choice> choiceList = new HashMap<String, Choice>();
	
	/*
	 * TODO: Literally upgrade all of this to better optimize option grabbing
	 * 			oooh maybe a searching algorithm so 
	 */
	public static Map<String, Choice> getChoices(String firstChoice) {
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
				new Choice(
						"Hello! Welcome!\n"
								+ "This is some test dialogue, please choose which path you would like to go down.",
						"The right path,The left path", "apple3,carrot1,stick1", 1, TextType.Choice));
		choiceList.put("2",
				new Choice(
						"This is just some test dialogue to see how the second",
						"The right path,The left path", "apple3,carrot1,stick1", 1, TextType.Choice));
	}
	
	public static void getOne() {
		choiceList.put("11", new Choice("Ah, the right path, very good job!\n" + "What would you like to do now?",
				"Continue walking,Stop and look around,Hi Kaylee pick this one!,test for batlle,test for input", "apple1,carrot1", 11, TextType.Choice));

		choiceList.put("111", new Choice("Oooh alright you're in a hurry, let's see what the right path has to offer!",
				"This is the end of this branch", "apple1", 111, TextType.Choice));

		choiceList.put("112",
				new Choice(
						"Great! This gives me some time to tell you useful information.\n"
								+ "Trying entering [s] to search for any items around here.\n"
								+ "Enter your next choice after you've looked around",
						"This is the end of this branch", "apple1,carrot1", 112, TextType.Choice));

		choiceList.put("113",
				new Choice(
						"Hi Kaylee! Hehe I wanted to say hi and that I love you and that I\n"
						+ "wrote this section for you <3\n"
						+ "If you want, enter [s] to see what stuff I've left around here for you.\n"
						+ "Oh and then enter [t] and then the name of the item to pick it up!\n"
						+ "Hehe then pick the next choice to continue down my branch of love.\n",
						"Hehe pick me!,Hehe no pick this one", "blueberry2,rock1", 113, TextType.Choice));
		
		choiceList.put("114", new Choice("Oooh alright you're in a hurry, let's see what the right path has to offer!",
				"This is the end of this branch", "apple1", 111, TextType.Battle));
		
		choiceList.put("115", new Choice("Oooh alright you're in a hurry, let's see what the right path has to offer!",
				"This is the end of this branch", "apple1", 111, TextType.Input));
		
		choiceList.put("1131",
				new Choice(
						"Hehe so I wanted to tell you how beautiful you are and that you become\n"
						+ "more beautiful everytime we see each other<3\n"
						+ "I know I tell you all the time but I just really love your smile,\n"
						+ "it's so perfect and I love how big it is and how your whole face lights\n"
						+ "up whenever you smile and I just really love being able to make you smile.\n\n"
						+ "hehe also make sure to look around again\n",
						"Hehe pick me!,Hehe no pick this one", "popcorn2,fancy-rock1", 1131, TextType.Choice));
		choiceList.put("1132",
				new Choice(
						"Hehe so fun fact, I wrote all of this during my lunch break and is why\n"
						+ "I was having trouble getting back to you for a bit.\n"
						+ "Hehe also, did you know that I love ",
						"Hehe pick me!,Hehe no pick this one", "blueberry2,rock1", 1132, TextType.Choice));

		choiceList.put("12", new Choice("Ah, the left path, my favorite!\n" + "What would you like to do now?",
				"Continue walking,Stop and look around", "carrot1", 12, TextType.Choice));

		choiceList.put("121", new Choice("Oh somebody's excited! Let's keep moing and see what we can find.",
				"This is the end of this branch", "carrot1", 121, TextType.Choice));

		choiceList.put("122",
				new Choice(
						"Great! This gives me some time to tell you useful information.\n"
								+ "Trying entering [s] to search for any items around here.\n"
								+ "Enter your next choice after you've looked around",
						"This is the end of this branch", "apple1,carrot1", 112, TextType.Choice));
	}
	
	public static void getTwo() {
		
	}
}
