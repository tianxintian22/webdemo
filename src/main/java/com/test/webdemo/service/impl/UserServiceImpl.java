package com.test.webdemo.service.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.test.webdemo.model.DBUtil;
import com.test.webdemo.model.Users;
import com.test.webdemo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	private Connection conn;
	public UserServiceImpl() {
		this.conn = DBUtil.getConnection();
	}
	public void addUser(Users u) {
		try {
			String sql = "insert into test_users "
					+ "(`user_name`, `sex`, `age`, `birthday`, `email`, `mobile`, `create_user`, `create_date`, `update_user`, `update_date`, `isdel`)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, current_date(), ?, current_date(), ?)";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, u.getUser_name());
			ptmt.setInt(2, u.getSex());
			ptmt.setInt(3, u.getAge());
			ptmt.setDate(4, new Date(u.getBirthday().getTime()));
			ptmt.setString(5, u.getEmail());
			ptmt.setString(6, u.getMobile());
			ptmt.setString(7, u.getCreate_user());
			ptmt.setString(8, u.getUpdate_user());
			ptmt.setInt(9, u.getIsdel());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void updateUser(Users u) {
		try {
			String sql = "update test_users "
					+ " set `user_name` = ? , `sex` = ?, `age` = ?, `birthday` = ?, `email` = ?, `mobile` =  ?, `update_user` = ? , `update_date` = current_date(), `isdel` = ?"
					+ " where id = ?";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, u.getUser_name());
			ptmt.setInt(2, u.getSex());
			ptmt.setInt(3, u.getAge());
			ptmt.setDate(4, new Date(u.getCreate_date().getTime()));
			ptmt.setString(5, u.getEmail());
			ptmt.setString(6, u.getMobile());
			ptmt.setString(7, u.getUpdate_user());
			ptmt.setInt(8, u.getIsdel());
			ptmt.setInt(9, u.getId());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delUser(Integer id) {
		try {
			String sql = "delete from test_users "
					+ " where id = ?";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Users> query() {
		List<Users> user = new ArrayList<Users>();
		Users u = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from test_users");
			while (rs.next()) {
				u = new Users();
				u.setId(rs.getInt("id"));
				u.setUser_name(rs.getString("user_name"));
				u.setAge(rs.getInt("age"));
				u.setSex(rs.getInt("sex"));
				u.setBirthday(rs.getDate("birthday"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getString("mobile"));
				u.setCreate_date(rs.getDate("create_date"));
				u.setCreate_user(rs.getString("create_user"));
				u.setUpdate_date(rs.getDate("update_date"));
				u.setUpdate_user(rs.getString("update_user"));
				u.setIsdel(rs.getInt("isdel"));
				
				user.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public List<Users> query(String name) {
		List<Users> user = new ArrayList<Users>();
		try {
			StringBuffer strbuf = new StringBuffer();
			strbuf.append("select * from test_users");
			strbuf.append(" where user_name like ?");
			
			PreparedStatement ptmt = conn.prepareStatement(strbuf.toString());
			ptmt.setString(1, "%" + name + "%");
			ResultSet rs = ptmt.executeQuery();
			
			Users u = null;
			while (rs.next()) {
				u = new Users();
				u.setId(rs.getInt("id"));
				u.setUser_name(rs.getString("user_name"));
				u.setAge(rs.getInt("age"));
				u.setSex(rs.getInt("sex"));
				u.setBirthday(rs.getDate("birthday"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getString("mobile"));
				u.setCreate_date(rs.getDate("create_date"));
				u.setCreate_user(rs.getString("create_user"));
				u.setUpdate_date(rs.getDate("update_date"));
				u.setUpdate_user(rs.getString("update_user"));
				u.setIsdel(rs.getInt("isdel"));
				
				user.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public List<Users> query(List<Map<String, Object>> params) {
		List<Users> user = new ArrayList<Users>();
		try {
			StringBuffer strbuf = new StringBuffer();
			strbuf.append("select * from test_users where 1 = 1");
			
			if (params != null && params.size() >0) {
				for (int i = 0; i < params.size(); i++) {
					Map<String, Object> map = params.get(i);
					strbuf.append(" and " + map.get("name") + map.get("rela") + map.get("value"));
				}
			}
			
			PreparedStatement ptmt = conn.prepareStatement(strbuf.toString());
			ResultSet rs = ptmt.executeQuery();
			Users u = null;
			while (rs.next()) {
				u = new Users();
				u.setId(rs.getInt("id"));
				u.setUser_name(rs.getString("user_name"));
				u.setAge(rs.getInt("age"));
				u.setSex(rs.getInt("sex"));
				u.setBirthday(rs.getDate("birthday"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getString("mobile"));
				u.setCreate_date(rs.getDate("create_date"));
				u.setCreate_user(rs.getString("create_user"));
				u.setUpdate_date(rs.getDate("update_date"));
				u.setUpdate_user(rs.getString("update_user"));
				u.setIsdel(rs.getInt("isdel"));
				
				user.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public Users getUser(Integer id) {
		Users u = null;
		try {
			String sql = "select * from test_users "
					+ " where id = ?";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				u = new Users();
				u.setId(rs.getInt("id"));
				u.setUser_name(rs.getString("user_name"));
				u.setAge(rs.getInt("age"));
				u.setSex(rs.getInt("sex"));
				u.setBirthday(rs.getDate("birthday"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getString("mobile"));
				u.setCreate_date(rs.getDate("create_date"));
				u.setCreate_user(rs.getString("create_user"));
				u.setUpdate_date(rs.getDate("update_date"));
				u.setUpdate_user(rs.getString("update_user"));
				u.setIsdel(rs.getInt("isdel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
}
