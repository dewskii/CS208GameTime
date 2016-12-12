
/*
public class Tester {
	public static void main(String[] args){
		Chaser player = new Chaser("Player","0,0");
		System.out.println(player.getClass().getName());
		
}
}
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tester extends Application {
	@Override
    public void start(Stage stage) throws Exception {
         Parent root = FXMLLoader.load(getClass().getResource("FXML/DungeonGame.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
	}
	  public static void main(String[] args) {
	        launch(args);
	    }


}
