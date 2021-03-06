
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javafx.scene.layout.GridPane;

//creates dungeon of rooms on an NxN grid, can scale indefinately
//Still need to determine how to "load" in preset map
public class Dungeon {
	final double HEIGHT = 350;
	final double WIDTH = 350;
	Room currentRoom;
	HashMap<String, Room> roomHash;
	GridPane grid;
	ArrayList<Player> players;
	Stack<Runner> runnersEscaped;
	Player currentPlayer;
	Chaser player1;
	Runner player2;
	Runner player3;
	boolean hasWon;
	boolean escapeFlag;
	int turnFlag;
	

	public Dungeon() {
		roomHash = new HashMap<String, Room>();
		grid = new GridPane();
		players = new ArrayList<Player>();
		runnersEscaped = new Stack<Runner>();
		player1 = new Chaser("Player1");
		players.add(player1);
		player2 = new Runner("Player2",1);
		players.add(player2);
		player3 = new Runner("Player3",2);
		players.add(player3);
        hasWon = false;
		turnFlag = 0;

	}

	public void changeRoom(Door door) {
		if(roomHash.get(door.getName()).isEmpty()){
		  if(roomHash.get(door.getName()).isExit() && currentPlayer.getClass().getName().equals("Runner")){
				currentRoom.removePlayer(currentPlayer);
				roomHash.get("Exit").addPlayer(currentPlayer);
				currentPlayer.setRoom(roomHash.get("Exit").getName());
				runnersEscaped.push((Runner)currentPlayer);
				escapeFlag = true;
				players.remove(currentPlayer);
				changeTurn();
			}
		  else{
	    escapeFlag = false;
		currentRoom.removePlayer(currentPlayer);
		currentRoom = roomHash.get(door.getName());
		currentRoom.addPlayer(currentPlayer);
		currentPlayer.setRoom(currentRoom.getName());
		changeTurn();
			}
		}
		else{
			escapeFlag = false;
			ArrayList<Player> temp = roomHash.get(door.getName()).getPlayers();
			for(Player p : temp){
				if(currentPlayer.getClass().getName().equals("Chaser") && p.getClass().getName().equals("Runner")){
					currentRoom.removePlayer(currentPlayer);
					currentRoom = roomHash.get(door.getName());
					currentRoom.removePlayer(p);
					currentRoom.addPlayer(currentPlayer);
					players.remove(p);
					
				}
			}
		}
		checkWin();

	}

	public void changeTurn() {
		turnFlag++;
		if (turnFlag > players.size() - 1) {
			turnFlag = 0;
		}

		currentPlayer = players.get(turnFlag);
		currentRoom = roomHash.get(currentPlayer.getCurrentRoom());
	}

	public Room getRoom(String roomName) {
		return roomHash.get(roomName);
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public String getRoomName() {
		return currentRoom.getName();
	}
	
	public Runner checkEscape(){
		if(escapeFlag){
			return runnersEscaped.peek();
		}
		else return null;
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public Stack<Runner> getEscapees(){
		return runnersEscaped;
	}
	
	public boolean checkWin(){
		if (players.size() == 1){
			return hasWon = true;
		}
		return hasWon = false;
	}

	// initializes rooms from text file, doors point to available rooms

	public void initialize(int row, int col) {
		System.out.println("INITIALIZE");
		Room tempRoom;
		Door[] door = new Door[4];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int r = i;
				int c = j;
				tempRoom = new Room(i + "," + j);
				door[0] = new Door((r + 1) + "," + (c));
				door[1] = new Door((r) + "," + (c - 1));
				door[2] = new Door((r) + "," + (c + 1));
				door[3] = new Door((r - 1) + "," + (c));
				tempRoom.setDoors(door, row);
				roomHash.put(tempRoom.getName(), tempRoom);
				tempRoom.setRoom((WIDTH / row) - 1, (HEIGHT / col) - 1);
				grid.add(tempRoom.getRoomShape(), c, r);
			}
		}
		roomHash.get((row-1)+","+(col-1)).setExit();
		roomHash.get((row-1)+","+(col-1)).setRoom();
		roomHash.put("Exit", new Room("Exit"));
		
		currentRoom = roomHash.get((int) Math.floor(Math.random() * row) + "," + (int) Math.floor(Math.random() * col));
		currentPlayer = player1;
		currentRoom.addPlayer(player1);
		player1.setRoom(currentRoom.getName());
		roomHash.get("0,1").addPlayer(player2);
		player2.setRoom("0,1");
		roomHash.get("1,0").addPlayer(player3);
		player3.setRoom("1,0");
	}

	public GridPane getGrid() {
		grid.setStyle("-fx-background-color: grey; -fx-padding: 1; -fx-hgap: 1; -fx-vgap: 1;");
		return grid;
	}

}
