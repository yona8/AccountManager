package com.dingdongding.note.dao;

import com.dingdongding.note.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class deleteByids {
  private final DBUtil util = new DBUtil();

  public int delete(int[] ids) throws SQLException {
    int result = 0;
    for (int id : ids) {
      String sql = "UPDATE Account.new_table SET remarks = 'canceled' WHERE ID = ?";
      PreparedStatement ps = util.createStatement(sql);
      ps.setInt(1, id);
      result = ps.executeUpdate();
    }
    return result;
  }

  public int SelectType(int[] ids) throws SQLException {
    int result = 0;
    for (int id : ids) {
      String sql = "select type from Account.new_table WHERE ID = ?";
      PreparedStatement ps = util.createStatement(sql);
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
    }
    return result;
  }

  public ResultSet SelectData(int[] ids) throws SQLException {
    ResultSet resultSet = null;
    for (int id : ids) {
      String sql = "select price from Account.new_table WHERE ID = ?";
      PreparedStatement ps = util.createStatement(sql);
      ps.setInt(1, id);
      resultSet = ps.executeQuery();
      System.out.println(resultSet);
    }
    return resultSet;
  }
}
