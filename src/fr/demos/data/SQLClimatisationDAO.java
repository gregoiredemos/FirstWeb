package fr.demos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



import fr.demos.metier.Climatisation;

public class SQLClimatisationDAO implements ClimatisationDAO {

    private DataSource ds=null;
    public SQLClimatisationDAO() throws Exception{
    	
    	
    	// recherche dans l'annuaire du pool de conexions (utilisation de la librairie JNDI)
	Context context=new InitialContext();
	 ds= (DataSource)context.lookup("jdbc/appliclim");
    }
    
	@Override
	public void sauve(Climatisation cl) throws Exception {
		
		//On demande au connexion au pool
		
		Connection cx=ds.getConnection();
		
		//on va pouvoir preparer notre requ�te SQL
		PreparedStatement psmt=cx.prepareStatement("Insert into climatisation values(?,?,?,?,?)");
		
		//Statement stmt=cx.createStatement()
		//stmt.executeUpdate("insert into climatisation values ("
		
		psmt.setString(1,cl.getNomAppareil());
		psmt.setDouble(2,cl.getTemperature());
		psmt.setDouble(3,cl.getPression());
		psmt.setInt(4,cl.getTauxHumidite());
		psmt.setLong(5,cl.getDatation());
		psmt.executeUpdate();
		//on rend la conexion au pool
		cx.close();
		
	}

	@Override
	public List<Climatisation> rechercheTout() throws Exception {
		Connection cx=ds.getConnection();
		PreparedStatement psmt=cx.prepareStatement("select * from climatisation");
		ResultSet rs=psmt.executeQuery();
		ArrayList<Climatisation>liste=new ArrayList<>();
		while(rs.next()){
			
			String nomAppareil=rs.getString(1);
			double temperature=rs.getDouble(2);
			double pression =rs.getDouble(3);
			int tauxHumidite=rs.getInt(4);
			long datation=rs.getLong(5);
			Climatisation cl=new Climatisation(nomAppareil, temperature,pression,tauxHumidite);
			liste.add(cl);
			
		}
		
		
		return liste;
	}

	@Override
	public List<Climatisation> recherche(String critere) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombre(String critere) {
		 int nb=0;
		 try{
			 // peu performant: en sql on peut demander directement le nombre d'elements
			 List<Climatisation> liste=this.rechercheTout();
		 }catch(Exception e){
			
		 }
		 return nb; 
	}

}
