package com.zws.util;

import com.zws.dao.StudentDao;
import com.zws.domain.Student;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class JDBCUtilTest {
    private ApplicationContext ctx=null;
    private StudentDao studentDao=null;
    @Test
    public  void testGetConnection() throws ClassNotFoundException, IOException {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);

    }

    @Test
    public void testSpringJdbc()
    {
        ctx=new ClassPathXmlApplicationContext("beans.xml");
        StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");
        List<Student> list = studentDao.query();
        for (Student student : list) {
            System.out.println(student.getId());
            System.out.println(student.getName());
            System.out.println(student.getAge());
        }
    }
}
