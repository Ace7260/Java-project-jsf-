package DataCon;
import java.sql.*;
public class DataConnect {
	
	static Connection con=null;
	private static String rapporteur="";
	
	
	static void getIntance(){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Cashpower","root","");
			rapporteur="success";
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			rapporteur="ClassNotFoundException";
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rapporteur="SQLException";
		}
		
	}

	public static void main(String [] arg){
		getIntance();
		ResultSet result=extraire_DB("select person" +
				"neID,nom,prenom from personne limit 5");
		
		try {
			if(result!=null)
			while(result.next())
				System.out.println(result.getString("personneID")+","+result.getString("nom")+" "+result.getString("prenom"));
			else System.out.println(rapporteur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(rapporteur);
	}
	/*
	 * la suivante methode est utilisée pour interroger la base de donnée en lui passant
	 * le parametre de type select
	 */
	public static ResultSet extraire_DB(String requete){
		
		ResultSet result=null;
		Statement st=null;
		if(con==null)
			getIntance();
		if(con!=null){
			try {
				
				st=con.createStatement();
				result=st.executeQuery(requete);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
	/*
	 * La suite fonction est appellée quand on aura une requete commencant par
	 * insert, update, delete ,etc 
	 */
	public static int update_Bd(String requete){
	 	int nb=-1;
	    Statement st=null;	
	 	if(con==null)
	 		getIntance();
	 	if(con!=null)
	 	{
	 		try {
				st=con.createStatement();
				nb=st.executeUpdate(requete);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		
	 		
	 	}
	 	
		return nb;
	}

}
