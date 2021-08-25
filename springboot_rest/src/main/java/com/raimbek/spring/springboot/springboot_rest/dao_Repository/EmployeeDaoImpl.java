package com.raimbek.spring.springboot.springboot_rest.dao_Repository;

import com.raimbek.spring.springboot.springboot_rest.entity.Employee;
//import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
//import org.hibernate.query.Query;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getListEmployees() {
        /* Здесь в основоном работаем с библиотекой и технологией hibernate*/
//        Session session = entityManager.unwrap(Session.class);
//        List<Employee> employees = session.createQuery
//                ("from Employee ", Employee.class).getResultList();
/* A здесь будем использовать чисто JPA. JPA это правила, а hibernate его один из вариантв реализации*/
        Query query = entityManager.createQuery("from Employee");
        List <Employee> employeeList= query.getResultList();
        return employeeList;
    }
    @Override
    public Employee getEmployeeById(int id) {
        /* используем функционал хайбернэйт*/
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class,id);

        //а здесь используем функционал JPA
        Employee employee= entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        /* Здесь в основоном работаем с библиотекой и технологией hibernate*/
////        Session session = entityManager.unwrap(Session.class);
//
//        session.saveOrUpdate(employee);


        // это функционал JPA
        entityManager.merge(employee);

    }





    @Override
    public void deleteEmployee(int id) {
        /*Здесь был использован функционал Hirbernate*/
//        Session session= entityManager.unwrap(Session.class);
//        Query <Employee> query =session.createQuery("delete Employee " +
//                "where  id= :employeeId ");
//        query.setParameter("employeeId",id);
//        query.executeUpdate();

        /* здесь используем функционал JPA*/
        Query query= entityManager.createQuery("delete from Employee " +
                "where id =:employeeId");
        query.setParameter("employeeId",id);
        query.executeUpdate();

    }
}
