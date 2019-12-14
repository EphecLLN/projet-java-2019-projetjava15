package RPG;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.Statement;


public class GameDB {
	
	public void sauverEnDB(Personnage p){
		String url = "jdbc:mysql://localhost/test1";
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
			
			st.executeUpdate(sql);
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
	
	public Personnage lireEnDB(String username, Personnage p){
		String url = "jdbc:mysql://localhost/test1";
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
			rs = st.executeQuery(sql);
		
			
			while(rs.next()) {
				switch(rs.getString("classe")) {
				case "class RPG.Assassin": 
					p = new Assassin(rs.getString("username"));
					p.setNiveau(rs.getInt("niveau"));
					p.setExp(rs.getInt("exp"));
					p.setExpLvlUp(rs.getInt("niveau"));
					p.setCroissanceExp(rs.getInt("niveau"));
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
					break;
				case "class RPG.Aventurier":
					p = new Aventurier(rs.getString("username"));
					p.setNiveau(rs.getInt("niveau"));
					p.setExp(rs.getInt("exp"));
					p.setExpLvlUp(rs.getInt("niveau"));
					p.setCroissanceExp(rs.getInt("niveau"));
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
					break;
				case "class RPG.Mage":
					p = new Mage(rs.getString("username"));
					p.setNiveau(rs.getInt("niveau"));
					p.setExp(rs.getInt("exp"));
					p.setExpLvlUp(rs.getInt("niveau"));
					p.setCroissanceExp(rs.getInt("niveau"));
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
					break;
				default:   System.out.println ("Classe Introuvable");
					p = null;
	             	break;    //i want to show exception error here
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
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
}
