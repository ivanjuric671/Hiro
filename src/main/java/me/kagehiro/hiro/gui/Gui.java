package me.kagehiro.hiro.gui;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import me.kagehiro.hiro.core.Core;
import me.kagehiro.hiro.key.Key;

public class Gui extends Application {

    private Text title;
    private Text keyBind;
    private Text minCps;
    private Text maxCps;
    private Text destroy;
    private TextField keyBindFld;
    private Slider minCpsSld;
    private Slider maxCpsSld;
    private Button destroyBtn;
    private HBox topArea;
    private HBox bottomArea;
    private VBox leftArea;
    private VBox rightArea;
    private VBox centerArea;
    private BorderPane root;
    private Scene scene;
    private final BooleanProperty firstTime = new SimpleBooleanProperty(true);
    private final int maxLength = 1;

    @Override
    public void start(Stage primaryStage) {

        title = new Text("Project Hiro");
        title.setFont(Font.font("Verdana", 28));

        keyBind = new Text("Keybind: ");
        keyBind.setFont(Font.font("Verdana", 18));

        minCps = new Text("Minimal CPS: ");
        minCps.setFont(Font.font("Verdana", 18));

        maxCps = new Text("Maximal CPS: ");
        maxCps.setFont(Font.font("Verdana", 18));

        keyBindFld = new TextField();
        keyBindFld.setText("R");
        keyBindFld.setMaxSize(50, 30);
        keyBindFld.setAlignment(Pos.CENTER);
        keyBindFld.setStyle("-fx-background-color: #505050;");
        keyBindFld.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue && firstTime.get()) {
                centerArea.requestFocus();
                firstTime.setValue(false);
            }
        });
        keyBindFld.lengthProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intValue() > oldValue.intValue()) {

                if(keyBindFld.getText().length() >= maxLength) {
                    keyBindFld.setText(keyBindFld.getText().substring(0, maxLength));
                }
            }
        });
        keyBindFld.setTextFormatter(new TextFormatter<String>((TextFormatter.Change change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));
        keyBindFld.setOnKeyPressed(event -> {
            String stringKey = event.getText();
            keyBindFld.setText(stringKey);
            Core.getCoreInstance().setKeyBind(new Key().toKeyCode(stringKey));
        });

        minCpsSld = new Slider(0, 20, Core.getCoreInstance().getMinCps());
        minCpsSld.setMaxSize(400, 40);
        minCpsSld.setBlockIncrement(1);
        minCpsSld.setMajorTickUnit(5);
        minCpsSld.setMinorTickCount(4);
        minCpsSld.setSnapToTicks(true);
        minCpsSld.setShowTickMarks(true);
        minCpsSld.setShowTickLabels(true);
        minCpsSld.valueProperty().addListener(((observable, oldValue, newValue) -> minCpsSld.setValue(newValue.intValue())));
        minCpsSld.valueProperty().addListener((observable, oldValue, newValue) -> Core.getCoreInstance().setMinCps(newValue.intValue()));
        minCpsSld.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intValue() >= maxCpsSld.getValue()) {
                maxCpsSld.setValue(newValue.intValue());
            }
        });

        maxCpsSld = new Slider(0, 20, Core.getCoreInstance().getMaxCps());
        maxCpsSld.setMaxSize(400, 40);
        maxCpsSld.setBlockIncrement(1);
        maxCpsSld.setMajorTickUnit(5);
        maxCpsSld.setMinorTickCount(4);
        maxCpsSld.setSnapToTicks(true);
        maxCpsSld.setShowTickMarks(true);
        maxCpsSld.setShowTickLabels(true);
        maxCpsSld.valueProperty().addListener((observable, oldValue, newValue) -> maxCpsSld.setValue(newValue.intValue()));
        maxCpsSld.valueProperty().addListener((observable, oldValue, newValue) -> Core.getCoreInstance().setMaxCps(newValue.intValue()));
        maxCpsSld.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intValue() <= minCpsSld.getValue()) {
                minCpsSld.setValue(newValue.intValue());
            }
        });

        topArea = new HBox();
        topArea.setPrefSize(800, 100);
        topArea.setPadding(new Insets(10, 10, 0, 10));
        topArea.getChildren().add(title);
        topArea.setAlignment(Pos.TOP_CENTER);
        topArea.setStyle("-fx-background-color: #303030;");

        bottomArea = new HBox();
        bottomArea.setPrefSize(800, 100);
        bottomArea.setPadding(new Insets(0, 10, 10, 10));
        bottomArea.setStyle("-fx-background-color: #303030;");

        leftArea = new VBox();
        leftArea.setPrefSize(100, 200);
        leftArea.setPadding(new Insets(0, 0, 0, 10));
        leftArea.getChildren().addAll(keyBind, minCps, maxCps);
        VBox.setMargin(keyBind, new Insets(0, 0, 40, 0));
        VBox.setMargin(minCps, new Insets(0, 0, 40, 0));
        VBox.setMargin(maxCps, new Insets(0, 0, 40, 0));
        leftArea.setStyle("-fx-background-color: #303030;");

        rightArea = new VBox();
        rightArea.setPrefSize(100, 200);
        rightArea.setPadding(new Insets(0, 10, 0, 0));
        rightArea.setStyle("-fx-background-color: #303030;");

        centerArea = new VBox();
        centerArea.setPrefSize(600, 200);
        centerArea.getChildren().addAll(keyBindFld, minCpsSld, maxCpsSld);
        VBox.setMargin(keyBindFld, new Insets(0, 0, 40, 20));
        VBox.setMargin(minCpsSld, new Insets(0, 0, 25, 20));
        VBox.setMargin(maxCpsSld, new Insets(0, 0, 0, 20));
        centerArea.setStyle("-fx-background-color: #303030;");

        root = new BorderPane();
        root.setTop(topArea);
        root.setBottom(bottomArea);
        root.setLeft(leftArea);
        root.setRight(rightArea);
        root.setCenter(centerArea);

        scene = new Scene(root, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> System.exit(0));

        Core.getCoreInstance().startProgram();

    }

}
