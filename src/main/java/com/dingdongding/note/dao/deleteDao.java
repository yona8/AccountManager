package com.dingdongding.note.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteDao {

  public static int delete(String itemsName) {
    String url =
        "jdbc:mysql://localhost:3306/Account?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useServerPrepStmts=true";
    String user = "root";
    String password = "";
    Connection con;
    int result = 0;
    try {
      con = DriverManager.getConnection(url, user, password);
      System.out.println("connected");
      String sql = "select * from Account.new_table where itemsName = ?";

      //        创建statement 类对象，用来执行SQL语句
      PreparedStatement ps = con.prepareStatement(sql);

      ps.setString(1, itemsName);

      //        执行SQL语句，返回结果，执行结果为数据库受影响的行数，如果为0则执行失败
      result = ps.executeUpdate();
      ps.close();
      con.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }
}
