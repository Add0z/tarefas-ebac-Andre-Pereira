package excep;

import javax.swing.*;
import java.awt.*;

public class Appcliente {

    public static void main(String args[]){
        String opcao = JOptionPane.showInputDialog(null, "code", "", JOptionPane.INFORMATION_MESSAGE);
        try {
            ClienteService.consultarCliente(opcao);

        } catch (ClienteNaoEncontradoException e ){
            System.out.println(e.getMessage());
        }

    }
}
