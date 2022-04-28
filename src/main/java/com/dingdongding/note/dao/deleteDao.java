package com.dingdongding.note.dao;

import com.dingdongding.note.util.DBUtil;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class deleteDao {
  private final DBUtil util = new DBUtil();

  public int delete(int id) {
    int result = 0;
    try {
      String sql1 = "SELECT price FROM Account.new_table where id = ?";
      String sql2 = "delete FROM Account.new_table where id = ?";
      //      String sql3 = "SELECT balance FROM Account.new_table ORDER BY id DESC LIMIT 1";
      // 创建statement 类对象，用来执行SQL语句
      PreparedStatement ps = util.createStatement(sql1);
      ps.setInt(1, id);
      // 执行SQL语句，返回结果，执行结果为数据库受影响的行数，如果为0则执行失败
      ResultSet DeletePrice = ps.executeQuery();
      BigDecimal dp = BigDecimal.valueOf(0);
      if (DeletePrice.next()) {
        dp = DeletePrice.getBigDecimal("price");
      }
      PreparedStatement prs = util.createStatement(sql2);
      prs.setInt(1, id);
      result = prs.executeUpdate();
      exBalanceCheck exBalanceCheck = new exBalanceCheck();
      BigDecimal ebc = exBalanceCheck.ebc();
      ebc = ebc.add(dp);
      util.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }
}
