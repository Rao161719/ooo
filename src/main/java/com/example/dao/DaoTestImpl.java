package com.example.dao;

import com.example.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoTestImpl implements DaoTest {
    /*查询*/
    @Override
    public List getStudent() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List list = new ArrayList();
        Student stu = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "select * from students";
             ps = conn.prepareStatement(sql);
             rs = ps.executeQuery();
            while (rs.next()){
                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                String sbirthday = rs.getString("sbirthday");
                String clas = rs.getString("class");
                stu = new Student(sno,sname,ssex,sbirthday,clas);
                list.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public int delStudent(String s) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
             conn = JDBCUtil.getConnection();
            String sql = "delete from students where sno = ?";
             ps = conn.prepareStatement(sql);
            ps.setString(1,s);
            count = ps.executeUpdate();
            System.out.println("count="+count);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return count;
    }

    /*插入*/
    @Override
    public int inStudent(Student stu) {
        String sql = "insert into students values(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
             conn = JDBCUtil.getConnection();
             ps = conn.prepareStatement(sql);
             ps.setString(1,stu.getNo());
             ps.setString(2,stu.getName());
             ps.setString(3,stu.getSex());
             ps.setString(4,stu.getSbirthday());
             ps.setString(5,stu.getClas());
             count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int upStudent() {
        return 0;
    }
}
