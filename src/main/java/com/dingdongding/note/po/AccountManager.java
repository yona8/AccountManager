package com.dingdongding.note.po;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
    public static void main(String[] args) throws IOException {
        while(true){
            int num1;
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
            Detail detail = new Detail();
        switch(n){
            case 1:
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
                exBalance=balance;
//                把用户输入的数据封装到detail

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
                System.out.println("2.search");
                List li=search();
                System.out.println(li);
                break;
            case 3:
                System.out.println("3.Delete");
                System.out.println("请输入您要删除的货品名称");
                Scanner scanner = new Scanner(System.in);
                String itemsName = scanner.nextLine();
//                detail.setItemsName(itemsName);
                int rs = delete(itemsName);

                if(rs==1){
                    System.out.println("success");

                }else {
                    System.out.println("fault");
                }

                break;
            case 4:
                System.out.println("4.Exchange");
                Scanner sr =new Scanner(System.in);
                System.out.println("请输入日期：");
                String newData = sr.nextLine();
                System.out.println("请输入货品名称：");
                String newItemName = sr.nextLine();
                System.out.println("请输入数量：");
                Integer newQuantity=sr.nextInt();
                System.out.println("请输入价格：");
                Integer newPrice=sr.nextInt();
                System.out.println("请输入ID：");
                Integer id=sr.nextInt();
                Integer newBalance = exBalance -newPrice;
                exBalance=newBalance;
//                把用户输入的数据封装到detail

                detail.setData(newData);
                detail.setItemsName(newItemName);
                detail.setQuantity(newQuantity);
                detail.setPrice(newPrice);
                detail.setBalance(newBalance);
                detail.setId(id);
                int rt = modify(detail);
                if(rt==1){
                    System.out.println("success");

                }else {
                    System.out.println("fault");
                }
                break;
            case 5:
                System.out.println("Thank you");
                System.exit(0);//JVM 退出
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
//                    将数据添加到对应数据库位置
                    ps.setString(1,detail.getData());
                    ps.setString(2,detail.getItemsName());
                    ps.setInt(3,detail.getQuantity());
                    ps.setInt(4,detail.getPrice());
                    ps.setInt(5,detail.getBalance());
//                    执行SQL语句，返回结果，执行结果为数据库受影响的行数，如果为0则执行失败
             result = ps.executeUpdate();


            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return result;
    }

    public static List search(){
        String url = "jdbc:mysql://localhost:3306/Account?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useServerPrepStmts=true";
        String user = "root";
        String password = "";
        Connection con;
        int result =0;
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
            while(resultSet.next()){
//                获取数据
                String data = resultSet.getString("data");
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

    public static int  delete(String itemsName){
        String url = "jdbc:mysql://localhost:3306/Account?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useServerPrepStmts=true";
        String user = "root";
        String password = "";
        Connection con;
        int result =0;
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
            String sql = "delete from Account.new_table where itemsName = ?";

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

    public static int modify(Detail detail){
        String url = "jdbc:mysql://localhost:3306/Account?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useServerPrepStmts=true";
        String user = "root";
        String password = "";
        Connection con;
        int result =0;
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
            String sql = "update Account.new_table " +
                    "set data = ?,itemsName = ?,quantity = ?,price = ?,balance = ?" +
                    " where id = ?";
//        创建statement 类对象，用来执行SQL语句

            PreparedStatement ps = con.prepareStatement(sql);
//                    将数据添加到对应数据库位置
            ps.setString(1,detail.getData());
            ps.setString(2,detail.getItemsName());
            ps.setInt(3,detail.getQuantity());
            ps.setInt(4,detail.getPrice());
            ps.setInt(5,detail.getBalance());
            ps.setInt(6,detail.getId());
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
