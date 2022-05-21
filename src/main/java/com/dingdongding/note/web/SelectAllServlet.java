package com.dingdongding.note.web;

import com.alibaba.fastjson.JSON;
import com.dingdongding.note.dao.SelectAllDao;
import com.dingdongding.note.dao.searchUseridDao;
import com.dingdongding.note.po.Bill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
  private final SelectAllDao selectAllDao = new SelectAllDao();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    try {
      //      获取session
      HttpSession session = req.getSession();
      String username = (String) session.getAttribute("username");
      //      通过session里面的username 调用searchIdDao
      searchUseridDao searchIdDao = new searchUseridDao();
      Integer userid = searchIdDao.searchID(username);
      //      1.调用SelectAll方法查询
      List<Bill> BillDetails = selectAllDao.searchAll(userid);

      //      2.将集合转换为JSON数据 序列化
      String jsonString = JSON.toJSONString(BillDetails);
      //  3.响应数据
      //      resp.setContentType("text/json;charset=utf-8");
      resp.getWriter().write(jsonString);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {}
}
