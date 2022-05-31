package com.dingdongding.note.web;

import com.alibaba.fastjson.JSON;
import com.dingdongding.note.dao.SelectByIdDao;
import com.dingdongding.note.po.Bill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    SelectByIdDao selectByIdDao = new SelectByIdDao();
    BufferedReader br = req.getReader();
    int id = Integer.parseInt(br.readLine()); // json字符串
    //    1.获取Session对象
    HttpSession session = req.getSession();
    //    2.存储数据
    session.setAttribute("id", id);

    List<Bill> bills = selectByIdDao.SelectOneRow(id);
    String jsonString = JSON.toJSONString(bills);
    System.out.println(jsonString);
    resp.getWriter().write(jsonString);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
