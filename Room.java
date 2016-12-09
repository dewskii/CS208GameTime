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
  private HashMap<String,Door> doorsHash;
  private Parent parent;
  private ArrayList<Player> players;
  //private final Image BACKGROUNDIMAGE;
  private boolean isStart;
  Button left;
  Button right;
  Label roomLabel;
 
  public Room(){
    roomName = null;
    parent = null;
    players = new ArrayList<Player>();
    //BACKGROUNDIMAGE = null;
    isStart = false;
  }
 
  public Room(boolean isStart, String roomName/*, Image st*/){
    this.isStart = isStart;
    this.roomName = roomName;
    this.doorsHash = new HashMap<String,Door>();
    players = new ArrayList<Player>();
    //BACKGROUNDIMAGE = st;
  }//indices indicate position of doors [bottom,left,right,top]
 
  public void setDoors(Door[] doors){
    doorsHash.put("BOTTOM", doors[0]);
    doorsHash.put("LEFT", doors[1]);
    doorsHash.put("RIGHT", doors[2]);
    doorsHash.put("TOP", doors[3]);
  }
 
  public Door getDoor(String loc){
    return doorsHash.get(loc);
  }
 
  public String getAvalibleDoors(){
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
 
  public boolean isStart(){
    return isStart;
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