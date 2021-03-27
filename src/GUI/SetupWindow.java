package GUI;

import java.util.ArrayList;

import items.MaterialProperties;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
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
		
		//ChoiceDialog materialsList = new ChoiceDialog(materialNames.toArray()[0], materialNames.toArray()); 
		
		// forms to create new material
		
		TextField nameInput = new TextField();
		TextField densityInput = new TextField();
		TextField tStrengthInput = new TextField();
		TextField sStrengthInput = new TextField();
		TextField cStrengthInput = new TextField();
		
		nameInput.setMinWidth(20);
		densityInput.setMinWidth(20);
		tStrengthInput.setMinWidth(20);
		sStrengthInput.setMinWidth(20);
		cStrengthInput.setMinWidth(20);
		// panels and containers and parents
		
		StackPane containerPane = new StackPane();
		
		FlowPane customMaterialCreation = new FlowPane(javafx.geometry.Orientation.VERTICAL);
		customMaterialCreation.getChildren().add(nameInput);
		customMaterialCreation.getChildren().add(densityInput);
		customMaterialCreation.getChildren().add(tStrengthInput);
		customMaterialCreation.getChildren().add(sStrengthInput);
		customMaterialCreation.getChildren().add(cStrengthInput);
		customMaterialCreation.getChildren().add(saveCustom);
		
		
		
		
		
		// scene settings
		containerPane.getChildren().add(customMaterialCreation);
		Scene scene = new Scene(containerPane, 500, 500);
		
		primaryStage.setResizable(false);
		primaryStage.setTitle("Setup");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
}
