// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class PrimeiraClasse {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.cadastrarEndereco("Rua 1");
        cliente.setCodigo(1);
        System.out.println(cliente.getCodigo());
        //cliente.imprimirEndereco();
        System.out.println(cliente.retornarNomeCliente());
        System.out.println(cliente.getValorTotal());

    }
    }
