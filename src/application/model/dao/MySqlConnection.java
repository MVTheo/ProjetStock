package application.model.dao;

import java.sql.*;

//Classe unique permettant d'assurer la connexion � la base de donn�es.
// Pas grand chose � changer ici, juste les param�tres de connexion.
// Le pattern singleton repr�sent� ici permet de ne pas avoir � constamment
// cr�er des connexions vers la BDD. 
// vous pouvez vous passer de cette classe si vous vous connectez � chaque fois
// � la BDD dans les diff�rents DAO.
public class MySqlConnection {
	
	/** * param�tres de connexion:  URL de connection et login, pass pour la BDD */
	/* A r�utiliser tel quel, juste ces 3 param�tres � changer */
	private static String url = "jdbc:mysql://localhost/projetstock?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String user = "root";
	private static String passwd = "";

	/** * Objet Connection */
	private static Connection connect;

	/** * M�thode qui va nous retourner notre instance * et la cr�er si elle 	n'existe pas... * @return */
	public static Connection getInstance(){
	    if(connect == null){
		try {
		    connect = DriverManager.getConnection(url, user, passwd);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	    }
	    return connect;
	}


}
