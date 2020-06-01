package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SingUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField singUpName;

    @FXML
    private PasswordField login_field;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField singUpLastName;

    @FXML
    private PasswordField password_field;

    @FXML
    private PasswordField singUpCountru;

    @FXML
    private CheckBox singUpCheckBoxMale;

    @FXML
    private CheckBox singUpCheckBoxFamele;

    @FXML
    void initialize() {

        signUpButton.setOnAction(event -> {
            singUpNewUser();


            signUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();


        });

    }

    private void singUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String firstName = singUpName.getText();
        String lastName = singUpLastName.getText();
        String userName = login_field.getText();
        String password = password_field.getText();
        String location = singUpCountru.getText();
        String gender = "g";
        String admin = "0";
        if(singUpCheckBoxMale.isSelected())
            gender = "Мужской";
        else
            gender = "Женский";

        User user = new User(firstName,lastName,userName,password,location,gender,admin);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                dbHandler.signUpUser(user);
            }
        });
        t.run();
    }
}

