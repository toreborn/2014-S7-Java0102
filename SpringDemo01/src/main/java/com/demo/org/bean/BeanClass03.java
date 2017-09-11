package com.demo.org.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 数据库连接实验
 * @author xl
 *
 */
@Service("bc03")
public class BeanClass03 {
	@Autowired
	private DataSource ds;
	
	public int getLogCount() {
		Connection con = null;
		try {
			con = ds.getConnection();
			
			Statement stat = con.createStatement();
			String sql = "select count(1) cnt from user_log";
			
			ResultSet rs = stat.executeQuery(sql);
			if(rs.next()) {
				int cnt = rs.getInt("cnt");
				return cnt;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
