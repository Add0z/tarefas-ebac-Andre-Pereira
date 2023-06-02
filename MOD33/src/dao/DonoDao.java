package dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import domain.Dono;

public class DonoDao implements IDonoDao{
    @Override
    public Dono cadastrar(Dono dono) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(dono);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return dono;
    }
}
