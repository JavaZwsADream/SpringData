package com.zws.dao;

import com.zws.domain.Student;
import com.zws.util.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{


    @Override
    public List<Student> query() {
        List<Student> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
           conn = JDBCUtil.getConnection();
           String sql="select * from student";
           preparedStatement = conn.prepareStatement(sql);
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next())
           {
               int id=resultSet.getInt("id");
               String name=resultSet.getString("name");
               int age=resultSet.getInt("age");
               Student student=new Student();
               student.setId(id);
               student.setName(name);
               student.setAge(age);
               list.add(student);
           }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
             JDBCUtil.release(resultSet,preparedStatement,conn);
        }

        return list;
    }

    @Override
    public void Save(Student student) {

        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            conn = JDBCUtil.getConnection();
            String sql="insert into student(name,age) values(?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet,preparedStatement,conn);
        }

    }
}
