package com.dingdongding.note.po;

public class Detail {

    private String data;
   private String itemsName;
   private Integer quantity;
   private Integer price;
   private Integer balance;
   private Integer id;

    public Detail() {
    }

    public Detail(String data, String itemsName, Integer quantity, Integer price, Integer balance, Integer id) {
        this.data = data;
        this.itemsName = itemsName;
        this.quantity = quantity;
        this.price = price;
        this.balance = balance;
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "data='" + data + '\'' +
                ", itemsName='" + itemsName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", balance=" + balance +
                ", id=" + id +
                '}';
    }
}
