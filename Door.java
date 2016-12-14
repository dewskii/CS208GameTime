//Door for storing next room info, roomID will be used as key in hashmap of rooms
public class Door {
	String roomID;

	public Door(String roomID) {
		this.roomID = roomID;

	}

	public String setName(String name) {
		return roomID = name;
	}

	public String getName() {
		return roomID;
	}

	@Override
	public String toString() {
		return roomID;
	}
	@Override
	public int hashCode(){
		int hash = 0;
		hash = 227*hash+(roomID !=null ? roomID.hashCode() : 0);
		return hash;
	}
}
