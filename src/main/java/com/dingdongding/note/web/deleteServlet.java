package com.dingdongding.note.web;

import com.alibaba.fastjson.JSON;
import com.dingdongding.note.dao.SelectAllDao;
import com.dingdongding.note.dao.deleteByids;
import com.dingdongding.note.dao.exBalanceCheck;
import com.dingdongding.note.dao.searchUseridDao;
import com.dingdongding.note.po.Bill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    BufferedReader br = req.getReader();
    String params = br.readLine(); // json字符串
    int[] ids = JSON.parseObject(params, int[].class);
    try {
      //      获取session
      HttpSession session = req.getSession();
      String username = (String) session.getAttribute("username");
      //      通过session里面的username 调用searchIdDao
      searchUseridDao searchIdDao = new searchUseridDao();
      Integer userid = searchIdDao.searchID(username);
      int delete = deleteByids.delete(ids);
      if (delete == 1) {
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
