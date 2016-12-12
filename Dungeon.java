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
 int rowNum;
 int colNum;
 GridPane grid;
 Player player;
 
 public Dungeon(int rowNum, int colNum){
  roomHash = new HashMap<String,Room>();
  Room tempRoom;
  for(int i = 0; i<rowNum; i++){
   for(int j = 0; j<colNum; j++){
    tempRoom = new Room(i+","+j);
    tempRoom.setDoors(colNum, rowNum);
    roomHash.put((i+","+j),tempRoom);
   }
  }
  currentRoom = roomHash.get("1,1");
  //player = new Player("Player1", currentRoom.getName());
  
 }
 
 public void changeRoom(String key){
  String newRoom;
  if (currentRoom.getDoorMap().containsKey(key)){
    newRoom = currentRoom.getDoor(key).name();
    currentRoom = roomHash.get(newRoom);}
  //player.changeRoom(currentRoom.getName());
  
 }
 
 public HashMap<String, Room> getMap(){
   return roomHash;
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
  for(int i = 0; i<rowNum; i++){
   for(int j = 0; j<colNum; j++){
    tempRoom = new Room(i+","+j);
    roomHash.put((i+","+j), new Room(i+","+j));
   }
  }
 }
 
 public GridPane getGrid(){
  return grid;
 }
 
 
 
 

}
