package Poo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DataCon.DataConnect;

public class CashPower {
	
	private int id;  
    private String name; 
    private String surname;
    private String email;
    private Date date;
    private String number;
    private String password;
    private String typeCompteur;
    private String gender;  
    private String address;
    private String info;
    
    private List<CashPower> compteurListFromDB;
    
    /*Constucetur par defaut*/
    public CashPower(){
    	
    }
    
	/*Constructeur avec Id*/
	public CashPower(int id, String name, String surname, String email,
			Date date, String number, String password, String typeCompteur, String gender,
			String address) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.date = date;
		this.number = number;
		this.password = password;
		this.typeCompteur = typeCompteur;
		this.gender = gender;
		this.address = address;
	}

	
	/*Constructeur sans Id*/
	public CashPower(String name, String surname, String email, String number,
			Date date, String password, String typeCompteur, String gender, String address) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.date = date;
		this.number = number;
		this.password = password;
		this.typeCompteur = typeCompteur;
		this.gender = gender;
		this.address = address;
	}



	/*Les getters et setters*/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTypeCompteur() {
		return typeCompteur;
	}

	public void setTypeCompteur(String typeCompteur) {
		this.typeCompteur = typeCompteur;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<CashPower> getCompteurListFromDB() {
		return compteurListFromDB;
	}

	public void setCompteurListFromDB(List<CashPower> compteurListFromDB) {
		this.compteurListFromDB = compteurListFromDB;
	}
	
	/*Methode permettant d'afficher la liste des Etudiants*/
	public List<CashPower> getStudentsListFromDB() {
		
		ResultSet result=DataConnect.extraire_DB("select * from Cashpower;");
		
		if(compteurListFromDB==null)
			compteurListFromDB=new ArrayList<CashPower>();
		else compteurListFromDB.clear();
		if(result!=null){
			try {
				while(result.next()){
					compteurListFromDB.add(new CashPower(result.getInt("id"),result.getString("name"),result.getString("surname"),result.getString("email"),result.getDate("date"),result.getString("number"),result.getString("password"),result.getString("typeCompteur"),result.getString("gender"),
							result.getString("address")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return compteurListFromDB;
	}

	/*Methode permettant de creer les Etudiants*/
	public void creer_new_Customer(){
		
		int info=DataConnect.update_Bd("insert into cashtable ( name , surname , email , number , password , typeCompteur , gender, address) " +
	    			"values ('"+this.name+"','"+this.surname+"','"+this.email+"','"+this.date+"','"+this.number+"','"+this.password+"','"+this.typeCompteur+"','"+this.gender+"','"+this.address+"')");
		if(info>0){
    		this.setInfo("Operation reussie");
    	}
    	else{
    		this.setInfo("Operation echouée");
    	}
	}
	
	/*Methode permettant d'effacer un Etudiant*/
	public void deleteCustomerDB(int id){
		
		int info=DataConnect.update_Bd("delete from CashTable where student_id = "+id);
		
		if(info>0){
    		this.setInfo("Operation succed");
    	}
    	else{
    		this.setInfo("Operation Fallen");
    	}
	}

}
