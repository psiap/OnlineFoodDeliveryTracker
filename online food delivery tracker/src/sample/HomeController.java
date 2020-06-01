package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafx.scene.web.WebView;

public class HomeController  {


    private ObservableList<String> name = FXCollections.observableArrayList();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> listView1;

    @FXML
    private Label selectedLbl;

    @FXML
    private Button updateBatton;

    @FXML
    private WebView webGoogle;

    @FXML
    private Button exitButton;

    @FXML
    void initialize() {
        listView1.setItems(name);
        exitButton.setOnAction(event -> {
            openNewScene("/sample/sample.fxml");
        });
        updateBatton.setOnAction(event -> {
            WebEngine webEngine = webGoogle.getEngine();
            webEngine.load("https://www.google.ru/maps");
            name.add("ADMIN " + "ADMIN");
        });


    }

    public void openNewScene(String window){
        exitButton.getScene().getWindow().hide();
        //Отображение нужного окна
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();
    }
}
