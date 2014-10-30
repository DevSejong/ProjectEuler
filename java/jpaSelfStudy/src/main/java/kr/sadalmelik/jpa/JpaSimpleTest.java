package kr.sadalmelik.jpa;

import kr.sadalmelik.jpa.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaSimpleTest {

    public static void main(String[] args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpa-example");

        EntityManager em = emFactory.createEntityManager();

        Employee employee = new Employee("Sejong Park", "email@test.com");
        em.getTransaction().begin();
        // Create
        em.persist(employee);

        // Read
        Employee storedEmployee1 = em.find(Employee.class, employee.getId());
        System.out.println(storedEmployee1);

        //Update
        employee.setEmail("new-email@test.com");

        Employee storedEmployee2 = em.find(Employee.class, employee.getId());
        System.out.println(storedEmployee2);

        //Delete
        em.remove(employee);

        Employee storedEmployee3 = em.find(Employee.class, employee.getId());
        System.out.println(storedEmployee3);

        em.getTransaction().commit();
        em.close();

    }
}