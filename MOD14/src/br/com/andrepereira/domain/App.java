package br.com.andrepereira.domain;

import br.com.andrepereira.DAO.ClienteMapDAO;
import br.com.andrepereira.DAO.IClienteDAO;

import javax.swing.*;

public class App {

    private static ClienteMapDAO iClienteDAO;

    public static void main(String args[]) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,"" +
                "Digite " +
                "1: Cadastro| " +
                "2: Consultar| " +
                "3: Excluir| " +
                "4: Alterar| " +
                "5: SAIR" ,
                "CADASTRO",JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,"" +
                            "--Opção Inválida-- " +
                            "1: Cadastro| " +
                            "2: Consultar| " +
                            "3: Excluir| " +
                            "4: Alterar| " +
                            "5: SAIR" ,
                    "CADASTRO \n --Opção Inválida--",JOptionPane.INFORMATION_MESSAGE);
            }
        while (isOpcaoValida(opcao)){

            if (isOpcaoCadastrar(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite os dados do cliente separados por virgula:" +
                        "Nome," +
                        "CPF, " +
                        "Telefone, " +
                        "Endereço, " +
                        "Numero, " +
                        "Cidade," +
                        "Estado.", "CADASTRO", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            }
            else if (isOpcaoConsultar(opcao)) {
                String dados;
                dados = JOptionPane.showInputDialog(null, "Digite o CPF", "CONSULTAR", JOptionPane.INFORMATION_MESSAGE);
                String cpfLimpo = validarCPF(dados);
                consultar(cpfLimpo);
            }

            else if (isOpcaoAlterar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Atualização", JOptionPane.INFORMATION_MESSAGE);
                alterar(dados);
            }
            else if (isOpcaoExcluir(opcao)) {
//                sair();
            }
            else if (isOpcaoSair(opcao)) {
                sair();
            }

            opcao = JOptionPane.showInputDialog(null,"" +
                "Digite " +
                "1: Cadastro| " +
                "2: Consultar| " +
                "3: Excluir| " +
                "4: Alterar| " +
                "5: SAIR" ,
            "CADASTRO",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static void alterar(String dados) {

    }

    private static void consultar(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "CLIENTE ENCONTRADO \n" + cliente.toString(), "CONSULTA", JOptionPane.INFORMATION_MESSAGE);

        }
        else {
            JOptionPane.showMessageDialog(null, "CLIENTE NÃO ENCONTRADO", "CONSULTA", JOptionPane.INFORMATION_MESSAGE);

        }


    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
//        CRIAR VALIDAÇAO DE CAMPOS -> QUANTIDADE E QUALIDADE
//        Se vazio, passar NULL no construtor onde não tiver o valor
        Cliente cliente = new Cliente(validarNome(dadosSeparados[0]),validarCPF(dadosSeparados[1]),validarTEL(dadosSeparados[2]),validarEnd(dadosSeparados[3]),validarNum(dadosSeparados[4]),validarCidade(dadosSeparados[5]),validarEstado(dadosSeparados[6]));
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado){
            JOptionPane.showMessageDialog(null, "CLIENTE CADASTRADO COM SUCESSO", "CADASTRO", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "CADASTRO JÁ EXISTENTE", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "PROGRAMA FINALIZADO", "SAIR", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoCadastrar(String opcao) {
        if ("1".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoConsultar(String opcao) {
        if ("2".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoExcluir(String opcao) {
        if ("3".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoAlterar(String opcao) {
        if ("4".equals(opcao)){
            return true;
        }
        return false;
    }
    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)){
            return true;
        }
        return false;
    }

    private static String validarCPF(String dados) {
        String cpfLimpo = dados.trim().replaceAll("-","").replaceAll("\\s","");
//        boolean matches = cpfLimpo.matches("\\d+");
        while (cpfLimpo.length() != 11 || !cpfLimpo.matches("\\d+")) {
            dados = JOptionPane.showInputDialog(null, "Digite o CPF VALIDO", "CONSULTAR", JOptionPane.INFORMATION_MESSAGE);
            cpfLimpo = dados.trim().replaceAll("-","").replaceAll("\\s","");
        }
        return cpfLimpo;
    }

    private static String validarNome(String dados) {
        String nomeLimpo = dados.trim();
        while (nomeLimpo.length() < 2 || !nomeLimpo.matches("[a-zA-Z]+")) {
            dados = JOptionPane.showInputDialog(null, "Digite o NOME VALIDO", "CADASTRAR", JOptionPane.INFORMATION_MESSAGE);
            nomeLimpo = nomeLimpo = dados.trim();;
        }
        return nomeLimpo;
    }

    private static String validarEnd(String dados) {
        String endLimpo = dados.trim();
        while (endLimpo.length() < 1 || !endLimpo.matches("[a-zA-Z]+")) {
            dados = JOptionPane.showInputDialog(null, "Digite o ENDEREÇO VALIDO", "CADASTRAR", JOptionPane.INFORMATION_MESSAGE);
            endLimpo = endLimpo = dados.trim();;
        }
        return endLimpo;
    }

    private static String validarTEL(String dados) {
        String telLimpo = dados.trim().replaceAll("-", "").replaceAll("\\s", "");
//        boolean matches = cpfLimpo.matches("\\d+");
        while (telLimpo.length() != 9 || !telLimpo.matches("\\d+")) {
            dados = JOptionPane.showInputDialog(null, "Digite o TELEFONE VALIDO", "CONSULTAR", JOptionPane.INFORMATION_MESSAGE);
            telLimpo = dados.trim().replaceAll("-", "").replaceAll("\\s", "");
        }
        return telLimpo;
    }

    private static String validarEstado(String dados) {
        String estadoLimpo = dados.trim();
        while (estadoLimpo.length() != 2 || !estadoLimpo.matches("[a-zA-Z]+")) {
            dados = JOptionPane.showInputDialog(null, "Digite o ESTADO VALIDO", "CADASTRAR", JOptionPane.INFORMATION_MESSAGE);
            estadoLimpo = dados.trim();
            ;
        }
        return estadoLimpo;
    }
    private static String validarCidade(String dados) {
        String cidadeLimpo = dados.trim();
        while (cidadeLimpo.length() < 1 || !cidadeLimpo.matches("[a-zA-Z ]+")) {
            dados = JOptionPane.showInputDialog(null, "Digite o CIDADE VALIDO", "CADASTRAR", JOptionPane.INFORMATION_MESSAGE);
            cidadeLimpo = dados.trim();
            ;
        }
        return cidadeLimpo;
    }

    private static String validarNum(String dados) {
        String numLimpo = dados.trim().replaceAll("-", "").replaceAll("\\s", "");
//        boolean matches = cpfLimpo.matches("\\d+");
        while (!numLimpo.matches("\\d+")) {
            dados = JOptionPane.showInputDialog(null, "Digite o TELEFONE VALIDO", "CONSULTAR", JOptionPane.INFORMATION_MESSAGE);
            numLimpo = dados.trim().replaceAll("-", "").replaceAll("\\s", "");
        }
        return numLimpo;
    }
}
