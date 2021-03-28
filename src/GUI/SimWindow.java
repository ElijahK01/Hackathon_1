package GUI;

import items.Circle;
import items.MaterialProperties;
import items.N_Gon;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import root.calc;

public class SimWindow{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SimWindow(Stage sim, MaterialProperties m) {
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
		bar.getRowConstraints().add(new RowConstraints(30));
		
		// Buttons 
		Button changeMaterial = new Button("Change Material");
		Button apply = new Button("Apply Changes");
		changeMaterial.setDisable(true); // not set up
		
		RadioButton verticalForce = new RadioButton("Shear");
		RadioButton pullForce = new RadioButton("Pull");
		
		// text fields
		TextField forceInput = new TextField();
		TextField lengthInput = new TextField();
		TextField forceXCoordinateInput = new TextField();
		TextField apothemInput = new TextField();
		
		forceInput.setMinWidth(50);
		lengthInput.setMinWidth(50);
		forceXCoordinateInput.setMinWidth(50);
		apothemInput.setMinWidth(50);
		
		Text forceLabel = new  Text("Force (N):   ");
		Text lengthLabel = new Text("Length (m):  ");
		Text fxcLabel = new    Text("Force offset (m):");
		Text apothemLabel = new Text("Width: (m)  ");
		
		HBox force = new HBox();
		HBox length = new HBox();
		HBox forceXCoordinate = new HBox();
		HBox apothem = new HBox();
		
		force.getChildren().addAll(forceLabel, forceInput);
		length.getChildren().addAll(lengthLabel, lengthInput);
		forceXCoordinate.getChildren().addAll(fxcLabel, forceXCoordinateInput);
		apothem.getChildren().addAll(apothemLabel, apothemInput);
		
		VBox heightWidth = new VBox();
		heightWidth.getChildren().addAll(length, apothem);
		
		changeMaterial.setMinSize(120, 20);
		apply.setMinSize(120, 20);
		
		// checkbox
		
		CheckBox endForce = new CheckBox(" <- Apply F to end");
		FlowPane forceOptions = new FlowPane(javafx.geometry.Orientation.VERTICAL);
		forceOptions.getChildren().add(endForce);
		forceOptions.getChildren().add(verticalForce);
		forceOptions.getChildren().add(pullForce);
		
		// choose shape
		String[] shapes = {"Square", "Circular", "Polygon"};
		ChoiceBox shape = new ChoiceBox();
		shape.effectiveNodeOrientationProperty();
		shape.getItems().addAll(shapes);
		
		Text shapeLabel = new Text("Shape of bar: ");
		HBox shapeBox = new HBox();
		shapeBox.getChildren().addAll(shapeLabel, shape);
		
		// n-gon sides 
		HBox nGonSides = new HBox();
		Text nGonSidesLabel = new Text("Sides (if polygon):");
		TextField nGonSidesInput = new TextField();
		nGonSidesInput.setPrefWidth(50);
		nGonSides.getChildren().addAll(nGonSidesLabel, nGonSidesInput);
		
		// rope strands
		//HBox ropeStrands = new HBox();
		//Text ropeStrandsLabel = new Text("Strands (if rope):  ");
		//TextField ropeStrandsInput = new TextField();
		//ropeStrandsInput.setPrefWidth(50);
		//ropeStrands.getChildren().addAll(ropeStrandsLabel, ropeStrandsInput);
		
		// combine into one box
		FlowPane sidesStrands = new FlowPane(javafx.geometry.Orientation.VERTICAL);
		sidesStrands.getChildren().addAll(nGonSides/*, ropeStrands*/);

		// assign item placement
		bar.add(changeMaterial, 3, 1);
		bar.add(apply, 3, 0);
		bar.add(force, 0, 0);
		bar.add(heightWidth, 0, 1);
		bar.add(forceXCoordinate, 1, 0);
		bar.add(forceOptions, 1, 1);
		bar.add(shapeBox, 2, 0);
		bar.add(sidesStrands, 2, 1);
		
		// location assignments
		
		bar.setAlignment(javafx.geometry.Pos.BASELINE_CENTER);
		
		// final child assignments
		
		FlowPane master = new FlowPane(javafx.geometry.Orientation.VERTICAL);
		master.getChildren().add(c);
		master.getChildren().add(bar);
		
		Scene s = new Scene(master, 700, 500);
		
		sim.setResizable(false);
		sim.setScene(s);
		sim.show();
		
		EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(event.getSource() == apply) {

					System.out.println("Running maths...");
					double forceApplied = Double.parseDouble(forceInput.getText());
					double objectLength = Double.parseDouble(lengthInput.getText());
					double forceLocation = Double.parseDouble(forceXCoordinateInput.getText());
					double apothemMeasurement = Double.parseDouble(apothemInput.getText());
					boolean shear = verticalForce.isSelected();
					int sideCount = 3;
					
					double area = 0;
					
					//System.out.println(shape.getValue());
					
					if(shape.getValue() == null || shape.getValue() == "Polygon") {
						sideCount = (int)Double.parseDouble(nGonSidesInput.getText());
						sideCount = (sideCount > 2 ? sideCount : 3);
						N_Gon n = new N_Gon(apothemMeasurement, objectLength, sideCount, m);
						area = n.getArea();
					}
					else if(shape.getValue() == "Square") {
						sideCount = 4;
						N_Gon n = new N_Gon(apothemMeasurement, objectLength, sideCount, m);
						area = n.getArea();
					}
					else {
						Circle c = new Circle(apothemMeasurement, objectLength, m);
						area = c.getArea();
					}
					
					gc.setFill(Color.BLUE);
					gc.fillRect(0, 0, 700, 400);

					boolean forceBoxChecked = endForce.isSelected();

					if(forceBoxChecked) {
						forceLocation = objectLength;
					}
					
					double percentForce = 0.00;
					
					percentForce = calc.simulateStress(m, forceApplied, objectLength, forceLocation, apothemMeasurement, sideCount, shear, area);
					
					percentForce = (percentForce > 100? 100 : percentForce);
					
					Color stress = new Color(percentForce / 100 , 0.5, 0, 1);
					
					if (percentForce > 99.999999) {
						stress = new Color(0,0,0,1);
					}
					
					gc.setFill(stress);
					gc.fillRect(100, 100, objectLength * 100, apothemMeasurement * 100);
					
					// draw arrow
					double position = forceLocation + 45;
					
					if (shear) {
						gc.setFill(Color.RED);
						drawArrow(gc, position);
					}
					else {
						gc.setFill(Color.RED);
						drawSideArrow(gc, objectLength);
					}
					
					
	
				}
				
				if(event.getSource() == changeMaterial) {
					System.out.println("YoU dOnT lIkE tHiS mAtEriAL");
					//new Main();
				}

			}

			private void drawSideArrow(GraphicsContext gc, double objectLength) {
				gc.setFill(Color.RED);
				gc.fillRect(objectLength + 75, 50, 50, 10);
				@SuppressWarnings("unused")
				double location = objectLength + 50;
				
				gc.fillPolygon((new double[] {objectLength + 75, objectLength + 75.0, objectLength + 50}),( new double[] {75, 75, 100}), 3);
			}

			private void drawArrow(GraphicsContext gc, double position) {
				gc.setFill(Color.RED);
				gc.fillRect((position * 100) + 50, 25, 10, 50);
				@SuppressWarnings("unused")
				double location = (position * 100) + 50;
				
				gc.fillPolygon((new double[] {position - 10.0, position + 20.0, position + 5.0}),( new double[] {75, 75, 100}), 3);
				
			}
		};
		
		apply.setOnMouseClicked(handler);
		changeMaterial.setOnMouseClicked(handler);
	}
	
	
	public double getForce() {
		return 1.00; // returns value for user input
	}
}
