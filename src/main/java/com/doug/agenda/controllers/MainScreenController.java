package com.doug.agenda.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainScreenController implements Initializable {

    @FXML
    private MenuItem aboutSystemMenuItem;

    @FXML
    private MenuItem adressContactMenuItem;

    @FXML
    private MenuItem cityMenuItem;

    @FXML
    private MenuItem contactMenuItem;

    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private MenuItem generalContactsMenuItem;

    @FXML
    private Menu menuAbout;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menuFiles;

    @FXML
    private Menu menuReports;

    @FXML
    private MenuItem phoneContactMenuItem;

    @FXML
    private MenuItem typeContactMenuItem;

    @FXML
    private MenuItem typeContactsMenuItem;

    @FXML
    private MenuItem usersMenuItem;
    
    public MainScreenController() {}
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	Image contactIcon = new Image(getClass().getResourceAsStream("/icons/iconeMenuContato.png"));
    	Image typeContactsIcon = new Image(getClass().getResourceAsStream("/icons/iconeMenuContatoTipo.png"));
    	Image cityIcon = new Image(getClass().getResourceAsStream("/icons/iconeMenuCidade.png"));
    	Image usersIcon = new Image(getClass().getResourceAsStream("/icons/iconeMenuUsuario.png"));
    	Image exitIcon = new Image(getClass().getResourceAsStream("/icons/iconeMenuSair.png"));
    	Image aboutIcon = new Image(getClass().getResourceAsStream("/icons/iconeMenuSobre.png"));
    	Image reportIcon = new Image(getClass().getResourceAsStream("/icons/iconeMenuRelatorio.png"));
    	
    	this.contactMenuItem.setGraphic(new ImageView(contactIcon));
    	this.typeContactsMenuItem.setGraphic(new ImageView(typeContactsIcon));
    	this.cityMenuItem.setGraphic(new ImageView(cityIcon));
    	this.usersMenuItem.setGraphic(new ImageView(usersIcon));
    	this.exitMenuItem.setGraphic(new ImageView(exitIcon));
    	this.aboutSystemMenuItem.setGraphic(new ImageView(aboutIcon));
    	this.generalContactsMenuItem.setGraphic(new ImageView(reportIcon));
    	this.adressContactMenuItem.setGraphic(new ImageView(reportIcon));
    	this.phoneContactMenuItem.setGraphic(new ImageView(reportIcon));
    	this.typeContactMenuItem.setGraphic(new ImageView(reportIcon));
    }

    @FXML
    void accessAndressContact(ActionEvent event) {

    }

    @FXML
    void accessCity(ActionEvent event) {

    }

    @FXML
    void accessContact(ActionEvent event) {

    }

    @FXML
    void accessGeneralContacts(ActionEvent event) {

    }

    @FXML
    void accessInfoAboutSystem(ActionEvent event) {

    }

    @FXML
    void accessPhoneContact(ActionEvent event) {

    }

    @FXML
    void accessTypeContact(ActionEvent event) {

    }

    @FXML
    void accessTypeContacts(ActionEvent event) {

    }

    @FXML
    void accessUsers(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {

    }

}