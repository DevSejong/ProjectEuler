package kr.sadalmelik.jpa;

import kr.sadalmelik.jpa.domain.Address;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

        Address address = new Address()
                .setCity("Seoul")
                .setCountry("South Korea")
                .setPostcode("123-123")
                .setStreet("Choongmu-ro");

        em.getTransaction().begin();
        // Create
        em.persist(address);

        // Read
        Address storedAddress1 = em.find(Address.class, address.getId());
        System.out.println(storedAddress1);

        //Update
        storedAddress1.setCity("Busan")
                .setStreet("Gayadae-ro")
                .setPostcode("321-321");

        Address storedAddress2 = em.find(Address.class, address.getId());
        System.out.println(storedAddress2);

        //Delete
        em.remove(address);

        Address storedAddress3 = em.find(Address.class, address.getId());
        System.out.println(storedAddress3);

        em.getTransaction().rollback();
        em.close();

    }
}