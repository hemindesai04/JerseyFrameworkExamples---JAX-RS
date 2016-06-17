package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import pojo.UserInfo;

import com.mysql.jdbc.PreparedStatement;

public class LoginHandler {
	public ArrayList<UserInfo> getAllUsers(Connection connection) throws Exception {
		ArrayList<UserInfo> userList = new ArrayList<UserInfo>();
		try {
		
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement("SELECT * FROM user");
					
		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserInfo userinfo = new UserInfo();
				userinfo.setUsername(rs.getString("username"));
				userinfo.setPassword(rs.getString("password"));
				userList.add(userinfo);
			}
			return userList;
		} catch (Exception e) {
			throw e;
		}
	}
}
