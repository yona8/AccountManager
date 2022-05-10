package com.dingdongding.note.web;

import com.dingdongding.note.dao.userDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    userDao dao = new userDao();
    int result = 0;
    // 1.调用请求对象对请求体使用UTF-8字符集进行重新编辑
    req.setCharacterEncoding("utf-8");
    System.out.println(req.getReader().lines().collect(Collectors.joining(System.lineSeparator())));

    // 2.调取请求对象，读取请求头参数信息，得到用户的信息
    String username = req.getParameter("userName");
    String password = req.getParameter("userPwd");

    // 3.调用Dao将查询验证信息推送到数据库服务器上
    result = dao.login(username, password);
    // 4.调用响应对象，根据验证结果将不同资源文件地址写入到响应头，交给浏览器
    if (result == 1) { // 用户存在
      resp.sendRedirect(req.getContextPath() + "/index.jsp");
    } else {
      resp.sendRedirect(req.getContextPath() + "/login-error.html");
    }
  }
}
