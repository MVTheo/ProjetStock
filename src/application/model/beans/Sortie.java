package application.model.beans;

import java.util.ArrayList;


//Deuxième bean, cf bean Etudiant pour les commentaires
public class Sortie {
	
	private String id;
	private int quantite;
	private ArrayList<Piece> listePiece;
	
	public Sortie() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public int getNbMaxEtudiants() {
		return quantite;
	}
	public void setNbMaxEtudiants(int nbMaxEtudiants) {
		this.quantite = nbMaxEtudiants;
	}


	public ArrayList<Piece> getListeEtudiants() {
		return listePiece;
	}

	public void setListeEtudiants(ArrayList<Piece> listeEtudiants) {
		this.listePiece = listeEtudiants;
	}
	
	public Piece getFromIndex(int index) {
		return listePiece.get(index);
	}
	
	public void addEtudiant(Piece e) {
		listePiece.add(e);
	}
	
	

}

