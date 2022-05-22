package com.dingdongding.note.web;

import com.dingdongding.note.dao.userDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    userDao dao = new userDao();
    int result = 0;
    // 1.调用请求对象对请求体使用UTF-8字符集进行重新编辑
    req.setCharacterEncoding("utf-8");
    // 打印请求头，注意：运行时一定要注释掉，不然后面的getParameter的值为null
    // System.out.println(req.getReader().lines().collect(Collectors.joining(System.lineSeparator())));

    // 2.调取请求对象，读取请求头参数信息，得到用户的信息
    String username = req.getParameter("userName");
    String password = req.getParameter("userPwd");
    // 将用户名存储到session
    //    1.获取Session对象
    HttpSession session = req.getSession();
    //    2.存储数据
    session.setAttribute("username", username);
    // 3.调用Dao将查询验证信息推送到数据库服务器上
    result = dao.login(username, password);
    // 4.调用响应对象，根据验证结果将不同资源文件地址写入到响应头，交给浏览器
    if (result == 1) { // 用户存在
      resp.getWriter()
          .print(
              "<script>alert('Congratulations !!login successful!!');window.location.href='/Flower/bill.html'</script>");

    } else {
      resp.getWriter()
          .print(
              "<script>alert('login failed !!');window.location.href='/Flower/index.html'</script>");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
