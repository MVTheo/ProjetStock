package application.model.beans;


//Ici je crée un premier bean Etudiant, relatif à la table Etudiant en BDD
public class Piece {
	
	//les attributs et les types de données doivent correspondre aux colonnes
	private int id;
	private String nom;
	private int quantite;	

	//Je dois mettre un constructeur sans paramètre
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
	
	//Je surcharge la méthode toString qui va permettre de donner une description
	//lisible par un humain de l'objet instancié.
	//Par défaut c'est cette méthode qui est appelée pour transformer mon objet en chaine de caractère (transtypage).
	
	

	@Override
	public String toString() {
		return "piece id=" + id + " : " + nom.toUpperCase() + " " + quantite;
	}
	
	

}
