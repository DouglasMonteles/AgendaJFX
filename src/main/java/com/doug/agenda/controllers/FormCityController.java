package com.doug.agenda.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.doug.agenda.controllers.contracts.IRegister;
import com.doug.agenda.dao.GenericCrudDao;
import com.doug.agenda.model.City;
import com.doug.agenda.utils.Alert;
import com.doug.agenda.utils.UF;
import com.jfoenix.controls.JFXComboBox;
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

public class FormCityController implements Initializable, IRegister {

	@FXML
	private Label lbTitle;

	@FXML
	private Button btnDelete;

	@FXML
	private Button btnNew;

	@FXML
	private Button btnSave;

	@FXML
	private TableView<City> tableView;

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
	
	private GenericCrudDao<City> cDao = new GenericCrudDao<>(City.class);
	
	private ObservableList<City> obsList = FXCollections.observableArrayList();
	
	private List<City> cities;
	
	private City selectedCity = new City();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lbTitle.setText("Cadastro de cidade");
		
		createTableColumns();
		updateTable();
		setFormFields();
		
		tfuf.setItems(UF.ufGenerator());
	}

	@FXML
	void deleteRegister(ActionEvent event) {
		if (Alert.confirmAlert("Deseja realmente excluir a cidade: " + selectedCity.getDescription() + "?")) {
			cDao.delete(selectedCity, selectedCity.getId());
			
			clearFormFields();
			updateTable();
			
			Alert.informationAlert("Cidade excluída com sucesso!");
		}
	}

	@FXML
	void includeRegister(ActionEvent event) {
		clearFormFields();
	}

	@FXML
	void saveRegister(ActionEvent event) {
		City city = new City();
		
		if (selectedCity != null) {
			city.setId(selectedCity.getId());
		}
		
		city.setCep(Long.valueOf(tfcep.getText()));
		city.setDescription(tfDescription.getText());
		city.setUf(tfuf.getValue());
		
		if (cDao.save(city)) {
			Alert.informationAlert("Cidade cadastrada com sucesso!");
		} else {
			Alert.informationAlert("Erro ao cadastrar cidade");
		}
		
		updateTable();
		clearFormFields();
	}

	@FXML
	void clickTable(MouseEvent event) {
		setFormFields();
	}

	@FXML
	void moveTable(KeyEvent event) {
		setFormFields();
	}

	@FXML
	void filterRegisters(KeyEvent event) {
		updateTable();
	}

	@Override
	public void createTableColumns() {
		TableColumn<City, Long> idColumn = new TableColumn<>("ID");
		
		TableColumn<City, String> descriptionColumn = new TableColumn<>("DESCRIÇÃO");
		
		TableColumn<City, Long> cepColumn = new TableColumn<>("CEP");
		
		TableColumn<City, String> ufColumn = new TableColumn<>("UF");
		
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		tableView.getColumns().addAll(idColumn, descriptionColumn, cepColumn, ufColumn);
		
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		cepColumn.setCellValueFactory(new PropertyValueFactory<>("cep"));
		ufColumn.setCellValueFactory(new PropertyValueFactory<>("uf"));
	}

	@Override
	public void updateTable() {
		obsList.clear();
		
		cities = cDao.findAll(tfSearch.getText());
		cities.forEach(obsList::add);
		
		tableView.getItems().setAll(obsList);
		tableView.getSelectionModel().selectFirst();
	}

	@Override
	public void setFormFields() {
		if (!tableView.getItems().isEmpty()) {
			int index = tableView.getSelectionModel().getSelectedIndex();
			
			selectedCity = tableView.getItems().get(index);
			
			tfId.setText(String.valueOf(selectedCity.getId()));
			tfDescription.setText(selectedCity.getDescription());
			tfcep.setText(String.valueOf(selectedCity.getCep()));
			tfuf.setValue(selectedCity.getUf());
		}
	}

	@Override
	public void clearFormFields() {
		selectedCity = null;
		
		tfId.clear();
		tfDescription.clear();
		tfcep.clear();
		tfuf.getSelectionModel().select(-1);
	}

}
