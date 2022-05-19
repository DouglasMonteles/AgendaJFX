package com.doug.agenda.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.doug.agenda.controllers.contracts.IRegister;
import com.doug.agenda.dao.TypeContactDao;
import com.doug.agenda.model.TypeContact;
import com.doug.agenda.utils.Alert;
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
import javafx.scene.input.MouseEvent;

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
    
    private TypeContact typeContactSelected;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	this.lbTitle.setText("Cadastro de Tipo de Contato");
    	
    	this.createTableColumns();
    	this.updateTable();
    	this.setFormFields();
    }

    @FXML
    void deleteRegister(ActionEvent event) {
    	if (Alert.confirmAlert("Deseja realmente excluir o tipo de contato: " + tfDescription.getText())) {
    		tcDao.delete(typeContactSelected);    		
    		clearFormFields();
    		updateTable();
    		
    		Alert.informationAlert("Tipo de contato excluído com sucesso!");
    	}    	
    }

    @FXML
    void includeRegister(ActionEvent event) {
    	clearFormFields();
    }

    @FXML
    void saveRegister(ActionEvent event) {
    	TypeContact tc = new TypeContact();
    	
    	if (typeContactSelected != null) {
    		tc.setId(typeContactSelected.getId());
    	}
    	
    	tc.setDescription(tfDescription.getText());

    	if (tcDao.save(tc)) {
    		Alert.informationAlert("Tipo de contato gravado com sucesso!");
    	} else {
    		Alert.informationAlert("Ocorreu um erro ao tentar gravar um tipo de contato!");
    	}
    	
    	updateTable();
    	clearFormFields();
    }

    @FXML
    void filterRecords(KeyEvent event) {
    	updateTable();
    }
    
    @FXML
    void clickedOnTableLine(MouseEvent event) {
    	setFormFields();
    }
    
    @FXML
    void moveTable(KeyEvent event) {
    	setFormFields();
    }

	@Override
	public void createTableColumns() {
		TableColumn<TypeContact, Long> idColumn = new TableColumn<TypeContact, Long>("ID");
	
		idColumn.setMinWidth(40);
		idColumn.setMaxWidth(120);
		
		TableColumn<TypeContact, String> descriptionColumn = new TableColumn<TypeContact, String>("DESCRIÇÃO");
		
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
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
		typeContactSelected = tableView.getItems()
				.get(tableView.getSelectionModel().getSelectedIndex());
		
		tfId.setText(String.valueOf(typeContactSelected.getId()));
		tfDescription.setText(typeContactSelected.getDescription());
	}

	@Override
	public void clearFormFields() {
		typeContactSelected = null;
		tfId.clear();
		tfDescription.clear();
		
		tfDescription.requestFocus(); // posiciona o cursor neste campo
	}

}
