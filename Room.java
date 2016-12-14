import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Room {
	/* attributes */
	private String roomName;
	private HashMap<String, Door> doorsHash;

	private ArrayList<Player> players;

	private Rectangle roomRec;

	final private Image chaserIMG = new Image("FXML/Skull.png");

	public Room() {
		roomName = null;
		roomRec = new Rectangle();
	}

	public Room(String roomName) {

		this.roomName = roomName;
		this.doorsHash = new HashMap<String, Door>();
		players = new ArrayList<Player>();
		roomRec = new Rectangle();

	}// indices indicate position of doors [bottom,left,right,top]

	public void setDoors(Door[] doors, int size) {
		for (Door d : doors) {
			String[] raw = d.getName().split(",");
			if (Integer.parseInt(raw[0]) < 0 || Integer.parseInt(raw[1]) < 0 || Integer.parseInt(raw[0]) > size - 1
					|| Integer.parseInt(raw[1]) > size - 1)
				d.setName(null);
		}
		doorsHash.put("BOTTOM", doors[0]);
		doorsHash.put("LEFT", doors[1]);
		doorsHash.put("RIGHT", doors[2]);
		doorsHash.put("TOP", doors[3]);
	}

	public Door getDoor(String loc) {
		return doorsHash.get(loc);
	}

	public String getAvalibleDoors() {
		String dr = "";
		for (Map.Entry<String, Door> entry : doorsHash.entrySet()) {
			if (entry.getValue().toString() != null) {
				String key = entry.getKey();
				String door = entry.getValue().toString();
				dr += key + ": " + door + "\n";
			}
		}
		return dr;
	}

	public String getName() {
		return roomName;
	}

	public Rectangle getRoomShape() {
		return roomRec;
	}

	public void setRoom() {
		if (players.size() == 0)
			roomRec.setFill(Color.WHITE);
		else {
			for (Player p : players) {
				if (p.getClass().getName().equals("Chaser")) {
					ImagePattern imageP = new ImagePattern(chaserIMG);
					roomRec.setFill(imageP);
				}
				if (p.getClass().getName().equals("Runner"))
					roomRec.setFill(Color.DEEPSKYBLUE);
			}
		}
	}

	public void setRoom(double width, double height) {
		roomRec.setWidth(width);
		roomRec.setHeight(height);
		setRoom();
	}

	public void addPlayer(Player p) {
		players.add(p);
		setRoom();
	}

	public void removePlayer(Player p) {
		players.remove(p);
		setRoom();
	}

	public void removePlayer() {
		players.remove(0);
		setRoom();
	}

	public Player getPlayer() {
		return players.get(0);
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public boolean isEmpty(){
		return players.isEmpty();
	}

}
