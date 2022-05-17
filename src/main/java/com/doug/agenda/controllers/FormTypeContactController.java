package com.doug.agenda.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.doug.agenda.dao.TypeContactDao;
import com.doug.agenda.model.TypeContact;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FormTypeContactController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;
    
    @FXML
    private Label lbTitle;

    @FXML
    private TableView<?> tableView;

    @FXML
    private JFXTextField tfDescription;

    @FXML
    private JFXTextField tfId;

    @FXML
    private TextField tfSearch;
    
    TypeContactDao tcDao = new TypeContactDao();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	this.lbTitle.setText("Cadastro de Tipo de Contato");
    }

    @FXML
    void deleteRegister(ActionEvent event) {

    }

    @FXML
    void includeRegister(ActionEvent event) {

    }

    @FXML
    void saveRegister(ActionEvent event) {
    	TypeContact tc = new TypeContact();
    	
    	tc.setDescription(tfDescription.getText());
    	
    	System.out.println(tfDescription.getText());
    	tcDao.save(tc);
    }

    @FXML
    void search(ActionEvent event) {

    }

}
