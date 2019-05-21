package application.model.dao;

import java.sql.*;

//Ma classe m�re, abstraite, et template pour le DAO. Rien � toucher ici.
public abstract class DAO<T> {

	//Je r�cup�re une instance de connexion gr�ce � la m�thode statique getInstance()
	// de MySqlConnection (cf classe MySqlConnection)
    public Connection connect = MySqlConnection.getInstance();

    
    //Puis les m�thodes "standard" pour le CRUD sur une entit�.
    /** * Permet de r�cup�rer un objet via son ID * @param id * @return */
    public abstract T find(long id);

    /** * Permet de cr�er une entr�e dans la base de donn�es * par rapport � un objet*/
    public abstract T create(T obj);

    /** * Permet de mettre � jour les donn�es d'une entr�e dans la base  */
    public abstract T update(T obj);

    /** * Permet la suppression d'une entr�e de la base * @param obj */
    public abstract void delete(T obj);

}
