package com.doug.agenda.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UF {

	private static ObservableList<String> obsList;
	
	public static ObservableList<String> ufGenerator() {
		obsList = FXCollections.observableArrayList(
			"MG",
			"SP",
			"RJ",
			"DF"
		);
		
		return obsList;
	}
	
}
