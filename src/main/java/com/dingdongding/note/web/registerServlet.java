package com.dingdongding.note.web;

import com.dingdongding.note.dao.userDao;
import com.dingdongding.note.po.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    User user = null;
    userDao dao = new userDao();
    int result = 0;
    PrintWriter out = null;

    //    1.调用用户输入的用户名和密码
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    int userNameCount = dao.userName(username);
    if (userNameCount == 1) {
      resp.getWriter()
          .print(
              "<script>alert('Registration failed, username already exists');window.location.href='/Flower/register.html'</script>");
    } else {
      //        2.执行dao
      user = new User(null, username, password);
      result = dao.register(user);
      // 3.调用响应对象将处理结果以二进制形式写入到响应体
      resp.setContentType("text/html;charset=utf-8");
      out = resp.getWriter();
      if (result == 1) {
        resp.getWriter()
            .print(
                "<script>alert('Congratulations！！registration success！！');window.location.href='/Flower/index.html'</script>");
      } else {
        resp.getWriter()
            .print(
                "<script>alert('registration failed, please try again later');window.location.href='/Flower/register.html'</script>");
      }
    }
  }
}
