package com.dingdongding.note.po;

import java.math.BigDecimal;

public class BalanceDetail {

  private BigDecimal balance;
  private int userid;

  public BalanceDetail() {}

  public BalanceDetail(BigDecimal balance, int userid) {
    this.balance = balance;
    this.userid = userid;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public int getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }

  @Override
  public String toString() {
    return "Balance{" + "balance=" + balance + ", userid=" + userid + '}';
  }
}
