package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;

public class showAllFlowersController {
	@FXML
	private Button back;
	@FXML
	private Button exit;
	@FXML
	private GridPane showPhotoPane;
	private GridPane showFlowersPane;
	/**
	 * @return the showFlowersPane
	 */
	public GridPane getShowFlowersPane() {
		return showFlowersPane;
	}
	/**
	 * @param showFlowersPane the showFlowersPane to set
	 */
	public void setShowFlowersPane(GridPane showFlowersPane) {
		this.showFlowersPane = showFlowersPane;
	}
	/**
	 * @return the showPhotoPane
	 */
	public GridPane getShowPhotoPane() {
		return showPhotoPane;
	}
	/**
	 * @param showPhotoPane the showPhotoPane to set
	 */
	public void setShowPhotoPane(GridPane showPhotoPane) {
		this.showPhotoPane = showPhotoPane;
	}
	private static Stage primaryStage;
	private static Scene sence;
	private static ArrayList<HBox> allFlowersWithPhoto;
	
	/**
	 * @return the allFlowersWithPhoto
	 */
	public static ArrayList<HBox> getAllFlowersWithPhoto() {
		return allFlowersWithPhoto;
	}
	/**
	 * @param allFlowersWithPhoto the allFlowersWithPhoto to set
	 */
	public static void setAllFlowersWithPhoto(ArrayList<HBox> allFlowersWithPhoto) {
		showAllFlowersController.allFlowersWithPhoto = allFlowersWithPhoto;
	}
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
		showAllFlowersController.primaryStage = primaryStage;
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
		showAllFlowersController.sence = sence;
	}

	// Event Listener on Button[#back].onAction
	@FXML
	public void back(ActionEvent event) {
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
	// Event Listener on Button[#exit].onAction
	@FXML
	public void exit(ActionEvent event) {
		System.exit(0);
	}
	public  static void showPhoto() {
		
	}
}
