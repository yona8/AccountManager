package com.dingdongding.note.dao;

import com.dingdongding.note.util.DBUtil;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class exBalanceCheck {
  private final DBUtil util = new DBUtil();
  BigDecimal balance = BigDecimal.valueOf(0);

  public exBalanceCheck() {}

  public BigDecimal ebc(int userid) {

    try {
      String sql = "select balance from Account.balance where userid = ?";
      // 创建statement 类对象，用来执行SQL语句
      PreparedStatement ps = util.createStatement(sql);
      ps.setInt(1, userid);
      // 执行SQL语句，返回结果集
      ResultSet resultSet = ps.executeQuery();
      // 如果结果集里由余额，获取余额，如果没有赋值余额为1000
      if (!resultSet.next()) {
        balance = BigDecimal.valueOf(1000);
        addInitialPrice(userid);
      } else {
        balance = resultSet.getBigDecimal("balance");
      }
      resultSet.close();
      util.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return balance;
  }

  public void addInitialPrice(int userid) throws SQLException {
    String sql = "insert into Account.balance values(?,?)";
    PreparedStatement ps = util.createStatement(sql);
    ps.setBigDecimal(1, balance);
    ps.setInt(2, userid);
    int i = ps.executeUpdate();
    System.out.println("添加原始数据执行行数：" + i);
  }
}
