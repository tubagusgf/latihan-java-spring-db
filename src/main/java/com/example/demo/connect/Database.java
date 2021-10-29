package com.example.demo.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.example.demo.model.Laptop;


public class Database {
	
    private final static String url = "jdbc:postgresql://localhost:5432/lat1";
    private final static String user = "postgres";
	private final static String password = "asdasd";
	private final static String table = "tb_laptop";

	public static Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			// System.out.println("konek ges");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public void selectInfo() {
		Statement stmt = null;
		Connection conn = connect();
		try {
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
	         ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + " ORDER BY id ASC"); 
	         while (rs.next()) {
                System.out.println(String.format("%s-%s",
                        rs.getInt("id"),
                        rs.getString("info")));
			}
	         rs.close();
	         stmt.close();
	         conn.commit();
	         conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Object find(int id) {
		Statement stmt = null;
		Connection conn = connect();
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
	         ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE id = " + id); 
	         while (rs.next()) {
				map.put("id", rs.getInt("id"));
				map.put("brand", rs.getString("brand"));
				map.put("price", rs.getDouble("price"));
			}
	         rs.close();
	         stmt.close();
	         conn.commit();
	         conn.close();
			 return map;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return map;
	}
	
	
	public void insert(Laptop laptop) {
		Statement stmt = null;
		Connection conn = connect();
		try {
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
	         String sql = String.format("INSERT INTO " + table + " (brand,price) VALUES ('%s',%s)", laptop.getBrand(), laptop.getPrice()); 
	         stmt.executeUpdate(sql);
	         stmt.close();
	         conn.commit();
	         conn.close();
	         
	         System.out.println(String.format("Sukses insert data dengan brand %s", laptop.getBrand()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void update(int id, String brand, Double price) {
		Statement stmt = null;
		Connection conn = connect();
		try {
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
	         String sql = String.format("UPDATE " + table + " SET id = %s, brand = '%s', price = %s WHERE id = %s", id, brand, price, id);
	         stmt.executeUpdate(sql);
	         stmt.close();
	         conn.commit();
	         conn.close();
	         
	         System.out.println(String.format("Sukses update data dengan id %s", id));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(int id) {
		Statement stmt = null;
		Connection conn = connect();
		try {
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
	         String sql = String.format("DELETE FROM " + table + " WHERE id = %s", id);
	         stmt.executeUpdate(sql);
	         stmt.close();
	         conn.commit();
	         conn.close();
	         
	         System.out.println(String.format("Sukses delete data dengan id %s", id));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
