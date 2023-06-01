package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.Instant;
import java.util.List;

import dao.*;
import domain.Produto;
import org.junit.After;
import org.junit.Test;

import domain.Curso;
import domain.Matricula;

public class ProdutoTest {

    private IMatriculaDao matriculaDao;

    private ICursoDao cursoDao;

    private IProdutoDao produtoDao;

    public ProdutoTest() {
        matriculaDao = new MatriculaDao();
        cursoDao = new CursoDao();
        produtoDao = new ProdutoDao();
    }

    @After
    public void end() {
        List<Produto> listProdutos = produtoDao.buscarTodos();
        listProdutos.forEach(prod -> produtoDao.excluir(prod));

        List<Matricula> list = matriculaDao.buscarTodos();
        list.forEach(mat -> matriculaDao.excluir(mat));

        List<Curso> listCursos = cursoDao.buscarTodos();
        listCursos.forEach(cur -> cursoDao.excluir(cur));



    }

    @Test
    public void cadastrarProd_Curso_Matricula(){
        Curso curso = criarCurso("A1");
        Matricula mat = criarMatricula("A1", curso);
        Produto produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Apostila Back-End  JAVA - MOD32");
        produto.setDigitalFisica("Digital");
        produto.setCurso(curso);
        produto.setMatricula(mat);
        produto = produtoDao.cadastrar(produto);

        assertNotNull(produto);
        assertNotNull(produto.getId());

    }

    private Matricula criarMatricula(String codigo, Curso curso) {
        Matricula matricula = new Matricula();
        matricula.setCodigo(codigo);
        matricula.setDataMatricula(Instant.now());
        matricula.setStatus("ATIVA");
        matricula.setValor(2000d);
        matricula.setCurso(curso);
        return matriculaDao.cadastrar(matricula);
    }

    private Curso criarCurso(String codigo) {
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setDescricao("CURSO TESTE");
        curso.setNome("Curso de Java Backend");
        return cursoDao.cadastrar(curso);
    }


    @Test
    public void pesquisarPorCurso(){

        Curso curso = criarCurso("A1");
        Matricula mat = criarMatricula("A1", curso);
        Produto produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Apostila Back-End  JAVA - MOD32");
        produto.setDigitalFisica("Digital");
        produto.setCurso(curso);
        produto.setMatricula(mat);
        produto = produtoDao.cadastrar(produto);

        assertNotNull(produto);
        assertNotNull(produto.getId());

        Produto produtoDB = produtoDao.buscarPorCurso(curso);
        assertNotNull(produtoDB);
        assertEquals(produto.getId(),produtoDB.getId());

    }

    @Test
    public void pesquisarPorCodCurso(){
        Curso curso = criarCurso("A1");
        Matricula mat = criarMatricula("A1", curso);
        Produto produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Apostila Back-End  JAVA - MOD32");
        produto.setDigitalFisica("Digital");
        produto.setCurso(curso);
        produto.setMatricula(mat);
        produto = produtoDao.cadastrar(produto);

        assertNotNull(produto);
        assertNotNull(produto.getId());

        Produto produtoDB = produtoDao.buscarPorCodCurso(curso.getCodigo());
        assertNotNull(produtoDB);
        assertEquals(produto.getId(),produtoDB.getId());
    }

    @Test
    public void pesquisarPorMatricula(){

        Curso curso = criarCurso("A1");
        Matricula mat = criarMatricula("A1", curso);
        Produto produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Apostila Back-End  JAVA - MOD32");
        produto.setDigitalFisica("Digital");
        produto.setCurso(curso);
        produto.setMatricula(mat);
        produto = produtoDao.cadastrar(produto);

        assertNotNull(produto);
        assertNotNull(produto.getId());

        Produto produtoDB = produtoDao.buscarPorMatricula(mat);
        assertNotNull(produtoDB);
        assertEquals(produto.getId(),produtoDB.getId());

    }

    @Test
    public void pesquisarPorCodMatricula(){
        Curso curso = criarCurso("A1");
        Matricula mat = criarMatricula("A1", curso);
        Produto produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Apostila Back-End  JAVA - MOD32");
        produto.setDigitalFisica("Digital");
        produto.setCurso(curso);
        produto.setMatricula(mat);
        produto = produtoDao.cadastrar(produto);

        assertNotNull(produto);
        assertNotNull(produto.getId());

        Produto produtoDB = produtoDao.buscarPorCodMatricula(mat.getCodigo());
        assertNotNull(produtoDB);
        assertEquals(produto.getId(),produtoDB.getId());
    }
}
