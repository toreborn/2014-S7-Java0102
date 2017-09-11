package com.demo.org.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.org.service.AuthService;
import com.demo.org.util.DbManager;

public class AuthServiceImpl implements AuthService{

	@Override
	public List<String> getAuth(int id) {
		// TODO Auto-generated method stub
		
		List<String> authList = new ArrayList<>();
		
		Connection con = null;
		try {
			con = DbManager.getConnection();
			
			StringBuffer sb = new StringBuffer();
			sb.append("select f.url from account acc,account_roles ar,")
				.append("role r,role_functions rf,function f ")
				.append(" where acc.id = ar.account_id and ar.role_id=r.id")
				.append(" and r.id = rf.role_id and rf.function_id=f.id")
				.append(" and acc.id = ")
				.append(id);
			
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sb.toString());
			
			while(rs.next()) {
				String url = rs.getString("url");
				authList.add(url);
			}
		}catch( SQLException e) {
			e.printStackTrace();
		}finally {
			DbManager.closeConnection(con);
		}
		
		
		
		return authList;
	}

}
