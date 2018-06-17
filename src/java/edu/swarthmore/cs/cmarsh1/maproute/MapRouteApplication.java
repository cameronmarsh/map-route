package edu.swarthmore.cs.cmarsh1.maproute;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MapRouteApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        //create the map display
        final WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();
        webEngine.load(this.getClass().getResource("/edu/swarthmore/cs/cmarsh1/maproute/map.html").toString());

        //create toolbar buttons
        ToolBar toolBar = new ToolBar();
        Button reset = new Button("Reset");
        Button createLoop = new Button("Create Loop");
        Button undo = new Button("Undo");

        Pane leftspacer = new Pane();
        HBox.setHgrow(leftspacer, Priority.SOMETIMES);
        Pane rightspacer = new Pane();
        HBox.setHgrow(rightspacer, Priority.SOMETIMES);

        toolBar.getItems().addAll(leftspacer, createLoop, undo, reset, rightspacer);
        toolBar.getStyleClass().add("toolbar");

        //add listeners to the buttons
        createLoop.setOnAction(click -> webEngine.executeScript("loopRoute()"));
        reset.setOnAction(click -> webEngine.executeScript("clearAllPoints()"));
        undo.setOnAction(click -> webEngine.executeScript("undoClick()"));

        //construct the scene
        BorderPane borderPane = new BorderPane();
        borderPane.getStyleClass().add("map");
        borderPane.setTop(toolBar);
        borderPane.setCenter(webView);

        Scene scene  = new Scene(borderPane, 1000, 750, Color.web("#666970"));
        scene.getStylesheets().add("/edu/swarthmore/cs/cmarsh1/maproute/fxstylesheet.css");
        stage.setScene(scene);

        stage.sizeToScene();
        stage.show();

    }
}
