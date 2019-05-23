package application.model.dao;

import java.sql.*;
import java.util.ArrayList;

import application.model.beans.Piece;
import application.model.beans.PieceAudit;

//DAO (Data Access Object) pour le bean Etudiant.
/*
 * On va ranger dans cette classe tout le code permettant de faire le lient avec la table 
 * Etudiant dans notre base de données. Pour cela, on va extensivement utiliser
 * notre bean Etudiant.
 * 
 * On va retrouver dans le DAO les méthodes abstraites du template DAO<T>:
 * - find
 * - create
 * - update
 * - delete
 * 
 * On trouvera très souvent plusieurs méthodes find() qui permettront de faire des requêtes diverses
 * (Select...) sur la BDD.
 * 
 */
public class PieceAuditDAO extends DAO<Piece> {

	
	@Override
	public Piece find(long id) {
		
		
		
		return null;
	}
	
	//deuxième méthode find. Renvoie la liste des Etudiant portant le nom name.
	public ArrayList<PieceAudit> findByName(String name){
		ArrayList<PieceAudit> listPiece = new ArrayList<PieceAudit>();
		
		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from piece_audit where piece_name like '"+name+"%"+"' ORDER BY id DESC");
			while (rs.next()) {
				
				PieceAudit piece = new PieceAudit();
				int bd_id = rs.getInt("id");
				String bd_operation = rs.getString("operation");
				int bd_piece_id = rs.getInt("piece_id");
				String bd_piece_name = rs.getString("piece_name");
				int bd_QuantiteRestante = rs.getInt("QuantiteRestante");
				int bd_QuantiteEnlever = rs.getInt("QuantiteEnelever");
				Date bd_date = rs.getDate("temps");
				
				piece.setId(bd_id);
				piece.setOperation(bd_operation);
				piece.setPieceId(bd_piece_id);
				piece.setPieceName(bd_piece_name);
				piece.setQuantiteRestante(bd_QuantiteRestante);
				piece.setQuantiteEnlever(bd_QuantiteEnlever);
				piece.setTemps(bd_date);
				
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Piece update(Piece obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Piece obj) {
		// TODO Auto-generated method stub
		
	}
}
