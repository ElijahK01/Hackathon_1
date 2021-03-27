package GUI;

import java.util.ArrayList;

import items.MaterialProperties;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SetupWindow extends Application
{

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		
		ArrayList<MaterialProperties> mp = new ArrayList<>();
		ArrayList<String> materialNames = new ArrayList<>();
		
		// transfer material properties name to material names list
		
		// buttons and labels
		Button saveCustom = new Button("Save Custom");
		Button run = new Button("Run Simulation");
		
		RadioButton createCustom = new RadioButton("Create Custom Material");
		
		ChoiceDialog materialsList = new ChoiceDialog(materialNames.toArray()[0], materialNames.toArray()); 
		
		// forms to create new material
		
		TextField nameInput = new TextField();
		TextField densityInput = new TextField();
		TextField tStrengthInput = new TextField();
		TextField sStrengthInput = new TextField();
		TextField cStrengthInput = new TextField();
		
		// panels and containers and parents
		
		Pane customMaterialCreation = new Pane();
		
		// scene settings
		
		
		primaryStage.setResizable(false);
		
	}
	
}
