package com.demo.org.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.demo.org.bean.Log;
import com.demo.org.service.LogService;
import com.demo.org.util.DbManager;

public class LogServiceImpl implements LogService{

	@Override
	public int addLog(Log log) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DbManager.getConnection();
			
			StringBuffer sb = new StringBuffer();
			sb.append("insert into user_log(description,account_id)")
				.append(" values ")
				.append("('").append(log.getDescription()).append("',")
				.append(log.getAccount_id()).append(")");
			
			Statement stat = con.createStatement();
			int result = stat.executeUpdate(sb.toString());
			
			return result;
		}catch( SQLException e) {
			e.printStackTrace();
		}finally {
			DbManager.closeConnection(con);
		}
		
		
		
		
		return 0;
	}

}
