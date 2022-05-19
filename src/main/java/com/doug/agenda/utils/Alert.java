package com.doug.agenda.utils;

import javafx.scene.control.Alert.AlertType;

public class Alert {

	public static void informationAlert(String msg) {
		var alert = new javafx.scene.control.Alert(AlertType.INFORMATION);
		
		alert.setHeaderText("Informação sobre cadastro");
		alert.setContentText(msg);
		alert.showAndWait();
	}
	
}
