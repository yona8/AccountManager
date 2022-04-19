package com.dingdongding.note.po;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountManager {
    public static void main(String[] args) throws IOException {
        while(true){
        System.out.println("-----Welcome to account management");
        System.out.println("1.Add");
        System.out.println("2.Select");
        System.out.println("3.Delete");
        System.out.println("4.Exchange");
        System.out.println("5.Exit");
            System.out.println("请输入数字：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String url = "jdbc:mysql://localhost:3306/Account?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useServerPrepStmts=true";
        String user = "root";
        String password = "";
        Connection con;
        Integer exBalance = 1000;
        switch(n){
            case 1:
//                int result = 0;
                System.out.println("1.Add");
                Scanner si =new Scanner(System.in);
                System.out.println("请输入日期：");
                String data = si.nextLine();
                System.out.println("请输入货品名称：");
                String itemName = si.nextLine();
                System.out.println("请输入数量：");
                Integer quantity=si.nextInt();
                System.out.println("请输入价格：");
                Integer price=si.nextInt();
                Integer balance = exBalance -price;
                Detail detail = new Detail();
                detail.setData(data);
                detail.setItemsName(itemName);
                detail.setQuantity(quantity);
                detail.setPrice(price);
                detail.setBalance(balance);
                int result = add(detail);
                if(result==1){
                    System.out.println("success");

                }else {
                    System.out.println("fault");
                }
                break;
            case 2:
                System.out.println("2.Select");
                break;
            case 3:
                System.out.println("3.Delete");
                break;
            case 4:
                System.out.println("4.Exchange");
                break;
            case 5:
                System.out.println("Thank you");
                break;

            }
        }
    }
    public static int add(Detail detail){
        String url = "jdbc:mysql://localhost:3306/Account?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useServerPrepStmts=true";
        String user = "root";
        String password = "";
        Connection con;
        int result =0;
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
            String sql = "insert into Account.new_table(data,itemsName,quantity,price,balance) values(?,?,?,?,?)";
//        创建statement 类对象，用来执行SQL语句

                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1,detail.getData());
                    ps.setString(2,detail.getItemsName());
                    ps.setInt(3,detail.getQuantity());
                    ps.setInt(4,detail.getPrice());
                    ps.setInt(5,detail.getBalance());
             result = ps.executeUpdate();


            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return result;
    }

}
