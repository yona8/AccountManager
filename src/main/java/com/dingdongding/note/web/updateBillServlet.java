package com.dingdongding.note.web;

import com.dingdongding.note.dao.SelectBeforeUpdateBalanceDao;
import com.dingdongding.note.dao.UpdateBalanceDao;
import com.dingdongding.note.dao.UpdateDao;
import com.dingdongding.note.dao.searchUseridDao;
import com.dingdongding.note.po.BalanceDetail;
import com.dingdongding.note.po.Detail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/updateBillServlet")
public class updateBillServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    UpdateDao updateDao = new UpdateDao();
    Detail detail = new Detail();
    UpdateBalanceDao updateBalanceDao = new UpdateBalanceDao();
    BigDecimal balance = BigDecimal.valueOf(0);
    BalanceDetail balanceDetail = new BalanceDetail();
    SelectBeforeUpdateBalanceDao selectBeforeUpdateBalanceDao = new SelectBeforeUpdateBalanceDao();
    searchUseridDao searchIdDao = new searchUseridDao();
    int result = 0;

    // 1.调用请求对象对请求体使用UTF-8字符集进行重新编辑
    req.setCharacterEncoding("utf-8");
    // 打印请求头，注意：运行时一定要注释掉，不然后面的getParameter的值为null
    // System.out.println(req.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
    try {
      //      获取session
      HttpSession session = req.getSession();
      String username = (String) session.getAttribute("username");
      Integer userid = searchIdDao.searchID(username);
      Integer id = (Integer) session.getAttribute("id");
      BigDecimal exPrice = (BigDecimal) session.getAttribute("price");
      //      通过session里面的username 调用searchIdDao

      // 2.调取请求对象，获取数据合集
      SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
      Date Udata = sf.parse(req.getParameter("data"));
      java.sql.Date data = new java.sql.Date(Udata.getTime());
      String itemsName = req.getParameter("itemsName");
      int quantity = Integer.parseInt(req.getParameter("quantity"));
      BigDecimal price = new BigDecimal(req.getParameter("price"));
      String type = req.getParameter("type");

      BigDecimal BeforeBalance = selectBeforeUpdateBalanceDao.search(id);
      if (type.equals("consume")) {
        balance = BeforeBalance.subtract(price);
      } else {
        balance = BeforeBalance.add(price);
      }

      detail = new Detail(id, type, data, itemsName, quantity, price, null, userid);
      balanceDetail = new BalanceDetail(balance, userid);
      //   3.调用Dao将查询验证信息推送到数据库服务器上
      result = updateDao.update(detail);
      int balance1 = updateBalanceDao.updateBalance(balanceDetail);
      //       4.调用响应对象，根据验证结果将不同资源文件地址写入到响应头，交给浏览器
      if (result == 1 && balance1 == 1) { // 添加成功
        resp.getWriter()
            .print(
                "<script>alert('Update successful!!');window.location.href='/Flower/bill.html'</script>");
      } else {
        resp.getWriter()
            .print(
                "<script>alert('Update failed!! Please try again');window.location.href='/Flower/updateBill.html'</script>");
      }
    } catch (ParseException | SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
