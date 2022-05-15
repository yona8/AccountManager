package com.dingdongding.note.po;

import java.math.BigDecimal;
import java.sql.Date;

public class Detail {
  private Integer id;
  private Date data;
  private String itemsName;
  private Integer quantity;
  private BigDecimal price;
  private String remarks;
  private Integer userid;

  public Detail() {}

  public Detail(
      Integer id,
      Date data,
      String itemsName,
      Integer quantity,
      BigDecimal price,
      String remarks,
      Integer userid) {
    this.id = id;
    this.data = data;
    this.itemsName = itemsName;
    this.quantity = quantity;
    this.price = price;
    this.remarks = remarks;
    this.userid = userid;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  @Override
  public String toString() {
    return "Detail{"
        + "id="
        + id
        + ", data="
        + data
        + ", itemsName='"
        + itemsName
        + '\''
        + ", quantity="
        + quantity
        + ", price="
        + price
        + ", remarks='"
        + remarks
        + '\''
        + ", userid="
        + userid
        + '}';
  }
}
