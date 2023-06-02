package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import domain.Carro;

public class CarroDao implements ICarroDao {
    @Override
    public Carro cadastrar(Carro carro) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return carro;
    }
}
