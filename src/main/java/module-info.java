module agendaJFX {
	requires javafx.controls;
	requires javafx.base;
	requires javafx.fxml;
	
	opens com.doug.agenda to javafx.graphics, javafx.fxml, javafx.base;
	opens com.doug.agenda.controllers to javafx.fxml;
}