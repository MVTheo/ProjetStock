package application.view;


import java.util.ArrayList;

import application.model.beans.Piece;
import application.model.beans.Sortie;
import application.model.dao.PieceDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ListePieceControlleur {
	
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
	private ScrollPane spA;
	
	@FXML
	private ScrollPane spS;
	
	private int colonne=0;
	private GridPane gp;
	private GridPane gpSortie;
	
	//private ObservableList<Piece> pieceData = FXCollections.observableArrayList();
	ArrayList<Piece> p;
	ArrayList<Piece> listSortie = new ArrayList<Piece>();
	
	public void intialize() {
		gp = new GridPane();		
		spA.setContent(gp);
		
		gpSortie = new GridPane();		
		spS.setContent(gpSortie);
		
		afficherListe();
	}

	//Méthode publique permettant, à partir d'un objet, de me remplir les bons label sur l'interface
	public void fillView(Piece p) {
		String quantite = String.valueOf(p.getQuantite());
		label1.setText(p.getNom());
		label2.setText(quantite);		
	}		

	
	public void afficherListe() {
		gp.getChildren().clear();
		System.out.println("plop");
		
		
		PieceDAO pdao = new PieceDAO();	
		
		//on utilise le DAO pour aller chercher le bon objet Etudiant,
		String name = tf.getText();
		
		if (name.isEmpty()) {
			p = pdao.findByName("");
		}else  {
			p = pdao.findByName(name);
		}
		
		
		
		int taille = p.size();
		for(int i=0; i<taille; i++) {
			int index = i;
			String id = String.valueOf(p.get(i).getId());
			String nom = String.valueOf(p.get(i).getNom());
			String quantite = String.valueOf(p.get(i).getQuantite());
			Label lbId = new Label(id);
			Label lbNom = new Label(nom);
			Label lbQauntite = new Label(quantite);
			Button bt = new Button();	
			bt.setOnAction(event -> ajouter (index));
			bt.setText("Ajouter");			
			GridPane.setConstraints(bt, 0, i);
			GridPane.setConstraints(lbId, 1, i);			
			GridPane.setConstraints(lbNom, 2, i);
			GridPane.setConstraints(lbQauntite, 3, i);
			gp.setVgap(5.0);
			gp.setHgap(50.0);			
			gp.getChildren().add(bt);
			gp.getChildren().add(lbId);
			gp.getChildren().add(lbNom);
			gp.getChildren().add(lbQauntite);
			
		}
		
		
		
		
		System.out.println(gp.getRowConstraints());
		//puis on met à jour les labels
		
				
	}
	
	public void ajouter (int index) {
		String id = String.valueOf(p.get(index).getId());
		String nom = String.valueOf(p.get(index).getNom());
		//String quantite = String.valueOf(p.get(index).getQuantite());
		Label lbId = new Label(id);
		Label lbNom = new Label(nom);
		TextField tfQauntite = new TextField();
		Button Delete = new Button("Supprimer");
		Delete.setOnAction(event -> supprimer(index));
		gpSortie.setHgap(5);
		gpSortie.setVgap(5);
	
		GridPane.setConstraints(lbId, 0, colonne);
		GridPane.setConstraints(lbNom, 1, colonne);
		GridPane.setConstraints(tfQauntite,2, colonne);
		GridPane.setConstraints(Delete,3 , colonne);
		gpSortie.setVgap(5.0);
		gpSortie.setHgap(50.0);
		gpSortie.getChildren().add(lbId);
		gpSortie.getChildren().add(lbNom);
		gpSortie.getChildren().add(tfQauntite);
		gpSortie.getChildren().add(Delete);
		listSortie.add(p.get(index));
		System.out.println(listSortie);
		colonne++;
	}
	
	public void supprimer(int index) {
		System.out.println("del");
		gpSortie.getChildren().remove
	}
}
