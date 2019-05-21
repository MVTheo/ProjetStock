package application.model.beans;


//Ici je cr�e un premier bean Etudiant, relatif � la table Etudiant en BDD
public class Piece {
	
	//les attributs et les types de donn�es doivent correspondre aux colonnes
	private int id;
	private String nom;
	private int quantite;	

	//Je dois mettre un constructeur sans param�tre
	public Piece() {
		
	}
	
	//Puis les get/Set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}	
	
	//Je surcharge la m�thode toString qui va permettre de donner une description
	//lisible par un humain de l'objet instanci�.
	//Par d�faut c'est cette m�thode qui est appel�e pour transformer mon objet en chaine de caract�re (transtypage).
	
	

	@Override
	public String toString() {
		return "piece id=" + id + " : " + nom.toUpperCase() + " " + quantite;
	}
	
	

}
