package com.zws.util;

import com.zws.dao.StudentDao;
import com.zws.dao.StudentDaoImpl;
import com.zws.domain.Student;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentDaoImpltest {
    @Test
    public void testBStudentQuery()
    {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> list=studentDao.query();
        for (Student student : list) {
            System.out.println(student.getId());
            System.out.println(student.getName());
            System.out.println(student.getAge());
        }

    }
    @Test
    public void testASave()
    {
        Student student=new Student();
        student.setName("com");
        student.setAge(23);
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.Save(student);
    }
}
