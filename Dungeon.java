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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
//creates dungeon of rooms on a A-F,1-6 Grid
//Still need to determine how to "load" in preset map
public class Dungeon {
	Room currentRoom;
	HashMap<String,Room> roomHash;
	
	public Dungeon(){
		roomHash = new HashMap<String,Room>();
		initialize();
		currentRoom = roomHash.get("START");
		
	}
	
	public void changeRoom(String door){
		currentRoom = roomHash.get(door);
		
	}
	
	public Room getCurrentRoom(){
		return currentRoom;
	}
	
	public String getRoomName(){
		return currentRoom.getName();
	}
	
	//initializes rooms from text file, doors point to available rooms
	public void initialize(){
		try{
		Scanner sc = new Scanner(new File("src/mapData.txt"));
		while(sc.hasNextLine()){
			String[] st = sc.nextLine().split(" ");
			boolean bol = Boolean.parseBoolean((String)st[0]);
		    Room room = new Room(bol, st[1] /*new Image(new File(st[2]).toURI().toString())*/);
		    Door[] doors = new Door[4];
		    for(int i=0; i<doors.length; i++)
		    	doors[i] = new Door(st[i+3]);
		    room.setDoors(doors);
		    if(room.isStart())
		       roomHash.put("START", room);
		    roomHash.put(room.getName(), room);
		}
		sc.close();
		}
		catch (Exception ex) {
            ex.printStackTrace();
        }
		
	}
	
	

}
