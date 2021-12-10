package Dao;

import Util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    public static void updata(String sql,Object ...args){
        Connection conn=null;
        PreparedStatement ps=null;

        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,ps);
        }
    }
    //查询单条数据
    public <T> T getInstance(Class<T> clazz, String sql, Object... args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int columnCount=rsmd.getColumnCount();
//            System.out.println("获取到的总列数为： " + columnCount);

            if (rs.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {

                    Object columValue=rs.getObject(i+1);
                    String columLabel=rsmd.getColumnLabel(i+1);

                    Field field = clazz.getDeclaredField(columLabel);
                    field.setAccessible(true);
                    field.set(t,columValue);

                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }

    //查询多条数据
    public <T> List<T> getSult(Class<T> clazz,String sql, Object ...args){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int columCount=rsmd.getColumnCount();
            ArrayList<T> list=new ArrayList<>();
            while(rs.next()){
                T t=clazz.getDeclaredConstructor().newInstance();
                for(int i=0;i<columCount;i++){

                    Object columValue=rs.getObject(i+1);
                    String columLabel=rsmd.getColumnLabel(i+1);

                    Field field = clazz.getDeclaredField(columLabel);
                    field.setAccessible(true);
                    field.set(t,columValue);
                }
                list.add(t);
//                System.out.println(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }

}
