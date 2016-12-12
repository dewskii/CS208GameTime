import java.io.File;
import java.util.ArrayList;
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
	ArrayList<Player> players;
	Player currentPlayer;
	
	public Dungeon(){
		roomHash = new HashMap<String,Room>();
		initialize();	
		currentRoom = roomHash.get("0,0");
	}
	
	public void changeRoom(Door door){
		currentRoom = roomHash.get(door.getName());
		currentPlayer.changeRoom(currentRoom.getName());
		
	}
	
	public Player getCurrentPlayer(){
		return currentPlayer;
	}
	
	public Room getCurrentRoom(){
		return currentRoom;
	}
	
	public String getRoomName(){
		return currentRoom.getName();
	}
	
	//initializes rooms from text file, doors point to available rooms
	
	public void initialize(){
		System.out.println("INITIALIZE");
		Room tempRoom;
		Door[] door = new Door[4];
		int row = 4;
		int col = 4;
		for(int i = 0; i<row; i++){
			for(int j = 0; j<col; j++){
				int r = i;
				int c = j;
				tempRoom = new Room(i+","+j);
				door[0] = new Door((r+1)+","+(c));
				door[1] = new Door((r)+","+(c-1));
				door[2] = new Door((r)+","+(c+1));
				door[3] = new Door((r-1)+","+(c));
				tempRoom.setDoors(door);
				roomHash.put(tempRoom.getName(), tempRoom);
			}						
	   }
  }
				
		
	
	
	public GridPane getGrid(){
		return grid;
	}
	
	
	
	

}
