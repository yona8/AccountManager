package com.dingdongding.note.web;

import com.dingdongding.note.dao.searchUseridDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

class Sessions {
  public int GetUserID(HttpServletRequest req) throws SQLException {
    //      获取session
    HttpSession session = req.getSession();
    String username = (String) session.getAttribute("username");
    //      通过session里面的username 调用searchIdDao
    searchUseridDao searchIdDao = new searchUseridDao();
    Integer userid = searchIdDao.searchID(username);
    return userid;
  }
}
