package RPG;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @authors Lebas Yaël & Mugisha Rodrigue
 * 
 * Classe permettant la sauvegarde et reprise de la progression de l'utilisateur.
 *
 */
public class GameDB {
	
	
	/**
     * Méthode permettant d'enregistrer un personnage dans une base de données.
     * 
     * @param p Personnage dont on enregistre l'entière des attributs.
     *
     */
	public void EnregisterEnDB(Personnage p){
		String url = "jdbc:mysql://192.168.1.2/test1";
		String login = "root";
		String passwd = "root";
		Connection cn = null;
		Statement st = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			st = cn.createStatement();
			String sql = "INSERT INTO javadb (username,niveau,exp,expLvlUp,croissanceExp,etat,hp,hpMax,croissanceHp,nbPieces,attaque,croissanceAttaque,defense,croissanceDefense,mana,maxMana,croissanceMana,posX,posY,classe) VALUES ('"
							+ p.getUsername() +"','"+p.getNiveau()+"','"+p.getExp()+"','"+p.getExpLvlUp()+"','"+p.getCroissanceExp()+"','"+p.getEtat()+"','"+p.getHp()+"','"+p.getHpMax()+"','"+p.getCroissanceHp()+
							"','"+p.getNbPieces()+"','"+p.getAttaque()+"','"+p.getCroissanceAttaque()+"','"+p.getDefense()+"','"+p.getCroissanceDefense()+"','"+p.getMana()+"','"+p.getMaxMana()+"','"+p.getCroissanceMana()+"','"+p.getPosX()+"','"+p.getPosY()+"','"+p.getClass()+"')";
			
			String sql2 = "INSERT INTO arme (type,niveau,classe) VALUES ('"+p.getArme().getType()+"','"+p.getArme().getNiveau()+"','"+p.getArme().getClass()+"')";
			String sql3 = "INSERT INTO armure (type,niveau,classe) VALUES ('"+p.getArmure().getType()+"','"+p.getArmure().getNiveau()+"','"+p.getArmure().getClass()+"')";
			
			st.executeUpdate(sql);
			st.executeUpdate(sql2);
			st.executeUpdate(sql3);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
				st.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
     * Méthode permettant la sauvegarde des données d'un personnage basée sur le nom d'utilisateur. Si le personnage existe déjà en DB, on écrase les précédentes données
     * et on met à jour dans la colonne au nom d'utilisateur correspondant.
     * 
     * @param username nom d'utilisateur
     * @param p Personnage dont on sauvegarde les données.
     *
     */
	public void save(String username,Personnage p) {
		String url = "jdbc:mysql://192.168.1.2/test1";
		String login = "root";
		String passwd = "root";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			st = cn.createStatement();
			String sql = "SELECT * FROM javadb WHERE username = " + username ;
			String sql2 = "UPDATE javadb SET niveau = '"+p.getNiveau()+"', exp = '"+p.getExp()+"', expLvlUp = '"+p.getExpLvlUp()+"', croissanceExp = '"+p.getCroissanceExp()+"', etat = '"+p.getEtat()+"', hp = '"+p.getHp()+"', hpMax = '"+p.getHpMax()+"'"+
					", croissanceHp = '"+p.getCroissanceHp()+"', nbPieces = '"+p.getNbPieces()+"', attaque = '"+p.getAttaque()+"', croissanceAttaque = '"+p.getCroissanceAttaque()+"', defense = '"+p.getDefense()+"', croissanceDefense = '"+p.getCroissanceDefense()+"', mana = '"+p.getMana()+"'"+
					", maxMana = '"+p.getMaxMana()+"', croissanceMana = '"+p.getCroissanceMana()+"', posX = '"+p.getPosX()+"', posY = '"+p.getPosY()+"', classe = '"+p.getClass()+"' WHERE username = "+ username;
			String sql3 = "UPDATE arme SET type = '"+p.getArme().getType()+"', niveau = '"+p.getArme().getNiveau()+"', classe = '"+p.getArme().getClass()+"', name = '"+p.getUsername()+"' WHERE name = "+ username;
			String sql4 = "UPDATE armure SET type = '"+p.getArmure().getType()+"', niveau = '"+p.getArmure().getNiveau()+"', classe = '"+p.getArmure().getClass()+"', name = '"+p.getUsername()+"' WHERE name = "+ username;;
			
			rs = st.executeQuery(sql);
			 if(rs.next() ) {
				 st.executeUpdate(sql2);
				 st.executeUpdate(sql3);
				 st.executeUpdate(sql4);
				 System.out.println("Ecrasement des données précédentes et Sauvegarde de la partie");
			 }
			 else {
				 EnregisterEnDB(p);
			 }
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
				st.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
     * Méthode permettant le chargement des données d'un personnage basée sur le nom d'utilisateur. 
     * On récupère sa classe qui a été sauvegarder auparavant en DB pour ensuite recréer l'objet avec ses données.
     * 
     * @param username nom d'utilisateur
     * @param p Nouvel instance qu'on utilise pour recréer l'objet Personnage en se basant sur la classe sauvé en DB.
     *
     */
	public Personnage lireEnDB(String username, Personnage p){
		String url = "jdbc:mysql://192.168.1.2/test1";
		String login = "root";
		String passwd = "root";
		Connection cn = null;
		Statement st = null;
		Statement st1 = null;
		Statement st2 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,passwd);
			st = cn.createStatement();
			st1 = cn.createStatement();
			st2 = cn.createStatement();
			
			String sql = "SELECT * FROM javadb WHERE username = " + username ;
			String sql2 = "SELECT * FROM arme WHERE name = " + username;
			String sql3 = "SELECT * FROM armure WHERE name = " + username;
			
			rs = st.executeQuery(sql);
			rs1 = st1.executeQuery(sql2);
			rs2 = st2.executeQuery(sql3);
			
			while(rs.next() && rs1.next() && rs2.next()) {
				switch(rs.getString("classe")) {
				case "class RPG.Assassin": 
					p = new Assassin(rs.getString("username"));
					p.setNiveau(rs.getInt("niveau"));
					p.setExp(rs.getInt("exp"));
					p.setExpLvlUp(rs.getInt("expLvlUp"));
					p.setCroissanceExp(rs.getInt("croissanceExp"));
					p.setEtat(rs.getString("etat"));
					p.setHp(rs.getInt("hp"));
					p.setHpMax(rs.getInt("hpMax"));
					p.setCroissanceHp(rs.getInt("croissanceHp"));
					p.setNbPieces(rs.getInt("nbPieces"));
					p.setAttaque(rs.getInt("attaque"));
					p.setCroissanceAttaque(rs.getInt("croissanceAttaque"));
					p.setDefense(rs.getInt("defense"));
					p.setMana(rs.getInt("mana"));
					p.setMaxMana(rs.getInt("maxMana"));
					p.setCroissanceMana(rs.getInt("croissanceMana"));
					p.setPosX(rs.getInt("posX"));
					p.setPosY(rs.getInt("posY"));
					p.setArme(new Arme(rs1.getString("type"),rs1.getInt("niveau")));
					p.setArmure(new Armure(rs2.getString("type"),rs2.getInt("niveau")));
					break;
				case "class RPG.Aventurier":
					p = new Aventurier(rs.getString("username"));
					p.setNiveau(rs.getInt("niveau"));
					p.setExp(rs.getInt("exp"));
					p.setExpLvlUp(rs.getInt("expLvlUp"));
					p.setCroissanceExp(rs.getInt("croissanceExp"));
					p.setEtat(rs.getString("etat"));
					p.setHp(rs.getInt("hp"));
					p.setHpMax(rs.getInt("hpMax"));
					p.setCroissanceHp(rs.getInt("croissanceHp"));
					p.setNbPieces(rs.getInt("nbPieces"));
					p.setAttaque(rs.getInt("attaque"));
					p.setCroissanceAttaque(rs.getInt("croissanceAttaque"));
					p.setDefense(rs.getInt("defense"));
					p.setMana(rs.getInt("mana"));
					p.setMaxMana(rs.getInt("maxMana"));
					p.setCroissanceMana(rs.getInt("croissanceMana"));
					p.setPosX(rs.getInt("posX"));
					p.setPosY(rs.getInt("posY"));
					p.setArme(new Arme(rs1.getString("type"),rs1.getInt("niveau")));
					p.setArmure(new Armure(rs2.getString("type"),rs2.getInt("niveau")));
					break;
				case "class RPG.Mage":
					p = new Mage(rs.getString("username"));
					p.setNiveau(rs.getInt("niveau"));
					p.setExp(rs.getInt("exp"));
					p.setExpLvlUp(rs.getInt("expLvlUp"));
					p.setCroissanceExp(rs.getInt("croissanceExp"));
					p.setEtat(rs.getString("etat"));
					p.setHp(rs.getInt("hp"));
					p.setHpMax(rs.getInt("hpMax"));
					p.setCroissanceHp(rs.getInt("croissanceHp"));
					p.setNbPieces(rs.getInt("nbPieces"));
					p.setAttaque(rs.getInt("attaque"));
					p.setCroissanceAttaque(rs.getInt("croissanceAttaque"));
					p.setDefense(rs.getInt("defense"));
					p.setMana(rs.getInt("mana"));
					p.setMaxMana(rs.getInt("maxMana"));
					p.setCroissanceMana(rs.getInt("croissanceMana"));
					p.setPosX(rs.getInt("posX"));
					p.setPosY(rs.getInt("posY"));
					p.setArme(new Arme(rs1.getString("type"),rs1.getInt("niveau")));
					p.setArmure(new Armure(rs2.getString("type"),rs2.getInt("niveau")));
					break;
				default:   System.out.println ("Classe Introuvable");
					p = null;
	             	break;
				}
			}
			
			}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
				st.close();
				st1.close();
				st2.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
}
