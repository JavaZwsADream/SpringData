package com.zws.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class testJdbcTemple {

private ApplicationContext ctx=null;

    @Before
    public void set()
    {
        ctx=new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup");
    }
    @After
    public void shutdown()
    {
        ctx=null;
        System.out.println("shutdown");
    }
    @Test
    public  void testTemple()
    {
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.assertNotNull(dataSource);
    }
    @Test
    public  void testTemplelate()
    {
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTempleate");
        Assert.assertNotNull(jdbcTemplate);
    }

}
