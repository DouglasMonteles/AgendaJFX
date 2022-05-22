package com.doug.agenda.utils;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Alert {
	
	final static ButtonType btnConfirm = new ButtonType("Confirmar");
	final static ButtonType btnCancel = new ButtonType("Cancelar");
	static Boolean response;

	public static void informationAlert(String msg) {
		var alert = new javafx.scene.control.Alert(AlertType.INFORMATION);
		
		alert.setHeaderText("Informação sobre cadastro");
		alert.setContentText(msg);
		
		alert.showAndWait();
	}
	
	public static boolean confirmAlert(String msg) {
		var alert = new javafx.scene.control.Alert(AlertType.CONFIRMATION);
		
		alert.setHeaderText("Confirme esta ação");
		alert.setContentText(msg);
		alert.getButtonTypes().setAll(btnConfirm, btnCancel);
		
		alert.showAndWait().ifPresent(btnClicked -> {
			if (btnClicked == btnConfirm) {
				response = true;
			} else {
				response = false;
			}
		});;
		
		return response;
	}
	
}
