package edu.swarthmore.cs.cmarsh1.maproute.view;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MapRouteApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //create toolbar buttons
        HBox hBox = new HBox(10);
        Button reset = new Button("Reset");
        Button mapRoute = new Button("Map Route");
        Button createLooop = new Button("Create Loop");
        TextField textField = new TextField();
        hBox.getChildren().addAll(mapRoute, reset, createLooop, textField);

        //create the map display
        final WebView webView = new WebView();

        final WebEngine webEngine = webView.getEngine();
        webEngine.load(this.getClass().getResource("/edu/swarthmore/cs/cmarsh1/maproute/view/map.html").toString());

        Text text  = new Text("Your route is soooo long!");

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox);
        borderPane.setCenter(webView);
        borderPane.setBottom(text);

        Scene scene  = new Scene(borderPane, 1000, 750, Color.web("#666970"));
        stage.setScene(scene);

        stage.sizeToScene();
        stage.show();

    }
}
