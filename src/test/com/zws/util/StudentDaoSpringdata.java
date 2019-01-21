package com.zws.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentDaoSpringdata {
   private ApplicationContext ctx;
    @Before
    public void setup()
    {
        ctx=new ClassPathXmlApplicationContext("beans-new.xml");
    }

    @After
    public  void shutdown()
    {
        ctx=null;
    }
    @Test
    public void testSpringdataTest()
    {

    }

}
