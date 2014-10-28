package kr.sadalmelik.jpa;

import kr.sadalmelik.jpa.domain.Address;
import kr.sadalmelik.jpa.domain.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

        Address address = new Address()
                .setCity("Seoul")
                .setCountry("South Korea")
                .setPostcode("123-123")
                .setStreet("Jangchung-ro");

        Employee employee = new Employee();
        employee.setFirstName("Sejong");
        employee.setLastName("Park");
        employee.setSalary(new BigDecimal("3300"));
        employee.setAddress(address);

        em.getTransaction().begin();

        em.persist(address);
        em.persist(employee);


        System.out.println(employee.getId());
        System.out.println(address.getId());

    }
}