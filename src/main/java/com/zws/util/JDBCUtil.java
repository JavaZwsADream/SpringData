package com.zws.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * jdbc工具类
 */
public class JDBCUtil {
    /**
     * 获取jdbc的connection
     * @return 获取到的connection
     */
    public static Connection getConnection() throws ClassNotFoundException, IOException {
        Connection connection=null;
//        String url="jdbc:mysql://localhost:3306/spring_data";
//        String user="root";
//        String password="root";
//        String driverClass="com.mysql.jdbc.Driver";


        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties=new Properties();
        properties.load(inputStream);
        String url=properties.getProperty("jdbc.url");
        String user=properties.getProperty("jdbc.user");
        String password=properties.getProperty("jdbc.password");
        String driverClass=properties.getProperty("jdbc.driverclass");


        Class.forName(driverClass);
        try {
             connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  connection;
    }
          public  static  void  release(ResultSet rs, PreparedStatement st,Connection con)
          {
              if(rs!=null)
              {
                  try {
                      rs.close();
                  } catch (SQLException e) {
                      e.printStackTrace();
                  }

              }if(st!=null)
          {
              try {
                  st.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }if(con!=null)
          {
              try {
                  con.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }

          }
}
