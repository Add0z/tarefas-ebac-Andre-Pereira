package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import domain.Curso;
import domain.Matricula;
import domain.Produto;

public class ProdutoDao implements IProdutoDao {
    @Override
    public Produto cadastrar(Produto produto) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return produto;
    }

    @Override
    public Produto buscarPorCodCurso(String codigoCurso) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT p FROM Produto p ");
        sb.append("INNER JOIN Curso c on c = p.curso ");
        sb.append("WHERE c.codigo = :codigoCurso");

        entityManager.getTransaction().begin();
        TypedQuery<Produto> query =
                entityManager.createQuery(sb.toString(), Produto.class);
        query.setParameter("codigoCurso", codigoCurso);
        Produto produto = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }

    @Override
    public Produto buscarPorCurso(Curso curso) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT p FROM Produto p ");
        sb.append("INNER JOIN Curso c on c = p.curso ");
        sb.append("WHERE c = :curso");

        entityManager.getTransaction().begin();
        TypedQuery<Produto> query =
                entityManager.createQuery(sb.toString(), Produto.class);
        query.setParameter("curso", curso);
        Produto produto = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }

    @Override
    public Produto buscarPorCodMatricula(String codigoMatricula) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT p FROM Produto p ");
        sb.append("INNER JOIN Matricula m on m = p.matricula ");
        sb.append("WHERE m.codigo = :codigoMatricula");

        entityManager.getTransaction().begin();
        TypedQuery<Produto> query =
                entityManager.createQuery(sb.toString(), Produto.class);
        query.setParameter("codigoMatricula", codigoMatricula);
        Produto produto = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }

    @Override
    public Produto buscarPorMatricula(Matricula matricula) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT p FROM Produto p ");
        sb.append("INNER JOIN Matricula m on m = p.matricula ");
        sb.append("WHERE m = :matricula");

        entityManager.getTransaction().begin();
        TypedQuery<Produto> query =
                entityManager.createQuery(sb.toString(), Produto.class);
        query.setParameter("matricula", matricula);
        Produto produto = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }

    @Override
    public List<Produto> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> root = query.from(Produto.class);
        query.select(root);

        TypedQuery<Produto> tpQuery =
                entityManager.createQuery(query);
        List<Produto> list = tpQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return list;
    }

    @Override
    public void excluir(Produto produto) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto);
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
