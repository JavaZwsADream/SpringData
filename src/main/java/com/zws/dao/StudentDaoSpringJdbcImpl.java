package com.zws.dao;

import com.zws.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoSpringJdbcImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Student> query() {
        final List<Student> list = new ArrayList<>();
        String sql = "select * from student";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    Student student = new Student();
                    student.setId(id);
                    student.setName(name);
                    student.setAge(age);
                    list.add(student);
                }
            }
        });

        return list;
    }

    @Override
    public void Save(Student student) {

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
