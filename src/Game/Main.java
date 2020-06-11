package Game;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Stack;

public class Main extends Application{

	public Scene mainScene;
	public TextSystem ts = new TextSystem();
	public static TextArea ta;
	public static TextArea inventory;
	public static TextField tf;
	public Button btn;
	public static int choice = 0;
	public Stack<String> pastInput = new Stack<String>();

	public static void main(String[] args) throws InterruptedException {
		launch(args);
	}
	
	/*
	 * TODO: Spice up visuals a bit, I hate looking at everything
	 * 
	 * TODO: Change entire screen to fxml so styling and control is much easier
	 * 			because html like script is so much easier
	 * 
	 * TODO: Upgrade Allow for player to press up to have up to 10 past inputs reappear
	 */

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Text Adventure");
		
		Scene mainScene = new Scene(textSystem());
		mainScene.getStylesheets().add("global_v1.css");
		
		//This is a mess
		
		GridPane grid = new GridPane();
		grid.setPrefSize(800, 600);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		
		Label title = new Label("Text Adventure");
		grid.add(title, 0, 0);
		
		Button button = new Button("Start Game");
		button.setOnAction(e -> primaryStage.setScene(mainScene));
		grid.add(button, 0, 1);
		
		Scene titleScene = new Scene(grid);
		
		
		primaryStage.setScene(titleScene);
		primaryStage.show();
		
		
		updateInventory();
		println("Welcome to this little adventure\n"
				+ "Press [1] and [enter] to begin\n");
	}
	
	public GridPane textSystem() throws InterruptedException {
		GridPane grid = new GridPane();
		grid.setPrefSize(800, 600);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		
		Label gameLabel = new Label("Text Adventure");
		grid.add(gameLabel, 0, 0);
		
		Label invLabel = new Label("Inventory");
		grid.add(invLabel, 1, 0);
		
		ta = new TextArea();
		ta.setMinSize(400, 300);
		ta.setPrefRowCount(15);
		ta.setEditable(false);
		ta.setFocusTraversable(false);
		grid.add(ta, 0, 1);
		
		inventory = new TextArea();
		inventory.setMaxSize(200, 300);
		inventory.setPrefRowCount(15);
		inventory.setEditable(false);
		inventory.setFocusTraversable(false);
		grid.add(inventory, 1, 1);
		
		tf = new TextField();
		tf.setPromptText("type command here");
		grid.add(tf, 0, 2);
		tf.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent keyEvent) {
				textInput(keyEvent);
				updateInventory();
			}
		});
		
		ts.initChoices();
		
		return grid;
	}
	
	public void textInput(KeyEvent e) {
		
		if (e.getEventType() == KeyEvent.KEY_PRESSED && e.getCode() == KeyCode.ENTER) {
			ts.read(tf.getText());
			pastInput.push(tf.getText());
			tf.clear();
		} else if (e.getEventType() == KeyEvent.KEY_PRESSED && e.getCode() == KeyCode.UP) {
			tf.setText(pastInput.peek());
		}
	}
	
	public void updateInventory() {
		inventory.setText(ts.getInventory());
	}
	
	public static void println(String line) {
		ta.appendText(line + "\n");
	}

}
