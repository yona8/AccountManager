package com.dingdongding.note.dao;

import com.dingdongding.note.util.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectBeforeUpdateBalanceDao {
  BigDecimal exBalance = BigDecimal.valueOf(0);
  DBUtil util = new DBUtil();
  exBalanceCheck exBalanceCheck = new exBalanceCheck();

  public BigDecimal search(Integer id) throws SQLException {
    String sql = "select type, price,userid from Account.new_table where id = ?";
    Connection con = util.getCon();
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, id);
    ResultSet resultSet = ps.executeQuery();
    while (resultSet.next()) {
      String type = resultSet.getString("type");
      BigDecimal price = resultSet.getBigDecimal("price");
      int userid = resultSet.getInt("userid");

      if (type.equals("consume")) {
        exBalance = exBalanceCheck.ebc(userid).add(price);
      } else {
        exBalance = exBalanceCheck.ebc(userid).subtract(price);
      }
    }
    return exBalance;
  }
}
