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
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    addDao adddao = new addDao();
    Detail detail = new Detail();
    exBalanceCheck exBalanceCheck = new exBalanceCheck();
    BigDecimal balance = BigDecimal.valueOf(0);

    //     String price =null;

    int result = 0;
    // 1.调用请求对象对请求体使用UTF-8字符集进行重新编辑
    req.setCharacterEncoding("utf-8");
    // 打印请求头，注意：运行时一定要注释掉，不然后面的getParameter的值为null
    // System.out.println(req.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
    // 2.调取请求对象，获取数据合集
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    try {
      Date Udata = sf.parse(req.getParameter("data"));
      java.sql.Date data = new java.sql.Date(Udata.getTime());
      System.out.println(data);
      String itemsName = req.getParameter("itemsName");
      System.out.println(itemsName);
      int quantity = Integer.parseInt(req.getParameter("quantity"));
      BigDecimal price = new BigDecimal(req.getParameter("price"));
      System.out.println(price);
      String type = req.getParameter("type");
      System.out.println(type);

      if (type.equals("consume")) {
        balance = exBalanceCheck.ebc().subtract(price);
      } else {
        balance = exBalanceCheck.ebc().add(price);
      }
      System.out.println(balance);
      //     String remarks=null;
      detail = new Detail(null, data, itemsName, quantity, price, balance, null);

      //   3.调用Dao将查询验证信息推送到数据库服务器上
      result = adddao.add(detail);
      //       4.调用响应对象，根据验证结果将不同资源文件地址写入到响应头，交给浏览器
      if (result == 1) { // 用户存在
        resp.sendRedirect(req.getContextPath() + "/bill.html");
      } else {
        resp.sendRedirect(req.getContextPath() + "/login-error.html");
      }
    } catch (ParseException e) {
      assert e != null;
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
