package com.doug.agenda.utils;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;

public class ValidField {

	private static final Tooltip tooltip = new Tooltip("Campo abrigatório");
	
	public static boolean checkEmptyField(Node ...nodes) {
		List<Node> fieldsWithError = new ArrayList<>();
		
		tooltip.setStyle(
			"-fx-background-color: linear-gradient(#000, #B22222);" + 
			"-fx-font-wight: bold;"
		);
		
		tooltip.setShowDelay(Duration.seconds(0));
		
		//Validators.timeTooltip(tooltip);
		
		List.of(nodes).forEach(field -> {
			if (field instanceof TextField) {
				TextField tf = (TextField) field;
				
				// Capitura caractere digitado e remove a borda de vazio
				tf.textProperty().addListener((observable, oldValue, newValue) -> {
					Validators.removeBorderColorTooltip(tf, tooltip);
				});
				
				// Se o campo estiver vazio, adicionar a borda acusando erro
				if (tf.getText().trim().equals("")) {
					fieldsWithError.add(field);
					Validators.addBorderColorTooltip(tf, tooltip);
				}
			}
		});
		
		return fieldsWithError.isEmpty();
	}
	
}
