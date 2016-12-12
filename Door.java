import javafx.scene.image.Image;

//Door for storing next room info, roomID will be used as key in hashmap of rooms
public class Door {
	String roomID;
	boolean isLocked;
	Image imageUnlocked;
	Image imageLocked;
	Image imageBlocked;
	
	public Door(String roomID){
		this.roomID = roomID;
		
	}
	public String name() {
		return roomID;
	}
	
	@Override
	public String toString(){
		return roomID;
	}
}
