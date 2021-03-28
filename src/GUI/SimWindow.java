package GUI;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SimWindow{

	public SimWindow(Stage sim) {
		System.out.println("Success");
		
		Canvas c = new Canvas(700, 400);
		
		GraphicsContext gc = c.getGraphicsContext2D();
		gc.setFill(Color.BLUE);
		gc.fillRect(0, 0, 700, 400);
	
		// gridpane setup
		GridPane bar = new GridPane();
		bar.setPrefSize(500, 100);
		bar.setHgap(10);
		bar.getColumnConstraints().add(new ColumnConstraints(150));
		bar.getColumnConstraints().add(new ColumnConstraints(150));
		bar.getColumnConstraints().add(new ColumnConstraints(150));
		bar.getColumnConstraints().add(new ColumnConstraints(150));
		bar.getRowConstraints().add(new RowConstraints(50));
		
		// Buttons 
		Button changeMaterial = new Button("Change Material");
		Button apply = new Button("Apply Changes");
		
		// text fields
		TextField forceInput = new TextField();
		TextField lengthInput = new TextField();
		TextField forceXCoordinateInput = new TextField();
		
		forceInput.setMinWidth(50);
		lengthInput.setMinWidth(50);
		forceXCoordinateInput.setMinWidth(50);
		
		Text forceLabel = new  Text("Force:       ");
		Text lengthLabel = new Text("Length:      ");
		Text fxcLabel = new    Text("Force offset:");
		
		HBox force = new HBox();
		HBox length = new HBox();
		HBox forceXCoordinate = new HBox();
		
		force.getChildren().addAll(forceLabel, forceInput);
		length.getChildren().addAll(lengthLabel, lengthInput);
		forceXCoordinate.getChildren().addAll(fxcLabel, forceXCoordinateInput);
		
		changeMaterial.setMinSize(120, 20);
		apply.setMinSize(120, 20);
		
		// checkbox
		
		CheckBox endForce = new CheckBox(" <- Apply F to end");
		
		
		// assign item placement
		bar.add(changeMaterial, 3, 1);
		bar.add(apply, 3, 0);
		bar.add(force, 0, 0);
		bar.add(length, 0, 1);
		bar.add(forceXCoordinate, 1, 0);
		bar.add(endForce, 1, 1);
		
		// location assignments
		
		bar.setAlignment(javafx.geometry.Pos.BASELINE_CENTER);
		
		// final child labor assignments
		
		FlowPane master = new FlowPane(javafx.geometry.Orientation.VERTICAL);
		master.getChildren().add(c);
		master.getChildren().add(bar);
		
		Scene s = new Scene(master, 700, 500);
		
		sim.setResizable(false);
		sim.setScene(s);
		sim.show();
		
	}
	
	
	public double getForce() {
		return 1.00; // returns value for user input
	}
}
