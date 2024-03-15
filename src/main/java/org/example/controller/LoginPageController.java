package org.example.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.bo.BoFactory;
import org.example.bo.custom.AdminBo;
import org.example.dto.AdminDto;

import java.io.IOException;

public class LoginPageController {

    public AnchorPane AnchorPane;
    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtPassword;

    AdminBo adminBo = (AdminBo) BoFactory.getBoFactory().getBo(BoFactory.BOTypes.ADMIN);

    @FXML
    void createOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/createAccount.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void loginOnAction(ActionEvent event) throws IOException {

        String name = txtName.getText();
        String password = txtPassword.getText();


        if (name.isEmpty() || password.isEmpty()){
            new Alert(Alert.AlertType.ERROR,"fields are empty").show();
            return;
        }


        boolean isTrue = false;
        try {
            isTrue = adminBo.check(new AdminDto("",name,password));
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Check UserName or Password").show();
            throw new RuntimeException(e);
        }

        if (isTrue) {
            Parent rootNode = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
            Scene scene = new Scene(rootNode);
            Stage stage = (Stage) txtName.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Check USerName or Password").show();
        }


    }

    @FXML
    void nameOnAction(ActionEvent event) {
        txtPassword.requestFocus();
    }

    @FXML
    void passwordOnAction(ActionEvent event) throws IOException {
        loginOnAction(event);
    }

    public void closeOnAction(MouseEvent mouseEvent) {
        Stage stage = (Stage) txtName.getScene().getWindow();
        stage.close();
    }
}
