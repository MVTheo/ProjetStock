package application;
	
import application.view.ListePieceControlleur;
import application.view.ListePieceControlleur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.util.ArrayList;

import application.model.beans.Piece;
import application.model.dao.PieceDAO;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

///
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//On charge le FXML, qui lui meme va intancier son contrôleur
			FXMLLoader loader = new FXMLLoader();    
	           	       			
			loader.setLocation(Main.class.getResource("view/viewListePiece.fxml"));		
						
			AnchorPane root = (AnchorPane) loader.load();
			
			//Je récupère le contrôleur associé à ce loader (le controleur de la vue fxml)
			ListePieceControlleur etc = loader.getController();
			
			
			//System.out.println(etc.toString());
			
			//ICI je peux commencer à aller interroger ma BDD et mettre ça dans ma vue.
			PieceDAO pdao = new PieceDAO();
			Piece p1 = pdao.find(1);
			System.out.println(p1);
			
			//etc.fillView(p1);
			etc.intialize();
			
		
			
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
