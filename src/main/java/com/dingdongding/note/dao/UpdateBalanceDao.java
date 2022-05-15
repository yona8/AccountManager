package com.dingdongding.note.dao;

import com.dingdongding.note.po.BalanceDetail;
import com.dingdongding.note.util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBalanceDao {
  DBUtil dbUtil = new DBUtil();

  public int updateBalance(BalanceDetail balanceDetail) throws SQLException {
    String sql = "update Account.balance set balance = ?  where userid = ?";
    PreparedStatement ps = dbUtil.createStatement(sql);
    ps.setBigDecimal(1, balanceDetail.getBalance());
    ps.setInt(2, balanceDetail.getUserid());
    int result = ps.executeUpdate();
    System.out.println(result);
    return result;
  }
}
