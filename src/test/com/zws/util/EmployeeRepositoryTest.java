package com.zws.util;

import com.zws.Service.EmployeeService;
import com.zws.domain.Employee;
import com.zws.respository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeRepositoryTest {

    private ApplicationContext ctx;
    private EmployeeService employeeService;
    @Before
    public void setup()
    {
        ctx=new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService = ctx.getBean(EmployeeService.class);
    }

    @After
    public  void shutdown()
    {
        ctx=null;
    }

//    @Test
//    public  void testFindByName()
//    {
//        Employee com = employeeRepository.findByName("zhangsan");
//        System.out.println(com);
//
//    }
//
//    @Test
//    public  void fingByNameAndAge()
//    {
//        Employee com = employeeRepository.fingByNameAndAge("zhangsan",22);
//        System.out.println(com);
//
//    }
//
//
//    @Test
//    public  void fingByNameAndAge1()
//    {
//        Employee com = employeeRepository.fingByNameAndAge1("zhangsan",22);
//        System.out.println(com);
//
//    }
    @Test
    public void testUpdate()
    {
        employeeService.update("zouwensheng",1);
    }
}
