package com.zws.dao;

import com.zws.domain.Student;

import java.util.List;

/**
 * studentdao访问接口
 */
public interface StudentDao {

    List<Student> query();
    void Save(Student student);

}
