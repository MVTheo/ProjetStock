package application.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

import application.Main;
import application.model.beans.Piece;
import application.model.dao.PieceDAO;
import javafx.application.Application;

public class PieceController extends Main {
	//rappel: besoin de @FXML pour faire le lien dans le fichier fxml
	@FXML
	private Label label1;
	
	@FXML
	private Label label2;
	
	@FXML
	private Label label3;
	
	@FXML
	private TextField tf;
	
	@FXML
	private VBox vb;
	
	
	public PieceController() {
		
	}

	//Méthode publique permettant, à partir d'un objet étudiant, de me remplir les bons label sur l'interface
	public void fillView(Piece p) {
		String quantite = String.valueOf(p.getQuantite());
		label1.setText(p.getNom());
		label2.setText(quantite);		
	}
	
	//réaction au clic sur le bouton: on va chercher l'id demandé par l'utilisateur dans le textfield,
	//on utilise le DAO pour aller chercher le bon objet Etudiant,
	//puis on met à jour les labels
	
	
	public void onButtonClicked() {
		System.out.println("plop");
		
		
		//on va chercher l'id demandé par l'utilisateur dans le textfield,
		//int num = Integer.valueOf(tf.getText());
		String nom = tf.getText();
		
		//on utilise le DAO pour aller chercher le bon objet Etudiant,
		PieceDAO pdao = new PieceDAO();
		Piece p = pdao.findByName(nom).get(0);
		
		
		System.out.println(p);
		//puis on met à jour les labels
		this.fillView(p);
				
	}
	
	public void afficherListe() {
		
		/*
		System.out.println("plop");
		
		
		//on va chercher l'id demandé par l'utilisateur dans le textfield,
		//int num = Integer.valueOf(tf.getText());		
		
		//on utilise le DAO pour aller chercher le bon objet Etudiant,
		
		PieceDAO pdao = new PieceDAO();
		ArrayList<Piece> p = pdao.findByName("");
		int taille = p.size();
		for(int i=0; i<taille; i++) {
			String champ = String.valueOf(p.get(i));
			Label lb = new Label(champ);
			vb.getChildren().add(lb);
						
		}
		
		System.out.println(p);
		//puis on met à jour les labels
		
				*/
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
	}
	

}
