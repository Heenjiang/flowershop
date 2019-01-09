package dao;

import java.sql.Connection;
import java.util.ArrayList;

import entity.Bouquet;
import entity.Flower;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbOperation {
	private DBUtil dbtool = new	DBUtil();
	private Connection con ;
	private ResultSet result = null;
	public DbOperation() {
	}
	
	public ArrayList<Flower> getAllFlowers(){
		String querySql = "select * from  flowers";
		 con = dbtool.getConnection();
		ArrayList<Flower> AllFlowers = new	ArrayList<Flower>();
		try {
			PreparedStatement parment = con.prepareStatement(querySql);
			result = parment.executeQuery();
			while(result.next()) {
				Flower flower = new Flower();
				flower.setId(result.getInt(1));
				flower.setName(result.getString(2));
				flower.setColor(result.getString(3));
				flower.setFreshness(result.getString(4));
				flower.setRhizomelength(result.getDouble(5));
				flower.setPrice(result.getDouble(6));
				flower.setP_id(result.getInt(7));
				System.out.println(flower.toString());
				AllFlowers.add(flower);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return AllFlowers;
	}
	public boolean addFlower(Flower flower) {
		 con = dbtool.getConnection();
		String insertSql = "insert into flowers(name,color,freshness,rhizomelength,price,p_id) values(?,?,?,?,?,?)";
		try {
			PreparedStatement parment = con.prepareStatement(insertSql);
			parment.setString(1, flower.getName());
			parment.setString(2, flower.getColor());
			parment.setString(3, flower.getFreshness());
			parment.setDouble(4, flower.getRhizomelength());
			parment.setDouble(5, flower.getPrice());
			parment.setInt(6, flower.getP_id());
			parment.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	public Bouquet getBouquetFlowers(Integer id) {
		 con = dbtool.getConnection();
		String querySql = "select * from  bouquet where id = ?";
		Bouquet bouquet = null;
		try {
			PreparedStatement parment = con.prepareStatement(querySql);
			parment.setInt(id, 1);
			result = parment.executeQuery();
			while(result.next()) {
				bouquet = new Bouquet();
				bouquet.setId(result.getInt(1));
				bouquet.setNumOfFlower(result.getInt(2));
				bouquet.setTotalPrice(result.getDouble(3));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bouquet;
		
	}
	public ArrayList<Flower> getAllFlowersByBouquet(Bouquet bouquet){
		con = dbtool.getConnection();
		String querySql = "select * from  flowers where p_id = " + bouquet.getId();
		System.out.println(querySql);
		ArrayList<Flower> AllFlowers = new	ArrayList<Flower>();
		try {
			PreparedStatement parment = con.prepareStatement(querySql);
			result = parment.executeQuery();
			while(result.next()) {
				Flower flower = new Flower();
				flower.setId(result.getInt(1));
				flower.setName(result.getString(2));
				flower.setColor(result.getString(3));
				flower.setFreshness(result.getString(4));
				flower.setRhizomelength(result.getDouble(5));
				flower.setPrice(result.getDouble(6));
				flower.setP_id(result.getInt(7));
				System.out.println(flower.toString());
				AllFlowers.add(flower);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return AllFlowers;
	}
}
