import DaoJpa.*;
import DomainJpa.ClienteJpa;
import DomainJpa.ProdutoJpa;
import DomainJpa.VendaJpa;
import exception.DAOException;
import exception.MaisDeUmRegistroException;
import exception.TableException;
import exception.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.*;

public class VendaDaoJpaTest {

    private IVendaDaoJpa vendaDaoJpa;
    private IVendaDaoJpa vendaExclusaoDao;
    private IClienteDaoJpa clienteDaoJpa;
    private IProdutoDaoJpa produtoDaoJpa;
    private Random rd;
    private ClienteJpa clienteJpa;
    private ProdutoJpa produtoJpa;

    public VendaDaoJpaTest(){
        this.vendaDaoJpa = new VendaDaoJpa();
        vendaExclusaoDao = new VendaExclusaoDaoJpaTest();
        this.clienteDaoJpa = new ClienteDaoJpa();
        this.produtoDaoJpa = new ProdutoDaoJpa();
        rd = new Random();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        this.clienteJpa = cadastrarCliente();
        this.produtoJpa = cadastrarProduto("A111", BigDecimal.TEN);
    }

    private ProdutoJpa cadastrarProduto(String a1, BigDecimal valor) throws DAOException, TipoChaveNaoEncontradaException {
        ProdutoJpa produtoJpa = new ProdutoJpa();
        produtoJpa.setCodigo(a1);
        produtoJpa.setDescricao("Produto 1");
        produtoJpa.setNome("Produto 1");
        produtoJpa.setValor(valor);
        produtoJpa.setPacote("S");
        produtoJpa.setEstoque(10);
        produtoDaoJpa.cadastrar(produtoJpa);
        return produtoJpa;
    }

    private ClienteJpa cadastrarCliente() throws DAOException, TipoChaveNaoEncontradaException {
        ClienteJpa clienteJpa = new ClienteJpa();
        clienteJpa.setCpf(rd.nextLong());
        clienteJpa.setNome("Andre");
        clienteJpa.setCidade("Santa Catarina");
        clienteJpa.setEnd("End");
        clienteJpa.setEstado("SC");
        clienteJpa.setNumero(102);
        clienteJpa.setTel(33333333333L);
        //	TAREFA MOD30 -------------------------------------------
        clienteJpa.setSexo("M");
        clienteDaoJpa.cadastrar(clienteJpa);
        return clienteJpa;
    }

    @After
    public void end() throws DAOException{
        excluirVendas();
        excluirProdutos();
        clienteDaoJpa.excluir(this.clienteJpa);
    }

    private void excluirProdutos() throws DAOException {
        Collection< ProdutoJpa> list = this.produtoDaoJpa.buscarTodos();
        list.forEach(produtoJpa1 -> {
            try {
                this.produtoDaoJpa.excluir(produtoJpa1);
            } catch (DAOException e ){
                e.printStackTrace();
            }
        });
    }

    private void excluirVendas() throws DAOException {
        Collection<VendaJpa> list = this.vendaExclusaoDao.buscarTodos();
        list.forEach(prod -> {
            try {
                this.vendaExclusaoDao.excluir(prod);
            } catch (DAOException e){
                e.printStackTrace();
            }
        });

    }

    @Test
    public void pesquisar() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        VendaJpa vendaJpa = criarVenda("A1");
        VendaJpa retorno = vendaDaoJpa.cadastrar(vendaJpa);
        assertNotNull(retorno);
        VendaJpa vendaConsulta = vendaDaoJpa.consultar(vendaJpa.getId());
        assertNotNull(vendaConsulta);
        assertEquals(vendaJpa.getCodigo(),vendaConsulta.getCodigo());
    }

    private VendaJpa criarVenda(String codigo) {
        VendaJpa vendaJpa = new VendaJpa();
        vendaJpa.setCodigo(codigo);
        vendaJpa.setDataVenda(Instant.now());
        vendaJpa.setCliente(this.clienteJpa);
        vendaJpa.setStatus(VendaJpa.Status.INICIADA);
        vendaJpa.adicionarProduto(this.produtoJpa,2,10);
        return vendaJpa;
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        VendaJpa vendaJpa = criarVenda("A2");
        VendaJpa retorno = vendaDaoJpa.cadastrar(vendaJpa);
        assertNotNull(retorno);

        assertTrue(vendaJpa.getValorTotal().equals(BigDecimal.valueOf(20)));
        assertTrue(vendaJpa.getStatus().equals(VendaJpa.Status.INICIADA));

        VendaJpa vendaConsultada = vendaDaoJpa.consultar(vendaJpa.getId());
        assertTrue(vendaConsultada.getId()!= null);
        assertEquals(vendaJpa.getCodigo(), vendaConsultada.getCodigo());
    }

    @Test
    public void cancelarVenda () throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A3";
        VendaJpa vendaJpa = criarVenda(codigoVenda);
        VendaJpa retorno = vendaDaoJpa.cadastrar(vendaJpa);
        assertNotNull(retorno);
        assertNotNull(vendaJpa);
        assertEquals(codigoVenda, vendaJpa.getCodigo());

        retorno.setStatus(VendaJpa.Status.CANCELADA);
        vendaDaoJpa.cancelarVenda(vendaJpa);

        VendaJpa vendaConsultada = vendaDaoJpa.consultar(vendaJpa.getId());
        assertEquals(codigoVenda, vendaConsultada.getCodigo());
        assertEquals(VendaJpa.Status.CANCELADA, vendaConsultada.getStatus());
    }

    @Test
    public void adicionarMaisProdutosDoMesmo() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A4";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaDaoJpa.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        VendaJpa vendaConsultada = vendaDaoJpa.consultarCollection(venda.getId());
        vendaConsultada.adicionarProduto(produtoJpa, 1, 10);

        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(30).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
        assertTrue(vendaConsultada.getStatus().equals(VendaJpa.Status.INICIADA));
    }

    @Test
    public void adicionarMaisProdutosDiferentes() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A5";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaDaoJpa.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        VendaJpa vendaConsultada = vendaDaoJpa.consultarCollection(venda.getId());
        vendaConsultada.adicionarProduto(prod, 1, 10);

        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
        assertTrue(vendaConsultada.getStatus().equals(VendaJpa.Status.INICIADA));
    }

    @Test(expected = DAOException.class)
    public void salvarVendaMesmoCodigoExistente() throws TipoChaveNaoEncontradaException, DAOException {
        VendaJpa venda = criarVenda("A6");
        VendaJpa retorno = vendaDaoJpa.cadastrar(venda);
        assertNotNull(retorno);

        VendaJpa venda1 = criarVenda("A6");
        VendaJpa retorno1 = vendaDaoJpa.cadastrar(venda1);
        assertNull(retorno1);
        assertTrue(venda.getStatus().equals(VendaJpa.Status.INICIADA));
    }

    @Test
    public void removerProduto() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A7";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaDaoJpa.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        VendaJpa vendaConsultada = vendaDaoJpa.consultarCollection(venda.getId());
        vendaConsultada.adicionarProduto(prod, 1,10);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));


        vendaConsultada.removerProduto(prod, 1);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 2);
        valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
        assertTrue(vendaConsultada.getStatus().equals(VendaJpa.Status.INICIADA));
    }

    @Test
    public void removerApenasUmProduto() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A8";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaDaoJpa.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        VendaJpa vendaConsultada = vendaDaoJpa.consultarCollection(venda.getId());
        vendaConsultada.adicionarProduto(prod, 1, 10);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));


        vendaConsultada.removerProduto(prod, 1);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 2);
        valorTotal = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));
        assertTrue(vendaConsultada.getStatus().equals(VendaJpa.Status.INICIADA));
    }

    @Test
    public void removerTodosProdutos() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A9";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaDaoJpa.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        ProdutoJpa prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        VendaJpa vendaConsultada = vendaDaoJpa.consultarCollection(venda.getId());
        vendaConsultada.adicionarProduto(prod, 1,10);
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 3);
        BigDecimal valorTotal = BigDecimal.valueOf(70).setScale(2, RoundingMode.HALF_DOWN);;
        assertTrue(vendaConsultada.getValorTotal().equals(valorTotal));


        vendaConsultada.removerTodosProdutos();
        assertTrue(vendaConsultada.getQuantidadeTotalProdutos() == 0);
        assertTrue(vendaConsultada.getValorTotal().equals(BigDecimal.valueOf(0)));
        assertTrue(vendaConsultada.getStatus().equals(VendaJpa.Status.INICIADA));
    }

    @Test
    public void finalizarVenda() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A10";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaDaoJpa.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        venda.setStatus(VendaJpa.Status.CONCLUIDA);
        vendaDaoJpa.finalizarVenda(venda);

        VendaJpa vendaConsultada = vendaDaoJpa.consultarCollection(venda.getId());
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
        assertEquals(VendaJpa.Status.CONCLUIDA, vendaConsultada.getStatus());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void tentarAdicionarProdutosVendaFinalizada() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
        String codigoVenda = "A11";
        VendaJpa venda = criarVenda(codigoVenda);
        VendaJpa retorno = vendaDaoJpa.cadastrar(venda);
        assertNotNull(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        venda.setStatus(VendaJpa.Status.CONCLUIDA);
        vendaDaoJpa.finalizarVenda(venda);

        VendaJpa vendaConsultada = vendaDaoJpa.consultarCollection(venda.getId());
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
        assertEquals(VendaJpa.Status.CONCLUIDA, vendaConsultada.getStatus());

        vendaConsultada.adicionarProduto(this.produtoJpa, 1, 10);

    }









}
