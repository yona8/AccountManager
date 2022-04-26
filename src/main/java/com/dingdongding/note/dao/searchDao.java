package com.dingdongding.note.dao;

import com.dingdongding.note.po.Detail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class searchDao {
  public static List search() {
    String url =
        "jdbc:mysql://localhost:3306/Account?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useServerPrepStmts=true";
    String user = "root";
    String password = "";
    Connection con;
    int result = 0;
    List<Detail> details = new ArrayList<>();
    try {
      con = DriverManager.getConnection(url, user, password);
      System.out.println("connected");
      String sql = "select * from Account.new_table";
      //        创建statement 类对象，用来执行SQL语句

      PreparedStatement ps = con.prepareStatement(sql);
      //            执行SQL语句
      ResultSet resultSet = ps.executeQuery();
      Detail detail = null;
      //            创建集合
      //          将处理结果 封装对象并装载入集合
      while (resultSet.next()) {
        //                获取数据
        int data = resultSet.getInt("data");
        String itemsName = resultSet.getString("itemsName");
        int quantity = resultSet.getInt("quantity");
        int price = resultSet.getInt("price");
        int balance = resultSet.getInt("balance");
        //                封装对象
        detail = new Detail();
        detail.setData(data);
        detail.setItemsName(itemsName);
        detail.setQuantity(quantity);
        detail.setPrice(price);
        detail.setBalance(balance);
        //                装载入集合
        details.add(detail);
      }
      resultSet.close();
      ps.close();
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return details;
  }
}
