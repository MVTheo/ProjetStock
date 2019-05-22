package application.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

import application.Main;
import application.model.beans.Piece;
import application.model.beans.PieceAudit;
import application.model.dao.DAO;
import application.model.dao.PieceAuditDAO;
import application.model.dao.PieceDAO;
import javafx.application.Application;

public class PieceController {
	//rappel: besoin de @FXML pour faire le lien dans le fichier fxml
		
	@FXML
	private TextField tf;
	
	@FXML
	private ScrollPane spA;
		
	
	private GridPane gp;
	
	PieceAuditDAO padao;
	
	ArrayList<PieceAudit> pa;
	
	public void intialize() {
		padao = new PieceAuditDAO();	
		
		gp = new GridPane();		
		spA.setContent(gp);	
	
		
		afficherListe();
	}
	
	

	//Méthode publique permettant, à partir d'un objet étudiant, de me remplir les bons label sur l'interface
	
	

	
	
	
	public void afficherListe() {
		
		gp.getChildren().clear();
		System.out.println("plop");		
		
		//on utilise le DAO pour aller chercher le bon objet Etudiant,
		
		
		
			pa = padao.findByName("");	
			
				
		int taille = pa.size();
		for(int i=0; i<taille; i++) {
			
			String id = String.valueOf(pa.get(i).getId());
			String Operation = String.valueOf(pa.get(i).getOperation());
			
			Label lbId = new Label(id);
			Label lbNom = new Label(Operation);
			
			
	
			GridPane.setConstraints(lbId, 0, i);			
			GridPane.setConstraints(lbNom, 1, i);
			
			gp.setVgap(5.0);
			gp.setHgap(50.0);			
		
			gp.getChildren().add(lbId);
			gp.getChildren().add(lbNom);			
			
		}
		
		
		
		
		System.out.println(gp.getRowConstraints());
		//puis on met à jour les labels
		
			/*
		try {
		FXMLLoader loader2 = new FXMLLoader();
		loader2.setLocation(Main.class.getResource("view/viewListePiece.fxml"));
		AnchorPane root = (AnchorPane) loader2.load();
		ListePieceControlleur lpc = loader2.getController();
		
		Stage primaryStage = new Stage();

		Scene scene = new Scene(root);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		lpc.afficherListe();
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
	}
	

}
