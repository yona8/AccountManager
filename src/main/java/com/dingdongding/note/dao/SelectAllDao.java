package com.dingdongding.note.dao;

import com.dingdongding.note.po.Bill;
import com.dingdongding.note.util.DBUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectAllDao {
  private final DBUtil util = new DBUtil();

  public List<Bill> searchAll(int userid) {
    int result = 0;
    List<Bill> BillDetails = new ArrayList<>();

    try {
      String sql = "select * from Account.new_table where userid = (?) and remarks is null";
      Connection con = util.getCon();
      // 创建statement 类对象，用来执行SQL语句
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, userid);
      // 执行SQL语句,返回集合
      ResultSet resultSet = ps.executeQuery();
      Bill bill;
      //  将处理结果 封装对象并装载入集合
      while (resultSet.next()) {
        bill = new Bill();
        //  获取数据
        int id = resultSet.getInt("id");
        String type = resultSet.getString("type");
        Date data = resultSet.getDate("data");
        String itemsName = resultSet.getString("itemsName");
        int quantity = resultSet.getInt("quantity");
        BigDecimal price = resultSet.getBigDecimal("price");
        // 封装对象
        bill.setId(id);
        bill.setType(type);
        bill.setData(data);
        bill.setItemsName(itemsName);
        bill.setQuantity(quantity);
        bill.setPrice(price);
        // 装载入集合
        BillDetails.add(bill);
      }

      resultSet.close();
      util.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return BillDetails;
  }
}
