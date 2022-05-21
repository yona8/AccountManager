package com.dingdongding.note.dao;

import com.dingdongding.note.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class searchUseridDao {
  DBUtil util = new DBUtil();

  public Integer searchID(String username) throws SQLException {
    Integer searchid = 0;
    String sql = "select id from Account.user where username = ?";
    Connection con = util.getCon();
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, username);
    ResultSet resultSet = ps.executeQuery();
    while (resultSet.next()) {
      searchid = resultSet.getInt("id");
    }
    return searchid;
  }
}
