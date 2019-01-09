package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import dao.DbOperation;
import entity.Flower;
import javafx.event.ActionEvent;

public class addFlowerController {
	@FXML
	private TextField name;
	@FXML
	private TextField color;
	@FXML
	private TextField freshness;
	@FXML
	private TextField rhizomelength;
	@FXML
	private TextField price;
	@FXML
	private TextField bouquet;
	@FXML
	private Button back;
	@FXML
	private Button add;
	private static Stage primaryStage;
	private static Scene sence;
	/**
	 * @return the primaryStage
	 */
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	/**
	 * @param primaryStage the primaryStage to set
	 */
	public static void setPrimaryStage(Stage primaryStage) {
		addFlowerController.primaryStage = primaryStage;
	}
	/**
	 * @return the sence
	 */
	public static Scene getSence() {
		return sence;
	}
	/**
	 * @param sence the sence to set
	 */
	public static void setSence(Scene sence) {
		addFlowerController.sence = sence;
	}
	

	// Event Listener on Button[#back].onAction
	@FXML
	public void backMian(ActionEvent event) {
		try {
			System.out.println("offfffff");
			sence = new Scene(FXMLLoader.load(getClass().getResource("UI.fxml")));
			sence.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(sence);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	// Event Listener on Button[#add].onAction
	@FXML
	public void addsure(ActionEvent event) {
		String fname = name.getText();
		String fcolor = color.getText();
		String ffreshness = freshness.getText();
		Double frhizomelengeth = Double.valueOf(rhizomelength.getText());
		Double fprice = Double.valueOf(price.getText());
		Integer p_id = Integer.valueOf(bouquet.getText());
		DbOperation add = new DbOperation();
		Flower flower = new Flower(fname,fcolor,ffreshness,frhizomelengeth,fprice,p_id);
		boolean suc = add.addFlower(flower);
		if(suc) {
			Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION,"success");
			confirmation.showAndWait();
		}
		else {
			Alert error = new Alert(Alert.AlertType.ERROR,"ERROR: fail to insert database");
			error.showAndWait();
		}
		
		
	}
}
