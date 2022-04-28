package com.dingdongding.note.po;

import com.dingdongding.note.dao.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
  public static void main(String[] args) throws IOException {
    while (true) {
      int num1;
      System.out.println("-----Welcome to account management");
      System.out.println("1.Add");
      System.out.println("2.Select");
      System.out.println("3.Delete");
      System.out.println("4.Exchange");
      System.out.println("5.Exit");
      System.out.println("请输入数字：");
      Scanner sc = new Scanner(System.in);
      // 检查用户输入是否为数字
      int n = 0;
      n = InputCheck.inputInt();
      Detail detail = new Detail();
      exBalanceCheck exBalanceCheck = new exBalanceCheck();
      switch (n) {
        case 1:
          System.out.println("1.Add");
          System.out.println("Please enter data:Example:dd/mm/yyyy");
          Date data = InputCheck.inputData();
          System.out.println("请输入货品名称：");
          String itemName = InputCheck.inputString();
          System.out.println("请输入数量：");
          Integer quantity = InputCheck.inputInt();
          System.out.println("请输入价格：");
          BigDecimal price = InputCheck.inputBigDecimal();
          BigDecimal balance = exBalanceCheck.ebc().subtract(price);
          // 把用户输入的数据封装到detail
          detail.setData(data);
          detail.setItemsName(itemName);
          detail.setQuantity(quantity);
          detail.setPrice(price);
          detail.setBalance(balance);
          addDao addDao = new addDao();
          int result = addDao.add(detail);
          if (result == 1) {
            System.out.println("success");

          } else {
            System.out.println("failed");
          }
          break;
        case 2:
          System.out.println("2.search");
          searchDao searchDao = new searchDao();
          List<Detail> details = searchDao.search();
          //          打印表格
          System.out.println(
              "-----------------------------------------------------------------------------------------");
          System.out.printf(
              "%2s %5s %5s %5s %5s %10s %5s %5s %5s %5s %5s %5s %5s",
              "|",
              "id",
              "|",
              "data",
              "|",
              "itemsName",
              "|",
              "quantity",
              "|",
              "price",
              "|",
              "balance",
              "|");
          System.out.println();
          System.out.println(
              "-----------------------------------------------------------------------------------------");
          for (Detail detail1 : details) {
            System.out.format(
                "%2s %5s %5s %5s %5s %10s %5s %5s %5s %5s %5s %5s %5s ",
                "|",
                detail1.getId(),
                "|",
                detail1.getData(),
                "|",
                detail1.getItemsName(),
                "|",
                detail1.getQuantity(),
                "|",
                detail1.getPrice(),
                "|",
                detail1.getBalance(),
                "|");
            System.out.println();

            System.out.println(
                "---------------------------------------------------------------------------------------");
          }

          break;
        case 3:
          System.out.println("3.Delete");
          System.out.println("请输入您要删除的id");
          Scanner scanner = new Scanner(System.in);
          int id = scanner.nextInt();
          deleteDao deleteDao = new deleteDao();
          int rs = deleteDao.delete(id);
          if (rs == 1) {
            System.out.println("success");

          } else {
            System.out.println("failed");
          }
          break;
        case 4:
          System.out.println("4.Exchange");
          System.out.println("请输入日期：");
          Date newData = InputCheck.inputData();
          System.out.println("请输入货品名称：");
          String newItemName = InputCheck.inputString();
          System.out.println("请输入数量：");
          Integer newQuantity = InputCheck.inputInt();
          System.out.println("请输入价格：");
          BigDecimal newPrice = InputCheck.inputBigDecimal();
          System.out.println("请输入ID：");
          Integer newId = InputCheck.inputInt();
          BigDecimal newBalance = exBalanceCheck.ebc().subtract(newPrice);
          // 把用户输入的数据封装到detail
          detail.setData(newData);
          detail.setItemsName(newItemName);
          detail.setQuantity(newQuantity);
          detail.setPrice(newPrice);
          detail.setBalance(newBalance);
          detail.setId(newId);
          modifyDao modifyDao = new modifyDao();
          int rt = modifyDao.modify(detail);
          if (rt == 1) {
            System.out.println("success");

          } else {
            System.out.println("failed");
          }
          break;
        case 5:
          System.out.println("Thank you");
          System.exit(0); // JVM 退出
          break;
        default:
          System.out.println("您输入的数字有误，请重新输入");
      }
    }
  }
}
