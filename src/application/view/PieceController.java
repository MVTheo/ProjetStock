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
	
	

	//M�thode publique permettant, � partir d'un objet �tudiant, de me remplir les bons label sur l'interface
	
	

	
	
	
	public void afficherListe() {
		
		gp.getChildren().clear();
		System.out.println("plop");		
		
		//on utilise le DAO pour aller chercher le bon objet Etudiant,
		
		
		
			pa = padao.findByName("");	
			
				
		int taille = pa.size();
		for(int i=0; i<taille; i++) {
			
			String id = String.valueOf(pa.get(i).getId());
			String Operation = String.valueOf(pa.get(i).getOperation());
			String name = String.valueOf(pa.get(i).getPieceName());
			String QuantiteEnlever = String.valueOf(pa.get(i).getQuantiteEnlever());
			String QuantiteRestante = String.valueOf(pa.get(i).getQuantiteRestante());
			String date = String.valueOf(pa.get(i).getTemps());
			
			Label lbId = new Label(id);
			Label lbOperation = new Label(Operation);
			Label lbName = new Label(name);
			Label lbQuantiteEnlever = new Label(QuantiteEnlever);
			Label lbQuantiteRestante = new Label(QuantiteRestante);
			Label lbDate = new Label(date);
			
	
			GridPane.setConstraints(lbId, 0, i);			
			GridPane.setConstraints(lbOperation, 1, i);
			GridPane.setConstraints(lbName, 2, i);
			GridPane.setConstraints(lbQuantiteEnlever, 3, i);
			GridPane.setConstraints(lbQuantiteRestante, 4, i);
			GridPane.setConstraints(lbDate, 5, i);
			
			gp.setVgap(5.0);
			gp.setHgap(50.0);			
		
			gp.getChildren().add(lbId);
			gp.getChildren().add(lbOperation);	
			gp.getChildren().add(lbName);	
			gp.getChildren().add(lbQuantiteEnlever);	
			gp.getChildren().add(lbQuantiteRestante);	
			gp.getChildren().add(lbDate);	
			
		}
		
		
		
		
		System.out.println(gp.getRowConstraints());
		//puis on met � jour les labels
		
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
