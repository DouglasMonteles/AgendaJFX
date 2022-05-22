package com.doug.agenda;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(
				getClass().getResource("/views/MainScreen.fxml"));
			
			Image applicationIcon = new Image(getClass()
					.getResourceAsStream("/icons/iconeAplicacao.png"));
			
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Agenda JavaFX");
			primaryStage.setMaximized(true);
			primaryStage.getIcons().add(applicationIcon);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
