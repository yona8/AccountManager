package com.dingdongding.note.dao;

import com.dingdongding.note.po.Detail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class modifyDao {
  public static int modify(Detail detail) {
    String url =
        "jdbc:mysql://localhost:3306/Account?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useServerPrepStmts=true";
    String user = "root";
    String password = "";
    Connection con;
    int result = 0;
    try {
      con = DriverManager.getConnection(url, user, password);
      System.out.println("connected");
      String sql =
          "update Account.new_table "
              + "set data = ?,itemsName = ?,quantity = ?,price = ?,balance = ?"
              + " where id = ?";
      //        创建statement 类对象，用来执行SQL语句

      PreparedStatement ps = con.prepareStatement(sql);
      //                    将数据添加到对应数据库位置
      ps.setInt(1, detail.getData());
      ps.setString(2, detail.getItemsName());
      ps.setInt(3, detail.getQuantity());
      ps.setInt(4, detail.getPrice());
      ps.setInt(5, detail.getBalance());
      ps.setInt(6, detail.getId());
      //                    执行SQL语句，返回结果，执行结果为数据库受影响的行数，如果为0则执行失败
      result = ps.executeUpdate();

      ps.close();
      con.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }
}
