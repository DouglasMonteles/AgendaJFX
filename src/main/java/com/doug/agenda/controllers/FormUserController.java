package com.doug.agenda.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FormUserController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<?> tableView;

    @FXML
    private JFXTextField tfId;

    @FXML
    private JFXPasswordField tfPassword;

    @FXML
    private TextField tfSearch;

    @FXML
    private JFXTextField tfUser;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    }

    @FXML
    void deleteRegister(ActionEvent event) {

    }

    @FXML
    void includeRegister(ActionEvent event) {

    }

    @FXML
    void saveRegister(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }

}
