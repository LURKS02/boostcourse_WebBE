package org.edwith.webbe.guestbook.dao;

import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;

public class GuestbookDao {
	private static String dburl = "jdbc:mysql://localhost:3306/guestdb";
	private static String dbUser = "guestuser";
	private static String dbpasswd = "guest123!@#";
	
    public List<Guestbook> getGuestbooks(){
        List<Guestbook> list = new ArrayList<>();
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
        	e.printStackTrace();
        }
        
        String sql = "SELECT id, name, content, regdate FROM guestbook";
        try (Connection conn = DriverManager.getConnection(dburl,dbUser,dbpasswd);
        		PreparedStatement ps = conn.prepareStatement(sql)){
        	try (ResultSet rs = ps.executeQuery()){
        		while(rs.next()) {
        			Long id = rs.getLong("id");
        			String name = rs.getString("name");
        			String content = rs.getString("content");
        			java.util.Date utilDate = rs.getDate("regdate");
        			Guestbook book = new Guestbook(id,name,content,utilDate);
        			list.add(book);
        		}
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
        return list;
    }

    public void addGuestbook(Guestbook guestbook){
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	String sql = "INSERT INTO guestbook (name, content, regdate) VALUES (?, ?, now())";
    	
    	try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
    			PreparedStatement ps = conn.prepareStatement(sql)){
    		ps.setString(1, guestbook.getName());
    		ps.setString(2, guestbook.getContent());	
    		ps.executeUpdate();
    		
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
}
