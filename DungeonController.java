import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class DungeonController implements Initializable {
	@FXML private Pane dungeonArea;
	@FXML private Button top;
	@FXML private Button down;
	@FXML private Button left;
	@FXML private Button right;
	@FXML private TextArea textArea;
	@FXML private Button check;
	private Dungeon dungeon;
	
	@Override 
	public void initialize(URL url, ResourceBundle rb){
		GridPane dunGrid = dungeon.getGrid();
		dungeonArea.getChildren().add(dunGrid);
		top.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				Room temp = dungeon.getCurrentRoom();
				if(temp.getDoor("TOP") != null)
					dungeon.changeRoom(temp.getDoor("TOP"));
			}
		});
		down.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				Room temp = dungeon.getCurrentRoom();
				if(temp.getDoor("BOTTOM") != null)
					dungeon.changeRoom(temp.getDoor("BOTTOM"));
			}
		});
		
		left.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				Room temp = dungeon.getCurrentRoom();
				if(temp.getDoor("LEFT") != null)
					dungeon.changeRoom(temp.getDoor("LEFT"));
			}
		});
		right.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				Room temp = dungeon.getCurrentRoom();
				if(temp.getDoor("RIGHT") != null)
					dungeon.changeRoom(temp.getDoor("RIGHT"));
			}
		});
		
	}

}
