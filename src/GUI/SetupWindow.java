package GUI;

import java.util.ArrayList;

import items.MaterialProperties;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import root.fileIO;

public class SetupWindow extends Application
{

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		
		ArrayList<MaterialProperties> mp = new ArrayList<>();
		
		// transfer material properties name to material names list
		
		mp = fileIO.getAll();
		String[] materialNames = new String[mp.size()];
		
		for(int i = 0; i < mp.size(); i ++) {
			materialNames[i] = mp.get(i).getName();
		}
		
		// buttons and labels
		Button saveCustom = new Button("Save Custom");
		Button run = new Button("Run Simulation");
		
		//RadioButton createCustom = new RadioButton("Create Custom Material");
		
		
		ChoiceDialog materialsList = new ChoiceDialog(materialNames[0], materialNames); 
		
		
		// =================== form to create new material ====================== //
		
		
		TextField nameInput = new TextField();
		TextField densityInput = new TextField();
		TextField tStrengthInput = new TextField();
		TextField sStrengthInput = new TextField();
		TextField cStrengthInput = new TextField();
		
		Text nameLabel = new Text("Name: ");
		Text densityLabel = new Text("Density: ");
		Text tStrengthLabel = new Text("Tension Strength: ");
		Text sStrengthLabel = new Text("Shear Strength: ");
		Text cStrengthLabel = new Text("Compression Strength: ");
		
		nameInput.setMinWidth(20);
		densityInput.setMinWidth(20);
		tStrengthInput.setMinWidth(20);
		sStrengthInput.setMinWidth(20);
		cStrengthInput.setMinWidth(20);
		
		// panels and containers and parents
		HBox name = new HBox();
		HBox density = new HBox();
		HBox tStrength = new HBox();
		HBox sStrength = new HBox();
		HBox cStrength = new HBox();
		
		name.getChildren().addAll(nameLabel, nameInput);
		density.getChildren().addAll(densityLabel, densityInput);
		tStrength.getChildren().addAll(tStrengthLabel, tStrengthInput);
		sStrength.getChildren().addAll(sStrengthLabel, sStrengthInput);
		cStrength.getChildren().addAll(cStrengthLabel, cStrengthInput);
		
		StackPane containerPane = new StackPane();
		//containerPane.getChildren().add(createCustom);
		
		FlowPane customMaterialCreation = new FlowPane(javafx.geometry.Orientation.VERTICAL);
		customMaterialCreation.getChildren().add(name);
		customMaterialCreation.getChildren().add(density);
		customMaterialCreation.getChildren().add(tStrength);
		customMaterialCreation.getChildren().add(sStrength);
		customMaterialCreation.getChildren().add(cStrength);
		customMaterialCreation.getChildren().add(saveCustom);
		
		
		
		// ============================== End of Form ======================= //
		
		
		// ============================== Preset selection ======================== //
		
		
		
		
		// ========================== End of Preset Selection ===================== //
		
		
		// ========================== Run options ========================== //
		
		
		
		// ========================== End of Run Options =================== //
		
		
		// scene settings
//		Pane radioPane = new Pane();
//		HBox customButtonContainer = new HBox();
//		customButtonContainer.getChildren().addAll(createCustom);
//		radioPane.getChildren().add(customButtonContainer);
//		customButtonContainer.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
//		radioPane.setVisible(true);
		
		containerPane.getChildren().add(customMaterialCreation);
		//containerPane.getChildren().add(radioPane);
		
		customMaterialCreation.setVisible(true);
		
		containerPane.setVisible(true);
		
		Scene scene = new Scene(containerPane, 500, 500);
		
		primaryStage.setResizable(false);
		primaryStage.setTitle("Setup");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//if(event.getSource() == createCustom) {
				//	updateFormVisibility();
				//}
				if(event.getSource() == saveCustom) {
					
					// reference save method
					
				}
				
			}

			private void updateFormVisibility() {
				customMaterialCreation.setVisible(true);
				
			}

			
		};
		
		saveCustom.setOnMouseClicked(handler);
		
		
	}
}
