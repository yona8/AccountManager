package com.dingdongding.note.po;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        System.out.println("1.add");
        System.out.println("2.select");
        System.out.println("3.delete");
        System.out.println("4.exchange");
        System.out.println("Input the number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String url = "jdbc:mysql://localhost:3306/Account?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useServerPrepStmts=true";
        String user = "root";
        String password = "";
        Connection con;
        switch (n) {

            case 1:
                System.out.println("Input the data");


                    InputStreamReader is_reader = new InputStreamReader(System.in);
                String str = null;
                try {
                    str = new BufferedReader(is_reader).readLine();
                    con = DriverManager.getConnection(url, user, password);
                    if (!con.isClosed()) {
                        System.out.println("connected");
                        String sql = "insert into Account.new_table(data，itemsName,quantity,price) values(?,?,?,?)";
//        创建statement 类对象，用来执行SQL语句
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1, str);
                        int i = ps.executeUpdate();
                        if(i==1){
                            System.out.println("success");
                        }else{
                            System.out.println("fail");
                        }
                        ps.close();
                        con.close();

                    }
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }





                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
        }
        }
}

