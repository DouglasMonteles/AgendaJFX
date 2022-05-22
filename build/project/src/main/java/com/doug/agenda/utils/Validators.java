package com.doug.agenda.utils;

import java.lang.reflect.Field;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;

public class Validators {

	public static void addBorderColorTooltip(Node n, Tooltip t) {
		Tooltip.install(n, t);
		
		n.setStyle("-fx-border-color: #00CED1;");
	}
	
	public static void removeBorderColorTooltip(Node n, Tooltip t) {
		Tooltip.uninstall(n, t);
		
		n.setStyle(null);
	}
	
	public static void message(Node n, Tooltip t) {
		Tooltip.install(n, t);
	}
	
	public static void timeTooltip(Tooltip tooltip) {
		try {
	        Field fieldBehavior = tooltip.getClass().getDeclaredField("BEHAVIOR");
	        fieldBehavior.setAccessible(true);
	        Object objBehavior = fieldBehavior.get(tooltip);

	        Field fieldTimer = objBehavior.getClass().getDeclaredField("activationTimer");
	        fieldTimer.setAccessible(true);
	        Timeline objTimer = (Timeline) fieldTimer.get(objBehavior);

	        objTimer.getKeyFrames().clear();
	        objTimer.getKeyFrames().add(new KeyFrame(new Duration(250)));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
}
