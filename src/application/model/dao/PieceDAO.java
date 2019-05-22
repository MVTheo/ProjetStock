package application.model.dao;

import java.sql.*;
import java.util.ArrayList;

import application.model.beans.Piece;

//DAO (Data Access Object) pour le bean Etudiant.
/*
 * On va ranger dans cette classe tout le code permettant de faire le lient avec la table 
 * Etudiant dans notre base de donn�es. Pour cela, on va extensivement utiliser
 * notre bean Etudiant.
 * 
 * On va retrouver dans le DAO les m�thodes abstraites du template DAO<T>:
 * - find
 * - create
 * - update
 * - delete
 * 
 * On trouvera tr�s souvent plusieurs m�thodes find() qui permettront de faire des requ�tes diverses
 * (Select...) sur la BDD.
 * 
 */
public class PieceDAO extends DAO<Piece> {

	
	@Override
	public Piece find(long id) {
		
		Piece piece = new Piece();

		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from Piece where idPiece="+id);
			while (rs.next()) {
				int bd_id = rs.getInt("idPiece");
				String bd_nom = rs.getString("nom");
				int bd_quantite = rs.getInt("quantite");
				
				
				piece.setId(bd_id);				
				piece.setNom(bd_nom);
				piece.setQuantite(bd_quantite);	
				
			}
			return piece;
		}
		catch (Exception e) {
			System.out.println("PieceDAO: find() failed: "+e.getLocalizedMessage());
		}
		
		return null;
	}
	
	//deuxi�me m�thode find. Renvoie la liste des Etudiant portant le nom name.
	public ArrayList<Piece> findByName(String name){
		ArrayList<Piece> listPiece = new ArrayList<Piece>();
		
		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from Piece where nom like '"+name+"%"+"'");
			while (rs.next()) {
				
				Piece piece = new Piece();
				int bd_id = rs.getInt("idPiece");
				String bd_nom = rs.getString("nom");
				int bd_quantite = rs.getInt("quantite");
				
				
				piece.setId(bd_id);
				piece.setNom(bd_nom);
				piece.setQuantite(bd_quantite);	
				
				listPiece.add(piece);
			}
			
			return listPiece;
		}
		catch (Exception e) {
			System.out.println("PieceDAO: find() failed: "+e.getLocalizedMessage());
		}
		
		return null;
		
	}

	@Override
	public Piece create(Piece obj) {
		try {
			Statement stmt = connect.createStatement();
			
			
			stmt.execute("INSERT INTO Piece(nom, quantite) VALUES ('"+obj.getNom()+"','"+obj.getQuantite()+"')");
			
			
			// pour r�cup�rer l'objet que l'on vient d'ins�rer, cette fois avec l'ID auto-g�n�r�
			ResultSet rs = stmt.executeQuery("Select * from Piece");
			
			//Je me place sur la derni�re ligne
			rs.last();
			
			//Puis je fais comme avant (comme pour find() et findByName() )
			Piece piece = new Piece();
			int bd_id = rs.getInt("idPiece");
			String bd_nom = rs.getString("nom");
			int bd_quantite = rs.getInt("quantite");
			
			
			piece.setId(bd_id);
			piece.setNom(bd_nom);
			piece.setQuantite(bd_quantite);	
				
			return piece;
		
		}
		catch (Exception e) {
			System.out.println("PieceDAO: create() failed: "+e.getLocalizedMessage());
		}
		
		
		return null;
	}

	@Override
	public Piece update(Piece obj) {
		// TODO Auto-generated method stub
		try {
			Statement stmt = connect.createStatement();
			
			
			stmt.execute("Update Piece set nom = '" +obj.getNom() +"' , " + "quantite = '"+ obj.getQuantite()+"' WHERE idPiece = " +obj.getId() );
			
			
			// pour r�cup�rer l'objet que l'on vient d'ins�rer, cette fois avec l'ID auto-g�n�r�
			ResultSet rs = stmt.executeQuery("Select * from Piece");
			
			//Je me place sur la derni�re ligne
			rs.last();
			
			//Puis je fais comme avant (comme pour find() et findByName() )
			Piece piece = new Piece();
			int bd_id = rs.getInt("idPiece");
			String bd_nom = rs.getString("nom");
			int bd_quantite = rs.getInt("quantite");
			
			
			piece.setId(bd_id);
			piece.setNom(bd_nom);
			piece.setQuantite(bd_quantite);	
				
			return piece;
		
		}
		catch (Exception e) {
			System.out.println("PieceDAO: create() failed: "+e.getLocalizedMessage());
		}
		
		
		return null;
	}

	@Override
	public void delete(Piece obj) {
		try {
			Statement stmt = connect.createStatement();
			
			
			stmt.execute("Delete From Piece WHERE idPiece = " +obj.getId() );
			
						
			
		}
		catch (Exception e) {
			System.out.println("PieceDAO: create() failed: "+e.getLocalizedMessage());
		}
		
		
		
		
		// TODO Auto-generated method stub
		
	}

}
