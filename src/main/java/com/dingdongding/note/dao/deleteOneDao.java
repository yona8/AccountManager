package com.dingdongding.note.dao;

import com.dingdongding.note.po.Detail;

import java.sql.*;

public class deleteOneDao {
  public static void delete(String itemsName) {
    String url =
        "jdbc:mysql://localhost:3306/Account?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useServerPrepStmts=true";
    String user = "root";
    String password = "";
    Connection con;
    int result = 0;
    try {
      con = DriverManager.getConnection(url, user, password);
      System.out.println("connected");
      String sql1 = "select * from Account.new_table where itemsName = ?";
      String sql2 =
          "insert into Account.new_table(data,itemsName,quantity,price,balance) values(?,?,?,?,?)";

      // 创建statement 类对象，用来执行SQL语句
      PreparedStatement ps = con.prepareStatement(sql1);
      ps.setString(1, itemsName);
      //        执行SQL语句，返回结果
      ResultSet resultSet = ps.executeQuery();
      Detail detail = null;
      // 创建集合
      // 将处理结果 封装对象并装载入集合
      while (resultSet.next()) {
        //                获取数据
        ps.setInt(1, resultSet.getInt("data"));
        ps.setString(2, resultSet.getString("itemsName"));
        ps.setInt(3, -resultSet.getInt("quantity"));
        ps.setInt(4, -resultSet.getInt("price"));
        //        ps.setInt(5, resultSet.getInt("balance"));
        //                int data = resultSet.getInt("data");
        //                String itemName = resultSet.getString("itemsName");
        //        int quantity = - resultSet.getInt("quantity");
        int price = resultSet.getInt("price");
        int balance = resultSet.getInt("balance");
        detail.setPrice(price);
        detail.setBalance(balance);
        ps.setInt(5, detail.getBalance());
        result = ps.executeUpdate();
      }
      resultSet.close();
      ps.close();
      con.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
