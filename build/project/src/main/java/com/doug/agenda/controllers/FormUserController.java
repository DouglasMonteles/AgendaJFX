package com.doug.agenda.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.doug.agenda.controllers.contracts.IRegister;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FormUserController implements Initializable, IRegister {

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

	@Override
	public void createTableColumns() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFormFields() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearFormFields() {
		// TODO Auto-generated method stub
		
	}

}
