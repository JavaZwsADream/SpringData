package com.zws.respository;

import com.zws.domain.Employee;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
public interface EmployeeRepository  {
    Employee findByName(String name);

    //select Employee from XX where name like and age<;

    @Query("select o from Employee o where name like %:name% and age<:age ")
    Employee fingByNameAndAge(@Param("name") String name, @Param("age")Integer age);

    @Query(nativeQuery=true,value = "select id,age,name from employee where name like %:name% and age<:age")
    Employee fingByNameAndAge1(@Param("name") String name, @Param("age")Integer age);

    @Modifying
    @Query("update Employee o set o.name=:name where o.id=:id")
     void modify(@Param("name") String name,@Param("id") Integer id);
}
