package edu.swarthmore.cs.cmarsh1.maproute.view;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.EventTarget;
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
import org.w3c.dom.Element;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import sun.plugin.javascript.JSObject;

public class MapRouteApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //create toolbar buttons
        HBox hBox = new HBox(10);
        Button reset = new Button("Reset");
        Button createLooop = new Button("Create Loop");
        TextField textField = new TextField();
        hBox.getChildren().addAll(reset, createLooop, textField);

        //create the map display
        final WebView webView = new WebView();

        final WebEngine webEngine = webView.getEngine();
        webEngine.load(this.getClass().getResource("/edu/swarthmore/cs/cmarsh1/maproute/view/map.html").toString());

//        Integer distance = 0;
//        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
//            @Override
//            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
//                if(newValue == Worker.State.SUCCEEDED){
//                    Element elt = webEngine.getDocument().getElementById("mapcanvas");
//                    ((org.w3c.dom.events.EventTarget) elt).addEventListener("click", new EventListener() {
//                        @Override
//                        public void handleEvent(Event evt) {
//                            System.out.println(webEngine.executeScript("getDistance()"));
//                        }
//                    }, false);
//                }
//            }
//        });

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox);
        borderPane.setCenter(webView);

        Scene scene  = new Scene(borderPane, 1000, 750, Color.web("#666970"));
        stage.setScene(scene);

        stage.sizeToScene();
        stage.show();

    }
}
