package com.dingdongding.note.dao;

import com.dingdongding.note.util.DBUtil;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class deleteDao {
  private final DBUtil util = new DBUtil();

  public int delete(int userid) {
    int result = 0;
    try {
      String sql1 = "SELECT price FROM Account.new_table where id = ?";
      String sql2 = "UPDATE Account.new_table SET remarks = 'canceled' WHERE ID = ?";

      // 创建statement 类对象，用来执行SQL语句
      PreparedStatement ps = util.createStatement(sql1);
      ps.setInt(1, userid);
      // 执行SQL1语句，返回结果集合
      ResultSet DeletePrice = ps.executeQuery();
      BigDecimal dp = BigDecimal.valueOf(0);
      if (DeletePrice.next()) {
        //        获取集合中的价格
        dp = DeletePrice.getBigDecimal("price");
      }
      //      执行sql2 给要删除的数据行的remarks 添加canceled
      PreparedStatement prs = util.createStatement(sql2);
      prs.setInt(1, userid);
      //      返回结果，成功为1，不成功为0
      result = prs.executeUpdate();
      //      获取最后一个余额数并加上删除行数的价格
      exBalanceCheck exBalanceCheck = new exBalanceCheck();
      //      BigDecimal ebc = exBalanceCheck.ebc(userid);
      //      ebc = ebc.add(dp);
      util.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }
}
