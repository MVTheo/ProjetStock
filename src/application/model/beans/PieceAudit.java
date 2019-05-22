package application.model.beans;

import java.sql.Date;

//Ici je cr�e un premier bean Etudiant, relatif � la table Etudiant en BDD
public class PieceAudit {
	
	//les attributs et les types de donn�es doivent correspondre aux colonnes
	private int id;
	private String Operation;
	private int pieceId;	
	private String pieceName;
	private int QuantiteRestante;
	private int QuantiteEnlever;
	private Date temps;
	
	//Je dois mettre un constructeur sans param�tre
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
	
	
	
	//Je surcharge la m�thode toString qui va permettre de donner une description
	//lisible par un humain de l'objet instanci�.
	//Par d�faut c'est cette m�thode qui est appel�e pour transformer mon objet en chaine de caract�re (transtypage).
	
	
/*
	@Override
	public String toString() {
		return "pieceAudit id=" + id + " : " + nom.toUpperCase() + " " + quantite;
	}
	
	*/

}
