import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;

public class Tester {
	
	public static void main(String[] args){
		Dungeon dun = new Dungeon();
		System.out.println(dun.getRoomName());
		System.out.println(dun.getCurrentRoom().getAvalibleDoors());
		dun.changeRoom("C2");
		System.out.println(dun.getRoomName());
		System.out.println(dun.getCurrentRoom().getAvalibleDoors());
	

	}
}
