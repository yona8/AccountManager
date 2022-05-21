package com.dingdongding.note.po;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.sql.Date;

public class Bill {
  private Integer id;
  private String type;

  @JSONField(format = "yyyy-MM-dd")
  private Date data;

  private String itemsName;
  private Integer quantity;

  //  @JSONField(serializeUsing = ToStringSerializer.class)
  private BigDecimal price;

  private BigDecimal balance;

  public Bill() {}

  public Bill(
      Integer id,
      String type,
      Date data,
      String itemsName,
      Integer quantity,
      BigDecimal price,
      BigDecimal balance) {
    this.id = id;
    this.type = type;
    this.data = data;
    this.itemsName = itemsName;
    this.quantity = quantity;
    this.price = price;
    this.balance = balance;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public String getItemsName() {
    return itemsName;
  }

  public void setItemsName(String itemsName) {
    this.itemsName = itemsName;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "Bill{"
        + "id="
        + id
        + ", type='"
        + type
        + '\''
        + ", data="
        + data
        + ", itemsName='"
        + itemsName
        + '\''
        + ", quantity="
        + quantity
        + ", price="
        + price
        + ", balance="
        + balance
        + '}';
  }
}
