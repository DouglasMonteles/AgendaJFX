package com.doug.agenda.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import com.doug.agenda.controllers.contracts.IRegister;
import com.doug.agenda.dao.ComboBoxGenericDao;
import com.doug.agenda.dao.ContactDao;
import com.doug.agenda.dao.GenericCrudDao;
import com.doug.agenda.model.City;
import com.doug.agenda.model.Contact;
import com.doug.agenda.model.TypeContact;
import com.doug.agenda.utils.Alert;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class FormContactController implements Initializable, IRegister {

	@FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private JFXCheckBox ckAtivo;

    @FXML
    private DatePicker dpBirthDate;

    @FXML
    private Label lbTitle;

    @FXML
    private JFXRadioButton rbFemile;

    @FXML
    private JFXRadioButton rbMale;

    @FXML
    private ToggleGroup sexSelection;

    @FXML
    private TableView<Contact> tableView;

    @FXML
    private JFXTextField tfCep;

    @FXML
    private JFXComboBox<City> tfCidade;

    @FXML
    private JFXTextField tfDescription;

    @FXML
    private JFXTextField tfEmail;

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
    private JFXComboBox<TypeContact> tfTipoContato;

    @FXML
    private JFXTextField tfUf;
    
    private ComboBoxGenericDao<TypeContact> cbDao = new ComboBoxGenericDao<>();
    
    private ComboBoxGenericDao<City> cDao = new ComboBoxGenericDao<>();
    
    private ContactDao contDao = new ContactDao();
    
    private GenericCrudDao<Contact> ctDao = new GenericCrudDao<Contact>(Contact.class);
    
    private ObservableList<Contact> obsContact = FXCollections.observableArrayList(); 
    
    private List<Contact> contacts = List.of();
    
    private Contact selectedContact = new Contact();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	createTableColumns();
    	updateTable();
    	setFormFields();
    	
    	tfTipoContato.setItems(cbDao.findAll(TypeContact.class));
    	tfCidade.setItems(cDao.findAll(City.class));
    	
    	tfCidade.setOnAction(action -> {
    		var c = tfCidade.getSelectionModel().getSelectedItem();
    		
    		if (c != null) {
    			tfUf.setText(c.getUf());
        		tfCep.setText(String.valueOf(c.getCep()));
    		}
    	});
    	
    	ckAtivo.setSelected(true);
    }

    @FXML
    void clickTable(MouseEvent event) {
    	setFormFields();
    }

    @FXML
    void deleteRegister(ActionEvent event) {
    	if (Alert.confirmAlert("Deseja realmente excluir este contato?")) {
	    	ctDao.delete(selectedContact, selectedContact.getId());
	    	clearFormFields();
	    	updateTable();
	    	
	    	Alert.informationAlert("Contato excluído com sucesso!");
    	}
    }

    @FXML
    void filterRegisters(KeyEvent event) {
    	updateTable();
    }

    @FXML
    void includeRegister(ActionEvent event) {
    	clearFormFields();
    }

    @FXML
    void moveTable(KeyEvent event) {
    	setFormFields();
    }

    @FXML
    void saveRegister(ActionEvent event) {
    	Contact c = new Contact();
    	
    	if (selectedContact != null) {
    		c.setId(selectedContact.getId());
    	}
    	
    	c.setDescription(tfDescription.getText());
    	c.setAndress(tfEndereco.getText());
    	c.setNumber(Integer.valueOf(tfNumero.getText()));
    	c.setEmail(tfEmail.getText());
    	c.setPhone1(tfTelefone1.getText());
    	c.setPhone2(tfTelefone2.getText());
    	
    	LocalDate birthDate = dpBirthDate.getValue();
    	c.setBirthDate(birthDate);
    	
    	c.setActive(ckAtivo.isSelected());
    	
    	c.setSex(rbMale.isSelected() ? "Masculino" : "Feminino");
    	
    	c.setCity(tfCidade.getSelectionModel().getSelectedItem());
    	c.setTypeContact(tfTipoContato.getSelectionModel().getSelectedItem());
    	
    	if (selectedContact.getId() == null && contDao.save(c)) {
    		Alert.informationAlert("Contato salvo com sucesso!");
    		
    		updateTable();
    	} else if (ctDao.save(c)) {
    		Alert.informationAlert("Contato salvo com sucesso!");
    		
    		updateTable();
    	} else {
    		Alert.informationAlert("Ocorreu um erro ao tentar salvar o contato");
    	}
    }

	@Override
	public void createTableColumns() {
		TableColumn<Contact, Long> idColumn = new TableColumn<>("ID");
		TableColumn<Contact, String> descriptionColumn = new TableColumn<>("DESCRIÇÃO");
		TableColumn<Contact, TypeContact> typeContactColumn = new TableColumn<>("TIPO DE CONTATO");
		TableColumn<Contact, City> cityColumn = new TableColumn<>("CIDADE");
		TableColumn<Contact, LocalDate> birthDateColumn = new TableColumn<>("DATA DE NASCIMENTO");
		
		tableView.getColumns().addAll(idColumn, descriptionColumn, typeContactColumn, cityColumn, birthDateColumn);
	
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		typeContactColumn.setCellValueFactory(new PropertyValueFactory<>("typeContact"));
		cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
		birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
		
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		birthDateColumn.setCellFactory(tc -> new TableCell<>() {
			protected void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				if (date != null) {
					setText(dateFormater.format(date));
				} else {
					setText(null);
				}
			};
		});
	}

	@Override
	public void updateTable() {
		obsContact.clear();
		
		contacts = ctDao.findAll(tfSearch.getText());
		contacts.forEach(obsContact::add);
		
		tableView.getItems().setAll(obsContact);
		tableView.getSelectionModel().selectFirst();
	}

	@Override
	public void setFormFields() {
		if (!tableView.getItems().isEmpty()) {
			selectedContact = tableView.getSelectionModel().getSelectedItem();
			
			tfId.setText(String.valueOf(selectedContact.getId()));
			tfDescription.setText(selectedContact.getDescription());
			tfEndereco.setText(selectedContact.getAndress());
			tfNumero.setText(String.valueOf(selectedContact.getNumber()));
			tfTelefone1.setText(selectedContact.getPhone1());
			tfTelefone2.setText(selectedContact.getPhone2());
			tfEmail.setText(selectedContact.getEmail());
			
			ckAtivo.setSelected(selectedContact.isActive());
			
			if (selectedContact.getSex().equals("Masculino")) {
				rbMale.setSelected(true);
			} else {
				rbFemile.setSelected(true);
			}
			
			dpBirthDate.setValue(selectedContact.getBirthDate());
			
			TypeContact typeContSelected = new TypeContact();
			typeContSelected.setId(selectedContact.getTypeContact().getId());
			typeContSelected.setDescription(selectedContact.getTypeContact().getDescription());
			
			tfTipoContato.getSelectionModel().selectFirst();
			tfTipoContato.setValue(typeContSelected);
			
			tfCidade.getSelectionModel().selectFirst();
			tfCidade.setValue(selectedContact.getCity());
		}
	}

	@Override
	public void clearFormFields() {
		tfId.clear();
		tfDescription.clear();
		tfEndereco.clear();
		tfNumero.clear();
		tfTelefone1.clear();
		tfTelefone2.clear();
		tfEmail.clear();
		rbMale.setSelected(true);
		ckAtivo.setSelected(true);
		tfCidade.getSelectionModel().select(-1);
		tfTipoContato.getSelectionModel().select(-1);
		dpBirthDate.setValue(null);
		
		selectedContact = null;
		
		tfDescription.requestFocus();
	}

}
