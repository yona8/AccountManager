package com.dingdongding.note.dao;

import com.dingdongding.note.util.DBUtil;

import java.sql.PreparedStatement;
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
      System.out.println(result);
    }
    return result;
  }
}
