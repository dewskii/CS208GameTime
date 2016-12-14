import javafx.scene.image.Image;

public class Runner extends Player {
	final private Image runnerIMG1 = new Image("FXML/scared-face.png");
	final private Image runnerIMG2 = new Image("FXML/scared-face2.png");
	private Image theImage;
	public Runner(String name, int imageNum) {
		super(name);
		setImage(imageNum);
		
	}
	public Image getImage(){
		return theImage;
	}
	
	public void setImage(int imageNum){
		if(imageNum == 1)
			theImage = runnerIMG1;
		else 
			theImage = runnerIMG2;
	}

}
