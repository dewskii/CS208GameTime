import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Room {
  /*attributes*/
  private String roomName;
  private int col;
  private int row;
  private HashMap<String,Door> doorsHash;
 
  private ArrayList<Player> players;
  
  public Room(){
    roomName = null;

  }
 
  public Room(String roomName){
 
    this.roomName = roomName;
    String[] token = roomName.split(",");
    col = Integer.parseInt(token[0]);
    row = Integer.parseInt(token[1]);
    this.doorsHash = new HashMap<String,Door>();
    players = new ArrayList<Player>();
    setDoors();
   
  }//indices indicate position of doors [bottom,left,right,top]
 
 public void setDoors(){
    Door[] doors = new Door[4];
    doors[0] = new Door(col+","+(row+1));
    doorsHash.put("BOTTOM", doors[0]);
    doors[1] = new Door((col-1)+","+row);
    doorsHash.put("LEFT", doors[1]);
    doors[2] = new Door((col+1)+","+(row));
    doorsHash.put("RIGHT", doors[2]);
    doors[3] = new Door(col+","+(row-1));
    doorsHash.put("TOP", doors[3]);
  }
 
  public Door getDoor(String loc){
    return doorsHash.get(loc);
  }
 
  public String getAvailableDoors(){
    String dr = "";
    for(Map.Entry<String, Door> entry : doorsHash.entrySet()){
      String key = entry.getKey();
      String door = entry.getValue().toString();
      dr+=key+": "+door+"\n";
    }
    return dr;
  }

  public String getName(){
    return roomName;
  }
 
 

  public void addPlayer(Player p){
    players.add(p);
  }
  
  public void removePlayer(){
    players.remove(0);
  }
  
  public Player getPlayer(){
    return players.get(0);
  }
  
  
}
