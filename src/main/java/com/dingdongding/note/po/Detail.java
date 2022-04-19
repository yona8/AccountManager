package com.dingdongding.note.po;

public class Detail {

    private String data;
   private String itemsName;
   private Integer quantity;
   private Integer price;
   private Integer balance;

    public Detail(String data, String itemsName, Integer quantity, Integer price, Integer balance) {
        this.data = data;
        this.itemsName = itemsName;
        this.quantity = quantity;
        this.price = price;
        this.balance = balance;
    }

    public Detail() {

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

    @Override
    public String toString() {
        return "User{" +
                "data='" + data + '\'' +
                ", itemsName='" + itemsName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", balance=" + balance +
                '}';
    }
}
