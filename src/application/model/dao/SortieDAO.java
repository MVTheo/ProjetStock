package application.model.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import application.model.beans.Piece;
import application.model.beans.Sortie;

public class SortieDAO extends DAO<Sortie>{

	@Override
	public Sortie find(long id) {
		
		return null;
	}
	
	public Sortie find(String id) {
		return null;
	}

	@Override
	public Sortie create(Sortie obj) {
		try {
			Statement stmt = connect.createStatement();
			
			
			
			stmt.execute("INSERT INTO Sortie(nbPiece, Piece_idPiece) VALUES ('"+obj.getQuantite()+"','"+obj.getPieceId()+"')");
			
			
			// pour r�cup�rer l'objet que l'on vient d'ins�rer, cette fois avec l'ID auto-g�n�r�
			
			
			
		
		}
		catch (Exception e) {
			System.out.println("PieceDAO: create() failed: "+e.getLocalizedMessage());
		}
		
		
		return null;
	}

	@Override
	public Sortie update(Sortie obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Sortie obj) {
		// TODO Auto-generated method stub
		
	}

}
