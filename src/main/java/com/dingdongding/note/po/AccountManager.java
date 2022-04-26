package com.dingdongding.note.po;

import com.dingdongding.note.dao.*;

import java.io.IOException;
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
      int n = 0;
      if (sc.hasNextInt()) {
        n = sc.nextInt();
      } else {
        System.out.println("input integer ONLY!");
      }
      Detail detail = new Detail();
      exBalanceCheck exBalanceCheck = new exBalanceCheck();
      switch (n) {
        case 1:
          System.out.println("1.Add");
          System.out.println("请输入日期：");
          int data = InputCheck.inputInt();
          System.out.println("请输入货品名称：");
          String itemName = InputCheck.inputString();
          System.out.println("请输入数量：");
          Integer quantity = InputCheck.inputInt();
          System.out.println("请输入价格：");
          Integer price = InputCheck.inputInt();
          Integer balance = exBalanceCheck.ebc() - price;
          // 把用户输入的数据封装到detail
          detail.setData(data);
          detail.setItemsName(itemName);
          detail.setQuantity(quantity);
          detail.setPrice(price);
          detail.setBalance(balance);
          int result = addDao.add(detail);
          if (result == 1) {
            System.out.println("success");

          } else {
            System.out.println("fault");
          }
          break;
        case 2:
          System.out.println("2.search");
          List li = searchDao.search();
          System.out.println(li);
          break;
        case 3:
          System.out.println("3.Delete");
          System.out.println("请输入您要删除的货品名称");
          Scanner scanner = new Scanner(System.in);
          String itemsName = scanner.nextLine();
          detail.setItemsName(itemsName);
          int rs = deleteDao.delete(itemsName);
          Integer dPrice = detail.getPrice();
          Integer dBalance = detail.getBalance();
          detail.setBalance(dBalance + dPrice);

          if (rs == 1) {
            System.out.println("success");

          } else {
            System.out.println("fault");
          }

          break;
        case 4:
          System.out.println("4.Exchange");
          System.out.println("请输入日期：");
          Integer newData = InputCheck.inputInt();
          System.out.println("请输入货品名称：");
          String newItemName = InputCheck.inputString();
          System.out.println("请输入数量：");
          Integer newQuantity = InputCheck.inputInt();
          System.out.println("请输入价格：");
          Integer newPrice = InputCheck.inputInt();
          System.out.println("请输入ID：");
          Integer id = InputCheck.inputInt();
          Integer newBalance = detail.getBalance() - newPrice;
          ;
          // 把用户输入的数据封装到detail
          detail.setData(newData);
          detail.setItemsName(newItemName);
          detail.setQuantity(newQuantity);
          detail.setPrice(newPrice);
          detail.setBalance(newBalance);
          detail.setId(id);
          int rt = modifyDao.modify(detail);
          if (rt == 1) {
            System.out.println("success");

          } else {
            System.out.println("fault");
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
