package com.deloitte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators.PrecedingSiblingIterator;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

public class DBHelper {
	public ArrayList getAllPassengers(String destination) {
		ArrayList al = new ArrayList();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String jdbcurl = "jdbc:oracle:thin:@localhost:1521:orcl";
			String username = "scott";
			String password = "tiger";
			Connection con = DriverManager.getConnection(jdbcurl, username, password);
			PreparedStatement psm = con.prepareStatement("select * from passengers where destination=?");
			psm.setString(1, destination);
			ResultSet rs = psm.executeQuery();

			while (rs.next()) {
				String fname = rs.getString(1);
				String lname = rs.getString(2);
				String source = rs.getString(3);
				String dest = rs.getString(4);
				String gender = rs.getString(5);
				PassengerVO pvo = new PassengerVO();
				pvo.setFirstname(fname);
				pvo.setLastname(lname);
				pvo.setSource(source);
				pvo.setDestination(dest);
				pvo.setGender(gender);
				al.add(pvo);
			}
			rs.close();
			psm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("sql exception");
		} catch (ClassNotFoundException e) {
			System.out.println("class not found");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		for(Object o : al)
			System.out.println(((PassengerVO)o));
		return al;

	}
}
