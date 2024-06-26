package org.example.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.bo.BoFactory;
import org.example.bo.custom.UserBo;
import org.example.bo.impl.QueryBoImpl;
import org.example.dto.tm.TransactionTm;
import org.example.dto.TransactionDto;
import org.example.dto.UserDto;

import java.io.IOException;
import java.util.List;

public class HistoryManageController {

    @FXML
    private JFXComboBox cmbUserId;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colBookTitle;

    @FXML
    private TableColumn<?, ?> colBorrowDate;

    @FXML
    private TableColumn<?, ?> colReturnDate;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colUser;

    @FXML
    private TableView<TransactionTm> tblTransction;

    UserBo userBo = (UserBo) BoFactory.getBoFactory().getBo(BoFactory.BOTypes.USER);

    QueryBoImpl queryBo = new QueryBoImpl();

    public void initialize(){
        setUser();
        setCellValues();
    }

    private void setCellValues() {
        colUser.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colBookId.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        colBookTitle.setCellValueFactory(new PropertyValueFactory<>("book_Title"));
        colBorrowDate.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    private void setUser() {
        try {
            List<UserDto> user = userBo.getAllUser();

            ObservableList<String> userDto = FXCollections.observableArrayList();

            for(UserDto dto : user){
                userDto.add(
                        dto.getId()
                );
            }
            cmbUserId.setItems(userDto);

        }catch (Exception e){

        }
    }

    @FXML
    void closeOnAction(MouseEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage) cmbUserId.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void mouseClickOnAction(MouseEvent event) {



    }

    @FXML
    void userOnAction(ActionEvent event) {
        String user = (String) cmbUserId.getValue();

        try{

            List<TransactionDto> transactionDto = queryBo.getTransactions(user);

            ObservableList<TransactionTm> tm = FXCollections.observableArrayList();

            for(TransactionDto tr : transactionDto){
                tm.add(new TransactionTm(
                        tr.getUserName(),
                        tr.getBook_id(),
                        tr.getBook_Title(),
                        tr.getBorrowDate(),
                        tr.getReturnDate(),
                        tr.getStatus()
                ));

            }
            tblTransction.setItems(tm);

        }catch (Exception e){

        }
    }

}
