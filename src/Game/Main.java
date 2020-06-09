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

public class Main extends Application{

	public TextSystem ts = new TextSystem();
	public static TextArea ta;
	public static TextField tf;
	public Button btn;
	public static int choice = 0;

	public static void main(String[] args) throws InterruptedException {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Text Adventure");
		
		Scene scene = new Scene(createContent());
		scene.getStylesheets().add("global_v1.css");
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		println("Welcome to this little adventure\n"
				+ "Press [1] and [enter] to begin\n");
	}
	
	public GridPane createContent() throws InterruptedException {
		GridPane grid = new GridPane();
		grid.setPrefSize(800, 600);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		
		ta = new TextArea();
		ta.setMinSize(400, 300);
		ta.setPrefRowCount(15);
		ta.setEditable(false);
		ta.setFocusTraversable(false);
		grid.add(ta, 0, 0);
		
		tf = new TextField();
		tf.setPromptText("type command here");
		grid.add(tf, 0, 1);
		tf.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent keyEvent) {
				handleEvent(keyEvent);
			}
		});
		
		ts.initChoices();
		
		return grid;
	}
	
	public void handleEvent(KeyEvent e) {
		
		if (e.getEventType() == KeyEvent.KEY_PRESSED && e.getCode() == KeyCode.ENTER) {
			ts.read(tf.getText());
			tf.clear();
		}
	}
	
	public static void println(String line) {
		ta.appendText(line + "\n");
	}

}
