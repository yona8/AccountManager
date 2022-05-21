package com.dingdongding.note.web;

import com.dingdongding.note.dao.exBalanceCheck;
import com.dingdongding.note.dao.searchUseridDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@WebServlet("/selectBalanceServlet")
public class SelectBalanceServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    exBalanceCheck exBalanceCheck = new exBalanceCheck();
    //      获取session
    HttpSession session = req.getSession();
    String username = (String) session.getAttribute("username");
    //      通过session里面的username 调用searchIdDao
    searchUseridDao searchIdDao = new searchUseridDao();
    try {
      Integer userid = searchIdDao.searchID(username);
      BigDecimal ebc = exBalanceCheck.ebc(userid);
      //      String jsonString = JSON.toJSONString(ebc);
      //  3.响应数据
      //      resp.setContentType("text/json;charset=utf-8");
      resp.getWriter().write(String.valueOf(ebc));

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
