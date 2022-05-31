package com.dingdongding.note.web;

import com.alibaba.fastjson.JSON;
import com.dingdongding.note.dao.*;
import com.dingdongding.note.po.BalanceDetail;
import com.dingdongding.note.po.Bill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    deleteByids deleteByids = new deleteByids();
    SelectAllDao selectAllDao = new SelectAllDao();
    exBalanceCheck exBalanceCheck = new exBalanceCheck();
    UpdateBalanceDao updateBalanceDao = new UpdateBalanceDao();
    SelectBeforeUpdateBalanceDao selectBeforeUpdateBalanceDao = new SelectBeforeUpdateBalanceDao();
    int Balance = 0;
    // 获取前端数据ids
    BufferedReader br = req.getReader();
    String params = br.readLine(); // json字符串
    int[] ids = JSON.parseObject(params, int[].class);
    try {
      // 获取Session中的用户名并调取用户ID
      Sessions ss = new Sessions();
      int userid = ss.GetUserID(req);
      //      掉用删除dao标记删除在数据库行
      int delete = deleteByids.delete(ids);
      // 循环遍历ids得到要删除的ID，调用dao层修改balance
      for (int id : ids) {
        BigDecimal balance = selectBeforeUpdateBalanceDao.search(id);
        BalanceDetail balanceDetail = new BalanceDetail(balance, userid);
        Balance = updateBalanceDao.updateBalance(balanceDetail);
      }
      // 如果明细表和余额表都删除成功，继续执行
      if (delete == 1 && Balance == 1) {
        //      1.调用SelectAll方法查询
        List<Bill> BillDetails = selectAllDao.searchAll(userid);

        BigDecimal ebc = exBalanceCheck.ebc(userid);

        //      2.将集合转换为JSON数据 序列化
        String jsonString = JSON.toJSONString(BillDetails);

        //  3.响应数据
        //      resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
