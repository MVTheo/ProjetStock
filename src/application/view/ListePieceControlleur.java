package application.view;


import java.util.ArrayList;
import java.util.function.UnaryOperator;

import application.Main;
import application.model.beans.Piece;
import application.model.beans.Sortie;
import application.model.dao.PieceDAO;
import application.model.dao.SortieDAO;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class ListePieceControlleur {
	
	//rappel: besoin de @FXML pour faire le lien dans le fichier fxml
	@FXML
	private Label label1;
	
	@FXML
	private Label label2;
	
	@FXML
	private Label label3;
	
	@FXML
	private Label erreur;
	
	@FXML
	private TextField tf;
		
	@FXML
	private ScrollPane spA;
	
	@FXML
	private ScrollPane spS;
	
	@FXML
	private Button valider;
	
	private int colonne=0;
	private GridPane gp;
	private GridPane gpSortie;
	int indexSortie=0;
	
	//private ObservableList<Piece> pieceData = FXCollections.observableArrayList();
	ArrayList<Piece> p;
	ArrayList<Piece> listSortie = new ArrayList<Piece>();
	ArrayList<TextField> text = new ArrayList<TextField>();
	ArrayList<Sortie> sortieL = new ArrayList<Sortie>();
	PieceDAO pdao;
	
	public void intialize() {
		pdao = new PieceDAO();	
		
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
		int nbId = p.get(index).getId();
		String id = String.valueOf(p.get(index).getId());
		String nom = String.valueOf(p.get(index).getNom());
		//System.out.println("1 : "+listSortie.contains(p.get(index)));
		if (!listSortie.contains(p.get(index))) {
			Label lbId = new Label(id);
			Label lbNom = new Label(nom);
			TextField tfQauntite = new TextField();
			
			Button Delete = new Button("Supprimer");
			
			UnaryOperator<TextFormatter.Change> filter = new UnaryOperator<TextFormatter.Change>() {

	            @Override
	            public TextFormatter.Change apply(TextFormatter.Change t) {

	                if (t.isReplaced()) 
	                    if(t.getText().matches("[^0-9]"))
	                        t.setText(t.getControlText().substring(t.getRangeStart(), t.getRangeEnd()));
	                

	                if (t.isAdded()) {
	                    if (t.getText().matches("[^0-9]")) {
	                        t.setText("");
	                    }
	                }

	                return t;
	            }
	        };
			
			tfQauntite.setTextFormatter(new TextFormatter<>(filter));
			
			
			
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
			text.add(tfQauntite);
			System.out.println(listSortie);
			Delete.setOnAction(event -> supprimer(nbId, lbId, lbNom, tfQauntite, Delete));
			colonne++;
					
		}
		//String quantite = String.valueOf(p.get(index).getQuantite());
		
	}
	
	public void supprimer(int Id, Label lbId, Label lbNom, TextField tfQauntite, Button Delete) {
		int index= 0;
		gpSortie.getChildren().remove(lbId);
		gpSortie.getChildren().remove(lbNom);
		gpSortie.getChildren().remove(tfQauntite);
		gpSortie.getChildren().remove(Delete);
		
		for (int i =0; i<listSortie.size(); i++) {
			if (listSortie.get(i).getId() == Id) {
				index=i;
			}			
		}
		
		listSortie.remove(index);
		text.remove(index);
		colonne--;
		System.out.println(listSortie);
		
	}
	
	public void supprimerTout(int Id, Label lbId, Label lbNom, TextField tfQauntite, Button Delete) {
		//int index= 0;
		gpSortie.getChildren().remove(lbId);
		gpSortie.getChildren().remove(lbNom);
		gpSortie.getChildren().remove(tfQauntite);
		gpSortie.getChildren().remove(Delete);
		for (int i =0; i<listSortie.size(); i++) {
			listSortie.remove(i);
			text.remove(i);
			
			colonne--;		
		}
		
		
		System.out.println(listSortie);
		
	}
	
	public void valider()
	{
		Boolean OK=false;
		SortieDAO sdao = new SortieDAO();	
		for(int i = 0; i<listSortie.size(); i++) {
			
			//sortieL.add(e)
			Sortie sortie = new Sortie();
			//Piece piece = new Piece();
			if( text.get(i).getText().isEmpty()) {
				erreur.setText("Veuillez indiqué une quantité !");
			}
			else {
				int q = Integer.valueOf(text.get(i).getText());
				sortie.setQuantite(q);
				sortie.setPieceId(listSortie.get(i).getId());
				if (sortie.getQuantite()>p.get(i).getQuantite()) {
					System.out.println("Valeur trop haute pour : "+listSortie.get(i).getNom());
					erreur.setText("Valeur trop haute pour : "+listSortie.get(i).getNom());
				}
				else {
					sdao.create(sortie);
					System.out.println(sortie);
					listSortie.get(i).setQuantite(listSortie.get(i).getQuantite()-q);
					pdao.update(listSortie.get(i));					
					erreur.setText("Succès !");
					afficherListe();
					OK=true;
				}						
			}
		}
		if(OK) {
			listSortie.clear();
			text.clear();
			gpSortie.getChildren().clear();	
		}
			
	}
	
	public void afficherHistorique() {
		try {
			FXMLLoader loader2 = new FXMLLoader();
			loader2.setLocation(Main.class.getResource("view/viewPiece.fxml"));
			AnchorPane root = (AnchorPane) loader2.load();
			PieceController lpc = loader2.getController();
			
			Stage primaryStage = new Stage();

			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			lpc.intialize();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
	}
	
	
	
}
