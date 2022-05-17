package com.doug.agenda.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FormContactController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<?> tableView;

    @FXML
    private JFXTextField tfCep;

    @FXML
    private JFXComboBox<?> tfCidade;

    @FXML
    private JFXTextField tfDescription;

    @FXML
    private JFXTextField tfDtNascimento;

    @FXML
    private JFXTextField tfEndereco;

    @FXML
    private JFXTextField tfId;

    @FXML
    private JFXTextField tfNumero;

    @FXML
    private TextField tfSearch;

    @FXML
    private JFXTextField tfTelefone1;

    @FXML
    private JFXTextField tfTelefone2;

    @FXML
    private JFXComboBox<?> tfTipoContato;

    @FXML
    private JFXTextField tfUf;
    
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
