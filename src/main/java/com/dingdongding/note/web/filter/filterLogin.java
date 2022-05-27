package com.dingdongding.note.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class filterLogin implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // 把servlet强制转换为HttpServlet
    HttpServletRequest req = (HttpServletRequest) request;
    // 定义要放行的url
    String[] urls = {
      "/index.html",
      "/IMAGINE/",
      "/CSS/",
      "/fonts/",
      "/loginServlet",
      "/registerServlet",
      "register.html"
    };
    // 获取当前资源的访问路径
    String url = req.getRequestURL().toString();
    for (String s : urls) {
      if (url.contains(s)) {
        // 放行
        chain.doFilter(request, response);
        return;
      }
    }
    //  获取session
    HttpSession session = req.getSession();
    Object username = session.getAttribute("username");
    // 如果有username放行
    if (username != null) {
      // 放行
      chain.doFilter(request, response);
    } else {
      //      没有登录跳转到登录页面
      //      req.setAttribute("login_msg", "您尚未登录");
      //      req.getRequestDispatcher("/index.html").forward(request, response);
      response
          .getWriter()
          .print(
              "<script>alert('Please login first !!');window.location.href='/Flower/index.html'</script>");
    }
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void destroy() {}
}
