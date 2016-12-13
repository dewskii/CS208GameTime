<<<<<<< Updated upstream
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
//creates dungeon of rooms on a A-F,1-6 Grid
//Still need to determine how to "load" in preset map
public class Dungeon {
 final double HEIGHT = 350;
 final double WIDTH = 350;
 Room currentRoom;
 HashMap<String,Room> roomHash;
 GridPane grid;
 ArrayList<Player> players;
 Player currentPlayer;
 Chaser player1;
 Runner player2;
 Runner player3;

 
 public Dungeon(){
  roomHash = new HashMap<String,Room>();
  grid = new GridPane();
  player1 = new Chaser("Player1");
  player2 = new Runner("Player2");
  player3 = new Runner("Player3");
 }
 
 public void changeRoom(Door door){
  currentRoom.removePlayer(currentPlayer);
  currentRoom = roomHash.get(door.getName());
  currentRoom.addPlayer(currentPlayer);
  
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
  int row = 9;
  int col = 9;
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
    tempRoom.setRoom(WIDTH/row, HEIGHT/col);
    grid.add(tempRoom.getRoomShape(), c, r);
   }      
    }
  currentRoom = roomHash.get((int)Math.floor(Math.random()*8)+","+(int)Math.floor(Math.random()*8));
  currentPlayer = player1;
  currentRoom.addPlayer(player1);
  
  }
    
  
 
 
 public GridPane getGrid(){
  return grid;
 }
 
 
 
 

}
=======

import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.layout.GridPane;
//creates dungeon of rooms on an NxN grid, can scale indefinately
//Still need to determine how to "load" in preset map
public class Dungeon {
	final double HEIGHT = 350;
	final double WIDTH = 350;
	Room currentRoom;
	HashMap<String,Room> roomHash;
	GridPane grid;
	ArrayList<Player> players;
	Player currentPlayer;
	Chaser player1;
	Runner player2;
	Runner player3;
	
	int turnFlag;

	public Dungeon(){
		roomHash = new HashMap<String,Room>();
		grid = new GridPane();
		players = new ArrayList<Player>();
		player1 = new Chaser("Player1"); players.add(player1);
		player2 = new Runner("Player2"); players.add(player2);
		player3 = new Runner("Player3"); players.add(player3);
		
		turnFlag=0;
		
	}
	
	public void changeRoom(Door door){
		currentRoom.removePlayer(currentPlayer);
		currentRoom = roomHash.get(door.getName());
		currentRoom.addPlayer(currentPlayer);
		currentPlayer.setRoom(currentRoom.getName());
		
	}
	
	public void changeTurn(){
		turnFlag++;
		if(turnFlag > players.size()-1){
		   turnFlag=0;
		}
		
		currentPlayer = players.get(turnFlag);
		currentRoom = roomHash.get(currentPlayer.getCurrentRoom());
	}
	
	public Room getRoom(String roomName){
		return roomHash.get(roomName);
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
	
	public void initialize(int row, int col){
		System.out.println("INITIALIZE");
		Room tempRoom;
		Door[] door = new Door[4];
		for(int i = 0; i<row; i++){
			for(int j = 0; j<col; j++){
				int r = i;
				int c = j;
				tempRoom = new Room(i+","+j);
				door[0] = new Door((r+1)+","+(c));
				door[1] = new Door((r)+","+(c-1));
				door[2] = new Door((r)+","+(c+1));
				door[3] = new Door((r-1)+","+(c));
				tempRoom.setDoors(door, row);
				roomHash.put(tempRoom.getName(), tempRoom);
				tempRoom.setRoom((WIDTH/row)-1, (HEIGHT/col)-1);
				grid.add(tempRoom.getRoomShape(), c, r);
			}						
	   }
		currentRoom = roomHash.get((int)Math.floor(Math.random()*row)+","+(int)Math.floor(Math.random()*col));
		currentPlayer = player1;
		currentRoom.addPlayer(player1);
		player1.setRoom(currentRoom.getName());
		roomHash.get("0,1").addPlayer(player2);
		player2.setRoom("0,1");
		roomHash.get("1,0").addPlayer(player3);
		player3.setRoom("1,0");
  }
	
	
				
	
	public GridPane getGrid(){
		grid.setStyle("-fx-background-color: grey; -fx-padding: 1; -fx-hgap: 1; -fx-vgap: 1;");
		return grid;
	}
	
	
	
	

}
>>>>>>> Stashed changes
