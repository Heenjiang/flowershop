package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.ArrayList;

import dao.DbOperation;
import entity.Bouquet;
import entity.Flower;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class viewBouquetController {
	@FXML
	private Pane bouquetPane;
	@SuppressWarnings("rawtypes")
	@FXML
	private ComboBox combobox;
	@FXML
	private Button sort;
	@FXML
	private Pane showpane;
	@FXML
	private Button back;
	@FXML
	private Button select;
	private static Stage primaryStage;
	private static Scene sence;
	private static ArrayList<Flower> allBouquetFlowers;
	/**
	 * @return the allBouquetFlowers
	 */
	public static ArrayList<Flower> getAllBouquetFlowers() {
		return allBouquetFlowers;
	}
	/**
	 * @param allBouquetFlowers the allBouquetFlowers to set
	 */
	public static void setAllBouquetFlowers(ArrayList<Flower> allBouquetFlowers) {
		viewBouquetController.allBouquetFlowers = allBouquetFlowers;
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
		viewBouquetController.primaryStage = primaryStage;
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
		viewBouquetController.sence = sence;
	}
	

	// Event Listener on ComboBox[#combobox].onAction
	@FXML
	public void onclickComboBox(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#sort].onAction
	@FXML
	public void sort(ActionEvent event) {
		sortByFreshness();
		ArrayList<VBox> selectedFlowerVbox = UIController.getFlowersVbox(allBouquetFlowers);
		show(selectedFlowerVbox);
		
	}
	// Event Listener on Button[#back].onAction
	@FXML
	public void backMenue(ActionEvent event) {
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
	// Event Listener on Button[#select].onAction
	@FXML
	public void showSelect(ActionEvent event) {
		ArrayList<Flower> selectedFlower = null;
		ArrayList<VBox> selectedFlowerVbox;
		switch(combobox.getValue().toString()) {
		case "5.0-10.0":
			selectedFlower = select(5.0,10.0);
				break;
		case "10.0-15.0":
			selectedFlower = select(10.0,15.0);
				break;
		case "0-5.0":
			selectedFlower = select(0.0,5.0);
			break;
		default:
			selectedFlower = select(0.0,15.0);
			break;
		}
		selectedFlowerVbox = UIController.getFlowersVbox(selectedFlower);
		show(selectedFlowerVbox);
	}
	
	public void sortByFreshness(){
		for(int i = 0; i < allBouquetFlowers.size() ;i++) {
			for(int j = 0; j < allBouquetFlowers.size()-i-1; j++) {
				if(Double.valueOf(allBouquetFlowers.get(j).getFreshness().replace("%", "")) < Double.valueOf(allBouquetFlowers.get(j+1).getFreshness().replace("%", ""))) {
					Flower temp = allBouquetFlowers.get(j);
					allBouquetFlowers.set(j, allBouquetFlowers.get(j+1));
					allBouquetFlowers.set(j+1, temp);
				}
			}
		}
	}
	public ArrayList<Flower> select(double min,double max) {
		ArrayList<Flower> selectedFlower = new ArrayList<>();
		for(int i = 0; i < allBouquetFlowers.size() ;i++) {
			if(allBouquetFlowers.get(i).getRhizomelength() >= min &&allBouquetFlowers.get(i).getRhizomelength() <=  max) {
				selectedFlower.add(allBouquetFlowers.get(i));
			}
		}
		return selectedFlower;
	}
	
	public void show(ArrayList<VBox> list) {
		GridPane show = new GridPane();
		show.setLayoutX(5);
		show.setLayoutY(32);
		show.setPrefHeight(280);
		show.setPrefWidth(600);
		for(int i = 0;i < list.size();i++) {
			show.add(list.get(i), i%4,i/4);
		}
		showpane.getChildren().clear();
		showpane.getChildren().add(show);
	}
}