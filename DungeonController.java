import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class DungeonController implements Initializable {
	@FXML private Pane mainPane;
	@FXML private Pane dungeonArea;
	@FXML private Button top;
	@FXML private Button down;
	@FXML private Button left;
	@FXML private Button right;
	@FXML private TextArea textArea;
	@FXML private Button check;
	@FXML private Button skip;
	@FXML private TextField turnArea;
	
	@Override 
	public void initialize(URL url, ResourceBundle rb){
		Dungeon dungeon = new Dungeon();
		dungeon.initialize(9,9);
		dungeonArea.getChildren().add(dungeon.getGrid());
	    turnArea.appendText("Turn: "+dungeon.getCurrentPlayer().getName());
		top.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				Room temp = dungeon.getCurrentRoom();
				if(temp.getDoor("TOP").getName() != null){
					dungeon.changeRoom(temp.getDoor("TOP"));
				    textArea.clear();
				    turnArea.clear();
				    textArea.appendText("Room change: "+dungeon.getRoomName());
				    dungeon.changeTurn();
				    turnArea.appendText("Turn: "+dungeon.getCurrentPlayer().getName());
				}
			    else {
			    	 textArea.clear();
					 textArea.appendText("No Accessible Door");
			    }
				    
			}
		});
		down.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				Room temp = dungeon.getCurrentRoom();
				if(temp.getDoor("BOTTOM").getName() != null){
					dungeon.changeRoom(temp.getDoor("BOTTOM"));
					 textArea.clear();
					    turnArea.clear();
					    textArea.appendText("Room change: "+dungeon.getRoomName());
					    dungeon.changeTurn();
					    turnArea.appendText("Turn: "+dungeon.getCurrentPlayer().getName());
				}
				else {
			    	 textArea.clear();
					 textArea.appendText("No Accessible Door");
			    }
				
			}
		});
		
		left.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				Room temp = dungeon.getCurrentRoom();
				if(temp.getDoor("LEFT").getName() != null){
					dungeon.changeRoom(temp.getDoor("LEFT"));
					 textArea.clear();
					    turnArea.clear();
					    textArea.appendText("Room change: "+dungeon.getRoomName());
					    dungeon.changeTurn();
					    turnArea.appendText("Turn: "+dungeon.getCurrentPlayer().getName());
				}
				else {
			    	 textArea.clear();
					 textArea.appendText("No Accessible Door");
			    }
			}
		});
		right.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				Room temp = dungeon.getCurrentRoom();
				if(temp.getDoor("RIGHT").getName() != null){
					dungeon.changeRoom(temp.getDoor("RIGHT"));
					 textArea.clear();
					    turnArea.clear();
					    textArea.appendText("Room change: "+dungeon.getRoomName());
					    dungeon.changeTurn();
					    turnArea.appendText("Turn: "+dungeon.getCurrentPlayer().getName());
				}
				else {
			    	 textArea.clear();
					 textArea.appendText("No Accessible Door");
			    }
			}
		});
		
		check.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				textArea.clear();
				Room temp = dungeon.getCurrentRoom();
				textArea.appendText("The Current Room is: "+temp.getName()+"\n");
				textArea.appendText("The avalible doors are: \n"+temp.getAvalibleDoors());
			}
				
	});
		
	}

}
