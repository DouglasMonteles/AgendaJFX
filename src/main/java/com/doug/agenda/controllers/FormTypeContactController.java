package com.doug.agenda.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.doug.agenda.controllers.contracts.IRegister;
import com.doug.agenda.dao.TypeContactDao;
import com.doug.agenda.model.TypeContact;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class FormTypeContactController implements Initializable, IRegister {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;
    
    @FXML
    private Label lbTitle;

    @FXML
    private TableView<TypeContact> tableView;

    @FXML
    private JFXTextField tfDescription;

    @FXML
    private JFXTextField tfId;

    @FXML
    private TextField tfSearch;
    
    private TypeContactDao tcDao = new TypeContactDao();
    
    private ObservableList<TypeContact> observableTypeContact = FXCollections.observableArrayList(); 
    
    private List<TypeContact> listTypesOfContacts;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	this.lbTitle.setText("Cadastro de Tipo de Contato");
    	
    	this.createTableColumns();
    	this.updateTable();
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

    	tcDao.save(tc);
    	
    	updateTable();
    }

    @FXML
    void filterRecords(KeyEvent event) {
    	updateTable();
    }

	@Override
	public void createTableColumns() {
		TableColumn<TypeContact, Long> idColumn = new TableColumn<TypeContact, Long>("ID");
		TableColumn<TypeContact, String> descriptionColumn = new TableColumn<TypeContact, String>("DESCRI��O");
	
		tableView.getColumns().addAll(idColumn, descriptionColumn);
		
		idColumn.setCellValueFactory(new PropertyValueFactory<TypeContact, Long>("id"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<TypeContact, String>("description"));
	}

	@Override
	public void updateTable() {
		observableTypeContact.clear();
		listTypesOfContacts = tcDao.findAll(tfSearch.getText());
		
		listTypesOfContacts.forEach(observableTypeContact::add);
		
		tableView.getItems().setAll(observableTypeContact);
		tableView.getSelectionModel().selectFirst();
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
