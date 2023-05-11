package br.com.andrepereira.domain;

import br.com.andrepereira.DAO.ClienteMapDAO;
import br.com.andrepereira.DAO.IClienteDAO;
import br.com.andrepereira.DAO.IProdutoDAO;
import br.com.andrepereira.DAO.ProdutoDAO;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;
    private static IProdutoDAO iProdutoDAO;

    public static void main(String args[]) {
        iClienteDAO = new ClienteMapDAO();
        iProdutoDAO = new ProdutoDAO();

//        openning();
        String opcao = openning();
//        destiny(opcao);
    }

    private static void excluir(String dados) {
        if (dados.length() == 7){
            iProdutoDAO.excluir(Long.parseLong(dados));
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);

        } else if (dados.length() == 11) {
            iClienteDAO.excluir(Long.parseLong(dados));
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso: ", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void alterar(String dados) {
        String[] dadosSeparados = dados.split(",");
//        CRIAR VALIDAÇAO DE CAMPOS -> QUANTIDADE E QUALIDADE
//        Se vazio, passar NULL no construtor onde não tiver o valor
        if (dadosSeparados.length == 2){
            Produto produto = iProdutoDAO.consultar(Long.parseLong(dadosSeparados[0]));
            if (produto != null) {
                JOptionPane.showMessageDialog(null, "Produto ALTERADO \n" + produto.toString(), "ALTERAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                produto = new Produto(validarCode(dadosSeparados[0]),validarNome(dadosSeparados[1]));
                iProdutoDAO.alterar(produto);
            } else {
                JOptionPane.showMessageDialog(null, "PRODUTO NÃO ENCONTRADO", "CONSULTA", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            Cliente cliente = iClienteDAO.consultar(Long.parseLong(dadosSeparados[0]));
            if (cliente != null) {
                JOptionPane.showMessageDialog(null, "CLIENTE ALTERADO \n" + cliente.toString(), "ALTERAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                cliente = new Cliente(validarNome(dadosSeparados[0]),validarCPF(dadosSeparados[1]),validarTEL(dadosSeparados[2]),validarEnd(dadosSeparados[3]),
                        validarNum(dadosSeparados[4]),validarCidade(dadosSeparados[5]),validarEstado(dadosSeparados[6]));
                iClienteDAO.alterar(cliente);

            } else {
                JOptionPane.showMessageDialog(null, "CLIENTE NÃO ENCONTRADO", "CONSULTA", JOptionPane.INFORMATION_MESSAGE);

            }

        }

    }

    private static void consultar(String dados) {
        if (dados.length() == 7){
            Produto produto = iProdutoDAO.consultar(Long.parseLong(dados));
            if (produto != null) {
                JOptionPane.showMessageDialog(null, "Produto ENCONTRADO \n" + produto.toString(), "CONSULTA", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "PRODUTO NÃO ENCONTRADO", "CONSULTA", JOptionPane.INFORMATION_MESSAGE);

            }
        } else {
            Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
            if (cliente != null) {
                JOptionPane.showMessageDialog(null, "CLIENTE ENCONTRADO \n" + cliente.toString(), "CONSULTA", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "CLIENTE NÃO ENCONTRADO", "CONSULTA", JOptionPane.INFORMATION_MESSAGE);

            }
        }


    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
//        CRIAR VALIDAÇAO DE CAMPOS -> QUANTIDADE E QUALIDADE
//        Se vazio, passar NULL no construtor onde não tiver o valor
        if (dadosSeparados.length == 2){
            Produto produto = new Produto(validarCode(dadosSeparados[0]),validarNome(dadosSeparados[1]));
            Boolean isCadastrado = iProdutoDAO.cadastrar(produto);
            if (isCadastrado){
                JOptionPane.showMessageDialog(null, "PRODUTO CADASTRADO COM SUCESSO", "CADASTRO", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "PRODUTO JÁ EXISTENTE", "ERRO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            Cliente cliente = new Cliente(validarNome(dadosSeparados[0]),validarCPF(dadosSeparados[1]),validarTEL(dadosSeparados[2]),validarEnd(dadosSeparados[3]),
                    validarNum(dadosSeparados[4]),validarCidade(dadosSeparados[5]),validarEstado(dadosSeparados[6]));
            Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
            if (isCadastrado){
                JOptionPane.showMessageDialog(null, "CLIENTE CADASTRADO COM SUCESSO", "CADASTRO", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "CADASTRO JÁ EXISTENTE", "ERRO", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "PROGRAMA FINALIZADO", "SAIR", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida0(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "5".equals(opcao)){
            return true;
        }
        return false;
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
        while (nomeLimpo.length() <= 1 || !nomeLimpo.matches("[a-zA-Z]+")) {
            dados = JOptionPane.showInputDialog(null, "Digite o NOME VALIDO", "CADASTRAR", JOptionPane.INFORMATION_MESSAGE);
            nomeLimpo = dados.trim();;
        }
        return nomeLimpo;
    }

    private static String validarEnd(String dados) {
        String endLimpo = dados.trim();
        while (endLimpo.length() < 1 || !endLimpo.matches("[a-zA-Z]+")) {
            dados = JOptionPane.showInputDialog(null, "Digite o ENDEREÇO VALIDO", "CADASTRAR", JOptionPane.INFORMATION_MESSAGE);
            endLimpo = dados.trim();;
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
            dados = JOptionPane.showInputDialog(null, "Digite o NUMERO VALIDO", "CONSULTAR", JOptionPane.INFORMATION_MESSAGE);
            numLimpo = dados.trim().replaceAll("-", "").replaceAll("\\s", "");
        }
        return numLimpo;
    }

    private static String validarCode(String dados) {
        String codeLimpo = dados.trim().replaceAll("-", "").replaceAll("\\s", "");
//        boolean matches = cpfLimpo.matches("\\d+");
        while (codeLimpo.length() < 7 || !codeLimpo.matches("\\d+")) {
            dados = JOptionPane.showInputDialog(null, "Digite o NUMERO VALIDO", "CONSULTAR", JOptionPane.INFORMATION_MESSAGE);
            codeLimpo = dados.trim().replaceAll("-", "").replaceAll("\\s", "");
        }
        return codeLimpo;
    }
    protected static String openning(){
        String opcao = JOptionPane.showInputDialog(null,"" +
                        "Digite " +
                        "1: Cadastrar| " +
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
                            "1: Cadastrar| " +
                            "2: Consultar| " +
                            "3: Excluir| " +
                            "4: Alterar| " +
                            "5: SAIR" ,
                    "CADASTRO \n --Opção Inválida--",JOptionPane.INFORMATION_MESSAGE);
        }
        if (isOpcaoSair(opcao)){
            sair();
        }
        destiny(opcao);
        return opcao;
    }
    public static void destiny(String opcao){
        String opcao0 = JOptionPane.showInputDialog(null,"" +
                        "Digite " +
                        "1: Produto| " +
                        "2: Pessoa| " +
                        "5: RETORNAR" ,
                "CADASTRO",JOptionPane.INFORMATION_MESSAGE);
        while (!isOpcaoValida0(opcao0)){
            if ("".equals(opcao0)) {
                openning();
            }
            opcao0 = JOptionPane.showInputDialog(null,"" +
                            "OPÇÃO INVALIDA " +
                            "1: Produto| " +
                            "2: Pessoa| " +
                            "5: RETORNAR" ,
                    "",JOptionPane.INFORMATION_MESSAGE);
        }
        while (isOpcaoValida0(opcao0)){
            if (isProduto(opcao0)){
                produto(opcao);
            }
            else if (isPessoa(opcao0)){
                pessoa(opcao);

            }
            else if (isOpcaoSair(opcao0)){
                sair();
            }
        }
    }
    private static boolean isPessoa(String opcao0) {
        if ("2".equals(opcao0)){
            return true;
        }
        return false;
    }
    private static boolean isProduto(String opcao0) {
        if ("1".equals(opcao0)){
            return true;
        }
        return false;
    }

    public static void pessoa(String opcao){
        while (isOpcaoValida(opcao)){

            if (isOpcaoCadastrar(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite os dados do cliente separados por virgula:" +
                        "Nome," +
                        "CPF, " +
                        "Telefone, " +
                        "Endereço, " +
                        "Numero, " +
                        "Cidade," +
                        "Estado.", "CADASTRO PESSOA", JOptionPane.INFORMATION_MESSAGE);
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
                        "Digite os dados do cliente separados por vígula, conforme exemplo: NOVO-Nome, ORIGINAL-CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Atualização", JOptionPane.INFORMATION_MESSAGE);
                alterar(dados);
            }
            else if (isOpcaoExcluir(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente",
                        "Consulta cliente", JOptionPane.INFORMATION_MESSAGE);
                excluir(validarCPF(dados));
            }
            else if (isOpcaoSair(opcao)) {
                sair();
            }
            openning();
//            opcao = JOptionPane.showInputDialog(null,"" +
//                            "TO PERDIDO AQUI " +
//                            "1: Cadastro| " +
//                            "2: Consultar| " +
//                            "3: Excluir| " +
//                            "4: Alterar| " +
//                            "5: SAIR" ,
//                    "CADASTRO",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void produto(String opcao){
        while (isOpcaoValida(opcao)){

            if (isOpcaoCadastrar(opcao)) {
                String info = JOptionPane.showInputDialog(null, "Digite código,nome do produto:"
                        , "CADASTRO PRODUTO", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(info);
            }
            else if (isOpcaoConsultar(opcao)) {
                String dados;
                dados = JOptionPane.showInputDialog(null, "Digite o CÓDIGO", "CONSULTAR", JOptionPane.INFORMATION_MESSAGE);
                String codigoLimpo = validarCode(dados);
                consultar(codigoLimpo);
            }

            else if (isOpcaoAlterar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o código,NOVO-nome do produto",
                        "Atualização", JOptionPane.INFORMATION_MESSAGE);
                alterar(dados);
            }
            else if (isOpcaoExcluir(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CÓDIGO do produto",
                        "Consulta produto", JOptionPane.INFORMATION_MESSAGE);
                excluir(validarCode(dados));
            }
            else if (isOpcaoSair(opcao)) {
                sair();
            }
            openning();
//            opcao = JOptionPane.showInputDialog(null,"" +
//                            "TO PERDIDO AQUI " +
//                            "1: Cadastro| " +
//                            "2: Consultar| " +
//                            "3: Excluir| " +
//                            "4: Alterar| " +
//                            "5: SAIR" ,
//                    "CADASTRO",JOptionPane.INFORMATION_MESSAGE);
        }
    }



}
