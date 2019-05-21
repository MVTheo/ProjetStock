package application.model.dao;

import java.sql.*;

//Ma classe mère, abstraite, et template pour le DAO. Rien à toucher ici.
public abstract class DAO<T> {

	//Je récupère une instance de connexion grâce à la méthode statique getInstance()
	// de MySqlConnection (cf classe MySqlConnection)
    public Connection connect = MySqlConnection.getInstance();

    
    //Puis les méthodes "standard" pour le CRUD sur une entité.
    /** * Permet de récupérer un objet via son ID * @param id * @return */
    public abstract T find(long id);

    /** * Permet de créer une entrée dans la base de données * par rapport à un objet*/
    public abstract T create(T obj);

    /** * Permet de mettre à jour les données d'une entrée dans la base  */
    public abstract T update(T obj);

    /** * Permet la suppression d'une entrée de la base * @param obj */
    public abstract void delete(T obj);

}
