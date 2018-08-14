package com.hand.dao;

import com.hand.pojo.User;
import sun.security.pkcs11.Secmod;

import java.io.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;


public class DBPool {
    // 连接池
    public static Vector<Connection> connectionPool = new Vector<Connection>();
    static {
       // Properties pro = new Properties();


      //  InputStream is=DBPool.class.getResourceAsStream("db.properties");
        try {
         //   pro.load(is);
         //   String driver ="com.mysql.jdbc.Driver";
      //              pro.getProperty("driver");
            String url ="jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC";
      //              pro.getProperty("url");
            String username = "root";
        //            pro.getProperty("username");
            String password = "root";
         //           pro.getProperty("password");
           // System.out.println(driver);

            Class.forName("com.mysql.cj.jdbc.Driver");
            for (int i = 0; i < 5; i++) {
                Connection con = DriverManager.getConnection(url, username, password);
               // System.out.println(con);
                connectionPool.add(con);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 取连接
    public static Connection getCon() {
        Connection con = null;
        if (connectionPool.size() > 0) {
            con = connectionPool.get(0);
            connectionPool.remove(0);
        } else {
            try {
                throw new Exception("连接池为空，请等待！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }
    // 放回连接
    public static void closeCon(Connection con) {
        connectionPool.add(con);
    }

    //通用查询
    public static List query(Class c, String sql, Object... p) {
        List list = new ArrayList();
        ResultSet rs = null;
       // System.out.println(sql);
        Connection con = getCon();
       // System.out.println(con);
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            for (int i = 0; i < p.length; i++) {
                pre.setObject(i + 1, p[i]);
            }
            rs = pre.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int count = rsmd.getColumnCount();// 得到总列数

            while (rs.next()) {
                Object object = c.newInstance();

                for (int i = 1; i <= count; i++) {
                    String fieldname = rsmd.getColumnLabel(i);
                    Field field = c.getDeclaredField(fieldname);
                    field.setAccessible(true);
                    field.set(object, rs.getObject(i));
                }
                list.add(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }

        return list;
    }
    // 通用增 删除，改
    public static int ZSG(String sql, Object... p) {
        int n = 0;
        Connection con = null;
        try {
            con = getCon();

            PreparedStatement pre = con.prepareStatement(sql);

            for (int i = 0; i < p.length; i++) {
                pre.setObject(i + 1, p[i]);
            }

            n = pre.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
        return n;
    }
    // 聚集查询
    public static int uniqueQuery(String sql, Object... p) {
        List list = new ArrayList();
        Connection connection = getCon();

        int n = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            if (p != null) {
                for (int i = 0; i < p.length; i++) {
                    ps.setObject(i + 1, p[i]);
                }
            }

            ResultSet rs = ps.executeQuery();
            rs.next();
            n = rs.getInt(1);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeCon(connection);
        }

        return n;
    }
    public static void main(String[] args) {

    }
}
