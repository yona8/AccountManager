package com.dingdongding.note.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Change {

 String url = "jdbc:mysql://localhost:3306/Account?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useServerPrepStmts=true";
 String user="root";
 String password = "";
 Connection con;

  {
    try {
      con = DriverManager.getConnection(url,user,password);
      if(!con.isClosed()){
        System.out.println("connected");
        String sql="update Account set 'itemsName'=? 'quantity'=? 'price'=?  where id = ?";
//        创建statement 类对象，用来执行SQL语句
       PreparedStatement ps= con.prepareStatement(sql);


      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


}
