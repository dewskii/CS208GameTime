
public class Player {
	private String name;
	private Room currentRoom;
	
	public Player(String name, Room currentRoom){
		this.name = name;
		this.currentRoom = currentRoom;
	}
	
	public String getName(){
		return name;
	}
	
	public Room getCurrentRoom(){
		return currentRoom;
	}
	
	public void changeRoom(Room room){
		this.currentRoom = room;
	}
	
	

}
