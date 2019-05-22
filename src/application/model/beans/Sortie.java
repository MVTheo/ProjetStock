package application.model.beans;

import java.util.ArrayList;


//Deuxième bean, cf bean Etudiant pour les commentaires
public class Sortie {
	
	private int id;
	private int quantite;
	private int pieceId;
	private ArrayList<Piece> listePiece;
	
	public Sortie() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getPieceId() {
		return pieceId;
	}

	public void setPieceId(int pieceId) {
		this.pieceId = pieceId;
	}

	public ArrayList<Piece> getListePiece() {
		return listePiece;
	}

	public void setListePiece(ArrayList<Piece> listePiece) {
		this.listePiece = listePiece;
	}


}

