import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
//creates dungeon of rooms on a A-F,1-6 Grid
//Still need to determine how to "load" in preset map
public class Dungeon {
	Room currentRoom;
	HashMap<String,Room> roomHash;
	GridPane grid;
	Player player;
	
	public Dungeon(){
		roomHash = new HashMap<String,Room>();
		initialize();
		currentRoom = roomHash.get("START");
		player = new Player("Player1",currentRoom.getName());
		
	}
	
	public void changeRoom(Door door){
		currentRoom = roomHash.get(door.name());
		player.changeRoom(currentRoom.getName());
		
	}
	
	public Room getCurrentRoom(){
		return currentRoom;
	}
	
	public String getRoomName(){
		return currentRoom.getName();
	}
	
	//initializes rooms from text file, doors point to available rooms
	
	public void initialize(){
		Room tempRoom;
		Door[] door = new Door[4];
		int row = 4;
		int col = 4;
		for(int i = 0; i<row; i++){
			for(int j = 0; j<col; j++){
				tempRoom = new Room(i+","+j);
				roomHash.put(tempRoom.getName(), tempRoom);
				for(int k = 0; k<door.length; k++){
					if( i-1 > 0 
				}
				
			}
			
		}
		
		
		
	}
	
	public GridPane getGrid(){
		return grid;
	}
	
	
	
	

}
