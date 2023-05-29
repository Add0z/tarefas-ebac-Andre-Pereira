import Annotation.TipoChave;
import Annotation.TipochaveExcep;
import Cliente.Cliente;
import Cliente.Dao.ClienteDao;
import Cliente.Dao.IClienteDao;
import Produto.Dao.IProdutoDAO;
import Produto.Dao.ProdutoDAO;
import Produto.Produto;
import Venda.Venda;
import Venda.Venda.Status;
import Venda.dao.IVendaDAO;
import Venda.dao.VendaDAO;
import org.junit.Before;
import org.junit.Test;
import java.time.Instant;


import java.math.BigDecimal;

import static org.junit.Assert.*;

public class VendaDAOTest {

    private IVendaDAO vendaDao;
    private IClienteDao clienteDao;
    private IProdutoDAO produtoDAO;
    private Cliente cliente;
    private Produto produto;

    public VendaDAOTest() {
        vendaDao = new VendaDAO();
        clienteDao = new ClienteDao();
        produtoDAO = new ProdutoDAO();
    }

    @Before
    public void init() throws TipochaveExcep{
        this.cliente = cadastrarCliente();
        this.produto = cadastrarProduto("11", BigDecimal.TEN);
    }

    @Test
    public void pesquisar() throws TipochaveExcep{
        Venda venda = criarVenda("11");
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        Venda vendaConsultada = vendaDao.consultar(String.valueOf(venda.getCodigo()));
        assertNotNull(vendaConsultada);
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
    }

    @Test
    public void salvar() throws TipochaveExcep{
        Venda venda = criarVenda("12");
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
        assertTrue(venda.getStatus().equals(Status.INICIADA));
    }

    @Test
    public void cancelarVenda () throws TipochaveExcep{
        String codigoVenda = "13";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());
        venda.setStatus(Status.CANCELADA);
        vendaDao.alterar(venda);
        Venda vendaConsultada = vendaDao.consultar(String.valueOf(codigoVenda));
        assertEquals(codigoVenda,vendaConsultada.getCodigo());
        assertEquals(Status.CANCELADA, vendaConsultada.getStatus());

    }


    @Test
    public void adicionarMaisUmProdutoIgual() throws TipochaveExcep{
        String codigoVenda = "14";
        String codigoVendaString = "14";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        Venda vendaConsultada = vendaDao.consultar(codigoVenda);
        vendaConsultada.adicionarProduto(produto, 1);

        assertTrue(venda.getQuantidadeTotalProdutos() == 3);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(30)));
        assertTrue(venda.getStatus().equals(Status.INICIADA));
    }

    @Test
    public void adicionarMaisProdutosDiferentes() throws TipochaveExcep {
        String codigoVenda = "15";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        Venda vendaConsultada = vendaDao.consultar(codigoVenda);
        vendaConsultada.adicionarProduto(prod, 1);

        assertTrue(venda.getQuantidadeTotalProdutos() == 3);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));
        assertTrue(venda.getStatus().equals(Status.INICIADA));
    }

    @Test
    public void salvarProdutoExistente() throws TipochaveExcep {
        Venda venda = criarVenda("16");
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);

        Boolean retorno1 = vendaDao.cadastrar(venda);
        assertFalse(retorno1);
        assertTrue(venda.getStatus().equals(Status.INICIADA));
    }

    @Test
    public void removerProduto() throws TipochaveExcep {
        String codigoVenda = "17";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        Venda vendaConsultada = vendaDao.consultar(String.valueOf(codigoVenda));
        vendaConsultada.adicionarProduto(prod, 1);
        assertTrue(venda.getQuantidadeTotalProdutos() == 3);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));


        vendaConsultada.removerProduto(prod, 1);
        assertTrue(venda.getQuantidadeTotalProdutos() == 2);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
        assertTrue(venda.getStatus().equals(Status.INICIADA));
    }

    @Test
    public void removerApenasUmProduto() throws TipochaveExcep {
        String codigoVenda = "18";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        Venda vendaConsultada = vendaDao.consultar(String.valueOf(codigoVenda));
        vendaConsultada.adicionarProduto(prod, 1);
        assertTrue(venda.getQuantidadeTotalProdutos() == 3);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));


        vendaConsultada.removerProduto(prod, 1);
        assertTrue(venda.getQuantidadeTotalProdutos() == 2);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(20)));
        assertTrue(venda.getStatus().equals(Status.INICIADA));
    }

    @Test
    public void removerTodosProdutos() throws TipochaveExcep {
        String codigoVenda = "19";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        Produto prod = cadastrarProduto(codigoVenda, BigDecimal.valueOf(50));
        assertNotNull(prod);
        assertEquals(codigoVenda, prod.getCodigo());

        Venda vendaConsultada = vendaDao.consultar(String.valueOf(codigoVenda));
        vendaConsultada.adicionarProduto(prod, 1);
        assertTrue(venda.getQuantidadeTotalProdutos() == 3);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(70)));


        vendaConsultada.removerTodosProdutos();
        assertTrue(venda.getQuantidadeTotalProdutos() == 0);
        assertTrue(venda.getValorTotal().equals(BigDecimal.valueOf(0)));
        assertTrue(venda.getStatus().equals(Status.INICIADA));
    }

    @Test
    public void finalizarVenda() throws TipochaveExcep {
        String codigoVenda = "20";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        vendaDao.finalizarVenda(venda);

        Venda vendaConsultada = vendaDao.consultar(String.valueOf(codigoVenda));
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
        assertEquals(venda.getStatus(), vendaConsultada.getStatus());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void tentarAdicionarProdutosVendaFinalizada() throws TipochaveExcep {
        String codigoVenda = "21";
        Venda venda = criarVenda(codigoVenda);
        Boolean retorno = vendaDao.cadastrar(venda);
        assertTrue(retorno);
        assertNotNull(venda);
        assertEquals(codigoVenda, venda.getCodigo());

        vendaDao.finalizarVenda(venda);
        Venda vendaConsultada = vendaDao.consultar(String.valueOf(codigoVenda));
        assertEquals(venda.getCodigo(), vendaConsultada.getCodigo());
        assertEquals(venda.getStatus(), vendaConsultada.getStatus());

        vendaConsultada.adicionarProduto(this.produto, 1);

    }

    private Produto cadastrarProduto(String codigo, BigDecimal valor) throws TipochaveExcep {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(valor);
        produtoDAO.cadastrar(produto);
        return produto;
    }

    private Cliente cadastrarCliente() throws TipochaveExcep {
        Cliente cliente = new Cliente();
        cliente.setCpf(12312312312l);
        cliente.setNome("Rodrigo");
        cliente.setEnd("End");
        cliente.setTel(1199999999L);
        clienteDao.cadastrar(cliente);
        return cliente;
    }

    private Venda criarVenda(String codigo) {
        Venda venda = new Venda();
        venda.setCodigo(codigo);
        venda.setDataVenda(Instant.now());
        venda.setCliente(this.cliente);
        venda.setStatus(Status.INICIADA);
        venda.adicionarProduto(this.produto, 2);
        return venda;
    }

}
































