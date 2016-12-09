// Tyler Pagliazzo, David Dew, Matthew Sedewitz
/* Class that defines a player object
 * name holds the name of the player
 * currentRoom holds the room that the player is in
 * alive holds if the player is still alive
 * */
public class Player {
 private String name;
 private String currentRoom;
 private boolean alive;
 
 public Player(String name, String currentRoom){
  this.name = name;
  this.currentRoom = currentRoom;
  alive = true;
 }
 
 /* returns the name of the Player
  * */
 public String getName(){
  return name;
 }
 
 public void setName(String newName){
   name = newName;
 }
 
 /* returns the current room as a string
  * */
 public String getCurrentRoom(){
  return currentRoom;
 }
 
 /* changes the string variable for current room 
  * a new room
  * */
 public void changeRoom(String room){
  this.currentRoom = room;
 }
 
 /* returns if the player is still alive
  * */
 public boolean isAlive(){
   if(alive){
     return true;
   }
   else{
     return false;
   }
 }
 
 /* sets the player's alive variable to either true or false (alive or dead)
  * */
 public void setLiving(boolean t){
    alive = t;
 }
 
 public String toString(){
   return "Name: " + name + "Current Room: " +  currentRoom + "Is Alive: " + alive;
 }
     
}
