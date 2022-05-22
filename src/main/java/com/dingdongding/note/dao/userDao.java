package com.dingdongding.note.dao;

import com.dingdongding.note.po.User;
import com.dingdongding.note.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDao {
  private DBUtil util = new DBUtil();
  // 用户注册
  public int register(User user) {
    String sql = "insert into Account.user(userName,password) values(?,?)";
    PreparedStatement ps = util.createStatement(sql);
    int result = 0;
    try {
      ps.setString(1, user.getUsername());
      ps.setString(2, user.getPassword());
      result = ps.executeUpdate(); // 返回值是一个整数，指受影响的行数
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close();
    }
    return result;
  }
  // 验证用户名的唯一性
  public int userName(String username) {
    String sql = "select count(*) from Account.user where username = (?)";
    PreparedStatement ps = util.createStatement(sql);
    ResultSet rs = null;
    int result = 0;
    try {
      ps.setString(1, username);
      rs = ps.executeQuery();
      while (rs.next()) {
        result = rs.getInt("count(*)");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close();
    }
    return result;
  }

  // 登录验证
  public int login(String username, String password) {
    String sql = "select count(*) from Account.user where username = (?) and password= (?)";
    PreparedStatement ps = util.createStatement(sql);
    ResultSet rs = null;
    int result = 0;
    try {
      ps.setString(1, username);
      ps.setString(2, password);
      rs = ps.executeQuery();
      while (rs.next()) {
        result = rs.getInt("count(*)");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      util.close();
    }
    return result;
  }
}
