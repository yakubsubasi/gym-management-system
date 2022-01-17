package com.yakub.gym_management_system.Controller;

import com.yakub.gym_management_system.Model.LoginModel;
import com.yakub.gym_management_system.LoginPage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {

    LoginModel loginModel = new LoginModel();

    @FXML
private Label wrongPasswordLabel;

    @FXML
    private Label dbStatus;

    private TextField userNamerTextField;
    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField userNameTextField;
    @FXML
    private Button loginButton;
    @FXML
    protected void onHelloButtonClick() {
        System.out.println("tıklandı");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (this.loginModel.isDBConnected())
            dbStatus.setText("Connected to Database");
        else
            dbStatus.setText("Not Connected");
    }

    public void login() {
        try {
           if (loginModel.isLogin(userNameTextField.getText(),passwordTextField.getText())) {
               System.out.println("bağlantı başarıl");

               Stage stage = new Stage();
               FXMLLoader fxmlLoader = new FXMLLoader(LoginPage.class.getResource("dash-board.fxml"));
               Scene scene = new Scene(fxmlLoader.load());
               stage.setTitle("Dashboard");
               stage.setScene(scene);
               stage.show();


           }
           else
               wrongPasswordLabel.setText("Wrong Password or Username");

        } catch (SQLException | IOException e) {
            System.out.println("yanlış parola ve şifre");
            e.printStackTrace();
        }
    }
}

