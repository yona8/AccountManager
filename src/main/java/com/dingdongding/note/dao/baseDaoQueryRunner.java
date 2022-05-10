// package com.dingdongding.note.dao;
//
// import com.dingdongding.note.util.DBUtil;
// import org.apache.commons.dbutils.QueryRunner;
// import org.apache.commons.dbutils.handlers.BeanHandler;
// import org.apache.commons.dbutils.handlers.BeanListHandler;
// import org.apache.commons.dbutils.handlers.ScalarHandler;
//
// import java.sql.Connection;
// import java.sql.SQLException;
// import java.util.List;
//
// public class baseDaoQueryRunner {
//  private QueryRunner queryRunner = new QueryRunner();
//  // update（）方法用来执行：Insert updata Deleta语句
//  //  如果返回-1，说明执行失败 返回其他表示影响的行数
//  public int update(String sql, Object... args) {
//    final DBUtil util = new DBUtil();
//    Connection con = util.getCon();
//    try {
//      queryRunner.update(con, sql, args);
//    } catch (SQLException e) {
//      e.printStackTrace();
//    } finally {
//      util.close();
//    }
//    return -1;
//  }
//  // 查询一条数据
//  // 查询返回一个JavaBean的sql语句
//  // type 返回的对象类型，sql 执行的sql语句 ，args sql对应的参数值 ，<T> 返回的类型的泛型
//  public <T> T queryForOne(Class<T> type, String sql, Object... args) {
//    final DBUtil util = new DBUtil();
//    Connection con = util.getCon();
//    try {
//      return queryRunner.query(con, sql, new BeanHandler<T>(type), sql);
//    } catch (SQLException e) {
//      e.printStackTrace();
//    } finally {
//      util.close();
//    }
//    return null;
//  }
//  //  查询一组数据
//  public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
//    final DBUtil util = new DBUtil();
//    Connection con = util.getCon();
//    try {
//      return queryRunner.query(con, sql, new BeanListHandler<T>(type), sql);
//    } catch (SQLException e) {
//      e.printStackTrace();
//    } finally {
//      util.close();
//    }
//    return null;
//  }
//  // 查询返回一行一列的数据
//  public Object queryForSingleValue(String sql, Object... args) {
//    final DBUtil util = new DBUtil();
//    Connection con = util.getCon();
//    try {
//      return queryRunner.query(con, sql, new ScalarHandler(), args);
//    } catch (SQLException e) {
//      e.printStackTrace();
//    } finally {
//      util.close();
//    }
//    return null;
//  }
// }
