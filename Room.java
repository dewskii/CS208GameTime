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
    //setDoors();
   
  }//indices indicate position of doors [bottom,left,right,top]
 
 public void setDoors(int maxCol, int maxRow){
    Door[] doors = new Door[4];
    if ((row+1)<=maxRow){
      doors[0] = new Door(col+","+(row+1));
      doorsHash.put("BOTTOM", doors[0]);}
    if((col-1)>=0){
      doors[1] = new Door((col-1)+","+row);
      doorsHash.put("LEFT", doors[1]);}
    if((col+1)<=maxCol){
      doors[2] = new Door((col+1)+","+(row));
      doorsHash.put("RIGHT", doors[2]);}
    if((row-1)>=0){
      doors[3] = new Door(col+","+(row-1));
      doorsHash.put("TOP", doors[3]);}
  }
 
  public Door getDoor(String loc){
    return doorsHash.get(loc);
  }
 
  public HashMap<String, Door> getDoorMap(){return doorsHash;}
  
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
 
  public boolean hasPlayer(){
    return !players.isEmpty();}

  public void addPlayer(Player p){
    players.add(p);
  }
  
  public void removePlayer(){
    if (hasPlayer())
      players.remove(0);
  }
  
  public Player getPlayer(){
    if(hasPlayer())
      return players.get(0);
    else
      return null;
  }
  
  public String toString(){
    String str = "Room: "+roomName+" Player: ";
    if(getPlayer()==null)
      return str+"none";
    else
      return str+getPlayer().getName();
  }
  
}
