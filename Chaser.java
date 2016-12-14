import javafx.scene.image.Image;

public class Chaser extends Player {

	final private Image chaserIMG = new Image("FXML/Skull.png");
	
	public Chaser(String name) {
		super(name);
	}
	
	public Image getImage(){
		return chaserIMG;
	}

}
