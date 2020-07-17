package org.edwith.webbe.cardmanager.dao;

import org.edwith.webbe.cardmanager.dto.BusinessCard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BusinessCardManagerDao {
	private static String dburl = "jdbc:mysql://localhost:3306/carddb?serverTimezone=UTC";
	private static String dbUser = "carduser";
	private static String dbpasswd = "card123!@#";
	
    public List<BusinessCard> searchBusinessCard(String keyword){
    	
    	List<BusinessCard> list = new ArrayList<>();
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	
    	String sql = "SELECT name, phone, company, date FROM card WHERE name like '%" + keyword + "%'";
    	try(Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
    			PreparedStatement ps = conn.prepareStatement(sql)){
    		try (ResultSet rs = ps.executeQuery()){
    			while(rs.next()) {
    				String name = rs.getString(1);
    				String phone = rs.getString(2);
    				String company = rs.getString(3);
    				java.util.Date utilDate = rs.getTimestamp(4);
    				BusinessCard card = new BusinessCard(name, phone, company);
    				card.setCreateDate(utilDate);
    				list.add(card);
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	return list;
    }

    public BusinessCard addBusinessCard(BusinessCard businessCard){
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	String sql = "INSERT INTO card (name, phone, company, date) VALUES (?, ?, ?, ?)";
    	
    	try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
    			PreparedStatement ps = conn.prepareStatement(sql)){
    		ps.setString(1, businessCard.getName());
    		ps.setString(2, businessCard.getPhone());
    		ps.setString(3, businessCard.getCompanyName());
    		ps.setTimestamp(4, new Timestamp(businessCard.getCreateDate().getTime()));
    		
    		ps.executeUpdate();
    		
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	return businessCard;
    }
}
