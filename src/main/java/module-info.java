module agendaJFX {
	requires javafx.controls;
	requires javafx.base;
	requires javafx.fxml;
	requires com.jfoenix;
	
	requires java.persistence;
	requires java.sql;
	requires org.hibernate.orm.core;
	requires org.hibernate.commons.annotations;
	requires hibernate.entitymanager;
	requires sqlite.dialect;
	requires javafx.graphics;
	
	opens com.doug.agenda to javafx.graphics, javafx.fxml, javafx.base;
	opens com.doug.agenda.controllers to javafx.fxml;
	opens com.doug.agenda.model to java.persistence, org.hibernate.orm.core;
	
}