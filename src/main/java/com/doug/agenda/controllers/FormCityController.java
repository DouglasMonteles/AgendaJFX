package com.doug.agenda.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.doug.agenda.controllers.contracts.IRegister;
import com.doug.agenda.utils.UF;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FormCityController implements Initializable, IRegister {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<?> tableView;

    @FXML
    private JFXTextField tfDescription;

    @FXML
    private JFXTextField tfId;

    @FXML
    private TextField tfSearch;

    @FXML
    private JFXTextField tfcep;

    @FXML
    private JFXComboBox<String> tfuf;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	tfuf.setItems(UF.ufGenerator());
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
