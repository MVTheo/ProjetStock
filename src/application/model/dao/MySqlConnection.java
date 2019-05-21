package application.model.dao;

import java.sql.*;

//Classe unique permettant d'assurer la connexion à la base de données.
// Pas grand chose à changer ici, juste les paramètres de connexion.
// Le pattern singleton représenté ici permet de ne pas avoir à constamment
// créer des connexions vers la BDD. 
// vous pouvez vous passer de cette classe si vous vous connectez à chaque fois
// à la BDD dans les différents DAO.
public class MySqlConnection {
	
	/** * paramètres de connexion:  URL de connection et login, pass pour la BDD */
	/* A réutiliser tel quel, juste ces 3 paramètres à changer */
	private static String url = "jdbc:mysql://localhost/projetstock?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String user = "root";
	private static String passwd = "";

	/** * Objet Connection */
	private static Connection connect;

	/** * Méthode qui va nous retourner notre instance * et la créer si elle 	n'existe pas... * @return */
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
