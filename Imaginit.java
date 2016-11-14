/*
 * Author: David Alexander
 * This program uses javafx to create a visual application that prompts the user
 * to enter a path, or browse computer, for an image which they can then apply 
 * various modifications to. Many of the classes/objects referenced in this program
 * were created by Barb Ericson of Ga Tech. Class pictureFun was also created by David
 * Alexander, and is used to perform image modifications such as mirroring and color
 * scales.
 */
import imaginitClasses.FileChooser;
import imaginitClasses.Picture;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Imaginit extends Application {
	
	String fileName;
	char colorScalech;
	char mirrorCh;
	TextField brField = new TextField();
	@SuppressWarnings("static-access")
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		GridPane topPane = new GridPane();
		topPane.setHgap(8);
		topPane.setVgap(10);
		topPane.getColumnConstraints().add(new ColumnConstraints(150)); 
		topPane.getColumnConstraints().add(new ColumnConstraints(200)); 
		VBox vbox = new VBox(2);
		VBox vboxL = new VBox(6);
		TextField browseField = new TextField();
		Label chFile = new Label("Choose File:");
		Button brComp = new Button("Browse Computer");
		Button bImage = new Button("Imaginit!");
		Label bottomTitle = new Label("Image Modifications: ");
		topPane.add(chFile,0,1);
		topPane.setHalignment(chFile, HPos.RIGHT);
		topPane.add(browseField,1,1);
		topPane.add(brComp, 3, 1);
		topPane.add(bottomTitle, 1, 3);
		topPane.setHalignment(bottomTitle, HPos.RIGHT);
		brComp.setOnAction(e -> {
		String tmp = getFileName();
		browseField.setText(tmp);
		fileName = browseField.getText();
		});

		vbox.getChildren().add(0, topPane);
		Label cscl = Label("Color Scales:");
		ToggleGroup cScGr = new ToggleGroup();
		RadioButton red = new RadioButton("Red");
		RadioButton grn = new RadioButton("Green");
		RadioButton blu = new RadioButton("Blue");
		RadioButton nne = new RadioButton("None");
		
		red.setOnAction(e -> {
			if(red.isSelected()){
				colorScalech = 'r'; 
			}
		});
		grn.setOnAction(e -> {
			if(grn.isSelected()){
				colorScalech = 'g'; 
			}
		});
		blu.setOnAction(e -> {
			if(blu.isSelected()){
				colorScalech = 'b'; 
			}
		});
		nne.setOnAction(e -> {
			if(red.isSelected()){
				colorScalech = 'N'; 
			}
		});
		
		red.setToggleGroup(cScGr);
		grn.setToggleGroup(cScGr);
		blu.setToggleGroup(cScGr);
		nne.setToggleGroup(cScGr);
		
		vboxL.setPadding(new Insets(5,5,5,5));
		vboxL.getChildren().addAll(new Label("Color Scales:"),red,grn,blu,nne);
		VBox vboxR = new VBox(4);
		
		ToggleGroup mirrorG = new ToggleGroup();
		RadioButton rbVertM = new RadioButton("Vertical");
		RadioButton rbHorizM = new RadioButton("Horizontal");
		RadioButton rbNneM = new RadioButton("None"); 
		
		rbVertM.setOnAction(e -> {
			mirrorCh = 'V';
		});
		rbHorizM.setOnAction(e -> {
			mirrorCh = 'H';
		});
		rbNneM.setOnAction(e -> {
			mirrorCh = 'N';
		});
		rbVertM.setToggleGroup(mirrorG);
		rbHorizM.setToggleGroup(mirrorG);
		rbNneM.setToggleGroup(mirrorG);
		vboxR.getChildren().addAll(new Label("Mirror Mods:"), rbVertM, rbHorizM,rbNneM);
		GridPane bottPane = new GridPane();
		bottPane.setHgap(8);
		bottPane.setVgap(10);
		bottPane.getColumnConstraints().add(new ColumnConstraints(400));
		bottPane.getColumnConstraints().add(new ColumnConstraints(400));
		bottPane.add(vboxL, 0, 0);
		bottPane.add(vboxR, 1, 0);
		bottPane.add(bImage, 1, 1);
		bottPane.setHalignment(vboxL, HPos.CENTER);
		bottPane.setHalignment(vboxR, HPos.LEFT);
		vbox.getChildren().add(1, bottPane);
		
		bImage.setOnAction(e -> {
			Picture mainPic = exec();
			mainPic.show();
		});
		Scene scene = new Scene(vbox,600,400);
		primaryStage.setTitle("Imaginit");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private Label Label(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFileName(){
		String nme = FileChooser.pickAFile();
		return nme;	
	}
	
	public  Picture exec()
	{

		pictureFun imag = new pictureFun(fileName);
		switch(colorScalech){
		case 'r':
			imag.keepRed();
			break;
		case 'g':	
			imag.keepGreen();
			break;
		case 'b':
			imag.keepBlue();
			break;
		case 'N':
			default:
				;
		}
		
		switch(mirrorCh){
		case 'V':
			imag.mirrorVert();
			break;
		case 'H':
			imag.mirrorHoriz();
			break;
		case 'N':
			default:
				;
		}
		return imag;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}


}
