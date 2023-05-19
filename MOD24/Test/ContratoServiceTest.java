import dao.ContratoDao;
import dao.IContratoDao;
import dao.mock.ContratoDaoMock;
import org.junit.Assert;
import org.junit.Test;
import service.ContratoService;
import service.IContratoService;

public class ContratoServiceTest {
    @Test
    public void salvarTest(){
        IContratoDao DaoDao = new ContratoDaoMock();
        IContratoService service = new ContratoService(DaoDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso contrato salvar", retorno);
    }
    @Test
    public void buscarTest(){
        IContratoDao DaoDao = new ContratoDaoMock();
        IContratoService service = new ContratoService(DaoDao);
        String retorno = service.buscar();
        Assert.assertEquals("Sucesso contrato buscar", retorno);
    }


    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoBuscarTest() {
        IContratoDao DaoDao = new ContratoDao();
        ContratoService service = new ContratoService(DaoDao);
        String retorno = service.buscar();
        Assert.assertEquals("Sucesso contrato buscar", retorno);
    }

    @Test
    public void ExcluirTest(){
        IContratoDao DaoDao = new ContratoDaoMock();
        IContratoService service = new ContratoService(DaoDao);
        String retorno = service.excluir();
        Assert.assertEquals("Sucesso contrato excluir", retorno);
    }


    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoExcluirTest() {
        IContratoDao DaoDao = new ContratoDao();
        ContratoService service = new ContratoService(DaoDao);
        String retorno = service.excluir();
        Assert.assertEquals("Sucesso contrato excluir", retorno);
    }

    @Test
    public void AlterarTest(){
        IContratoDao DaoDao = new ContratoDaoMock();
        IContratoService service = new ContratoService(DaoDao);
        String retorno = service.alterar();
        Assert.assertEquals("Sucesso contrato alterar", retorno);
    }


    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoAlterarTest() {
        IContratoDao DaoDao = new ContratoDao();
        ContratoService service = new ContratoService(DaoDao);
        String retorno = service.alterar();
        Assert.assertEquals("Sucesso contrato alterar", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvar(){
        IContratoDao DaoDao = new ContratoDao();
        IContratoService service = new ContratoService(DaoDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso contrato salvar", retorno);
    }
}
