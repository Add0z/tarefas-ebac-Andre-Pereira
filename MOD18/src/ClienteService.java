import excep.ClienteNaoEncontradoException;

public class ClienteService {
    public static Object consultarCliente;

    public static void consultarCliente(String codigo) throws ClienteNaoEncontradoException {
        boolean IsCadastrado = false;

        if(!IsCadastrado) {
            throw new ClienteNaoEncontradoException("não encontrado");
        }
    }
}
