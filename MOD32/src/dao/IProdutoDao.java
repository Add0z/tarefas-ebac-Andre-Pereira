package dao;


import domain.Produto;

import domain.Curso;
import domain.Matricula;

import java.util.List;

public interface IProdutoDao {

    Produto cadastrar( Produto produto);
    Produto buscarPorCodCurso ( String codigoCurso);
    Produto buscarPorCurso (Curso curso);

    Produto buscarPorCodMatricula ( String codigoMatricula);
    Produto buscarPorMatricula (Matricula matricula);

    List<Produto> buscarTodos();
    void excluir(Produto produto);




}
