package com.dingdongding.note.web;

import com.dingdongding.note.dao.addDao;
import com.dingdongding.note.dao.exBalanceCheck;
import com.dingdongding.note.po.Detail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    addDao adddao = new addDao();
    Detail detail = new Detail();
    exBalanceCheck exBalanceCheck = new exBalanceCheck();
    //     String price =null;

    int result = 0;
    // 1.调用请求对象对请求体使用UTF-8字符集进行重新编辑
    req.setCharacterEncoding("utf-8");

    // 2.调取请求对象，读取请求头参数信息，得到用户的信息
    String type = req.getParameter("type");
    String data = req.getParameter("data");
    String itemsName = req.getParameter("itemsName");
    String quantity = req.getParameter("quantity");
    String price = req.getParameter("price");
    System.out.println(type);
    System.out.println(data);
    //            if(type.equals("income")){
    //                exBalanceCheck.ebc().subtract(price);
  }
  // 3.调用Dao将查询验证信息推送到数据库服务器上
  //      adddao.add()
  //    // 4.调用响应对象，根据验证结果将不同资源文件地址写入到响应头，交给浏览器
  //    if (result == 1) { // 用户存在
  //      resp.sendRedirect(req.getContextPath() + "/index.jsp");
  //    } else {
  //      resp.sendRedirect(req.getContextPath() + "/login-error.html");
  //    }
  //  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doGet(req, resp);
  }
}
