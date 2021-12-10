package Util;

import com.example.store.register;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    //获取数据库连接
    public static Connection getConnection() throws Exception{
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    //关闭数据库连接
    public static void closeResource(Connection connection, Statement ps){
        try {
            if(ps !=null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            if(connection!=null)
                connection.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void closeResource(Connection connection, Statement ps, ResultSet rs){
        try {
            if(ps !=null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            if(connection!=null)
                connection.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        try{
            if(rs!=null)
                rs.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
