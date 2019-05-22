package application.model.beans;

import java.sql.Date;

//Ici je crée un premier bean Etudiant, relatif à la table Etudiant en BDD
public class PieceAudit {
	
	//les attributs et les types de données doivent correspondre aux colonnes
	private int id;
	private String Operation;
	private int pieceId;	
	private String pieceName;
	private int QuantiteRestante;
	private int QuantiteEnlever;
	private Date temps;
	
	//Je dois mettre un constructeur sans paramètre
	public PieceAudit() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperation() {
		return Operation;
	}

	public void setOperation(String operation) {
		Operation = operation;
	}

	public int getPieceId() {
		return pieceId;
	}

	public void setPieceId(int pieceId) {
		this.pieceId = pieceId;
	}

	public String getPieceName() {
		return pieceName;
	}

	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}

 
	public int getQuantiteEnlever() {
		return QuantiteEnlever;
	}

	public void setQuantiteEnlever(int quantiteEnlever) {
		QuantiteEnlever = quantiteEnlever;
	}

	public Date getTemps() {
		return temps;
	}

	public void setTemps(Date temps) {
		this.temps = temps;
	}

	public int getQuantiteRestante() {
		return QuantiteRestante;
	}

	public void setQuantiteRestante(int quantiteRestante) {
		QuantiteRestante = quantiteRestante;
	}
	
	
	
	//Je surcharge la méthode toString qui va permettre de donner une description
	//lisible par un humain de l'objet instancié.
	//Par défaut c'est cette méthode qui est appelée pour transformer mon objet en chaine de caractère (transtypage).
	
	
/*
	@Override
	public String toString() {
		return "pieceAudit id=" + id + " : " + nom.toUpperCase() + " " + quantite;
	}
	
	*/

}
