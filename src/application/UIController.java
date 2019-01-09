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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UIController {
	@FXML
	private Button addFlower;
	@SuppressWarnings("rawtypes")
	@FXML
	private ComboBox combobox;
	@FXML
	private Button viewBouquet;
	@FXML
	private Button exit;
	@FXML
	private Button showflowers;
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
		UIController.primaryStage = primaryStage;
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
		UIController.sence = sence;
	}

	// Event Listener on Button[#addFlower].onAction
	@FXML
	public void addFlower(ActionEvent event) {
		try {
			System.out.println("offfffff");
			sence = new Scene(FXMLLoader.load(getClass().getResource("addFlower.fxml")));
			sence.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			addFlowerController.setPrimaryStage(primaryStage);
			addFlowerController.setSence(sence);
			primaryStage.setScene(sence);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	// Event Listener on ComboBox[#combobox].onAction
	@FXML
	public void onclickComboBox(ActionEvent event) {
		
	}
	// Event Listener on Button[#viewBouquet].onAction
	@FXML
	public void onclickViewBouquet(ActionEvent event) throws IOException {
		DbOperation tool;
		Bouquet bouquet ;
		ArrayList<Flower> allBouquetFlowers;
		switch(combobox.getValue().toString()) {
		case "bouquet 1":
		    tool = new DbOperation();
		    bouquet = tool.getBouquetFlowers(1);
		    allBouquetFlowers = tool.getAllFlowersByBouquet(bouquet);
			viewBouquetController.setAllBouquetFlowers(allBouquetFlowers);
			break;
		case "bouquet 2":
		    tool = new DbOperation();
		    bouquet = tool.getBouquetFlowers(2);
		    allBouquetFlowers = tool.getAllFlowersByBouquet(bouquet);
			viewBouquetController.setAllBouquetFlowers(allBouquetFlowers);
			break;
		case "bouquet 3":
		    tool = new DbOperation();
		    bouquet = tool.getBouquetFlowers(3);
		    allBouquetFlowers = tool.getAllFlowersByBouquet(bouquet);
			viewBouquetController.setAllBouquetFlowers(allBouquetFlowers);
			break;
		case "bouquet 4":
		    tool = new DbOperation();
		    bouquet = tool.getBouquetFlowers(4);
		    allBouquetFlowers = tool.getAllFlowersByBouquet(bouquet);
			viewBouquetController.setAllBouquetFlowers(allBouquetFlowers);
			break;
		default:
			tool = new DbOperation();
		    bouquet = tool.getBouquetFlowers(0);
		    allBouquetFlowers = tool.getAllFlowersByBouquet(bouquet);
			viewBouquetController.setAllBouquetFlowers(allBouquetFlowers);
			break;
		}
		try {
			System.out.println("offfffff");
			sence = new Scene(FXMLLoader.load(getClass().getResource("viewBouquet.fxml")));
			sence.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			viewBouquetController.setPrimaryStage(primaryStage);
			viewBouquetController.setSence(sence);
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
	// Event Listener on Button[#showflowers].onAction
	@FXML
	public void showAllFlowers(ActionEvent event) throws IOException {
		System.out.println("offfffff");
		DbOperation tool = new DbOperation();
		ArrayList<Flower> allFlowers = tool.getAllFlowers();
		ArrayList<VBox> allFlowersWithPhoto = getFlowersVbox(allFlowers);
		Pane pane = new Pane();
		pane.setPrefSize(600, 400);
		Button but1 = new Button("back");
		but1.setOnAction(oa->{
			try {
				System.out.println("offfffff");
				sence = new Scene(FXMLLoader.load(getClass().getResource("UI.fxml")));
				sence.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(sence);
				primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		but1.setLayoutX(76);
		but1.setLayoutY(356);
		but1.setPrefWidth(112);
		but1.setPrefHeight(41);
		Button but2 = new Button("exit");
		but2.setOnAction(oa->{
			System.exit(0);
		});
		but2.setLayoutX(368);
		but2.setLayoutY(356);
		but2.setPrefWidth(112);
		but2.setPrefHeight(41);
		GridPane showPane = new GridPane();
		showPane.setLayoutX(17);
		showPane.setLayoutY(0);
		showPane.setPrefHeight(346);
		showPane.setPrefWidth(567);
		for(int i = 0;i < allFlowersWithPhoto.size();i++) {
			showPane.add(allFlowersWithPhoto.get(i), i%4,i/4);
		}
		pane.getChildren().add(showPane);
		pane.getChildren().add(but1);
		pane.getChildren().add(but2);
		sence = new Scene(pane);
		sence.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		showAllFlowersController.setPrimaryStage(primaryStage);
		showAllFlowersController.setSence(sence);
		primaryStage.setScene(sence);
		primaryStage.show();
		
	}
	public static ArrayList<VBox> getFlowersVbox(ArrayList<Flower> allFlowers) {
		ArrayList<VBox> allFlowersWithPhoto = new ArrayList<>();
		for(int i = 0;i < allFlowers.size(); i++) {
			ImageView imv = new ImageView();
			Image image2;
			switch(allFlowers.get(i).getName()) {
				case "rose":
					image2 = new Image(Main.class.getResourceAsStream("/rose.jpg"));
					 break;
				case "magnolia":
					 image2 = new Image(Main.class.getResourceAsStream("/magnolia.jpg"));
					 break;
				case "orchild":
					 image2 = new Image(Main.class.getResourceAsStream("/orchild.jpg"));
					 break;
				case "narcissus":
					 image2 = new Image(Main.class.getResourceAsStream("/narcissus.jpg"));
					 break;
				case "lily":
					 image2 = new Image(Main.class.getResourceAsStream("/lily.jpg"));
					 break;
				case "chrysanthemum":
					 image2 = new Image(Main.class.getResourceAsStream("/chrysanthemum.jpg"));
					 break;
				default:
					 image2 = new Image(Main.class.getResourceAsStream("/erro.jpg"));
				
			}
			Label freshness = new Label("Freshness:"+allFlowers.get(i).getFreshness());
			Label price = new Label("Price:"+String.valueOf(allFlowers.get(i).getPrice()));
		    imv.setImage(image2);
		    imv.setFitWidth(140);
		    imv.setFitHeight(140);
		    VBox pictureRegion = new VBox();
		    pictureRegion.setPrefWidth(150);
		    pictureRegion.setPrefHeight(150);
		    pictureRegion.getChildren().add(imv);
		    pictureRegion.getChildren().add(freshness);
		    pictureRegion.getChildren().add(price);
		    allFlowersWithPhoto.add(pictureRegion);
		}
		return allFlowersWithPhoto;
	}
}
