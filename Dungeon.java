import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

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
 Player player1;
 Player player2;
 Player player3;
 Player currPlayer;
 
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
  roomHash.get("0,"+(rowNum-1)).addPlayer(new Player("player1", "0,"+(rowNum-1)));
  roomHash.get((colNum-1)+",0").addPlayer(new Player("player2",(colNum-1)+",0"));
  roomHash.get("0,0").addPlayer(new Player("chaser","0,0"));
  
 }
 
 public void changeRoom(String key){
  String newRoom;
  if (currentRoom.getDoorMap().containsKey(key)){
    newRoom = currentRoom.getDoor(key).name();
    if (currentRoom.hasPlayer()){
      roomHash.get(newRoom).addPlayer(currentRoom.getPlayer());
      currentRoom.removePlayer();}
    currentRoom = roomHash.get(newRoom);
  }
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
 
 //public GridPane getGrid(){
  //return grid;
 //}
 
 public String toString(){
   String str = "";
   for(Map.Entry<String, Room> entry : roomHash.entrySet()){
     str+="["+entry.toString()+"]\n";}
   return str;
 }
   
 
 

}
