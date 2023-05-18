package annotations;

import annotations.PrimeiraAnotacao;

@PrimeiraAnotacao(NomeDaTabela = "Gastos", TitutloColunas = "Cep, rua, bairro, cidade, estado", numeroLinhas = 10)
public class Main {

    @PrimeiraAnotacao(NomeDaTabela = "Convidados", TitutloColunas = "telefone" ,numeroLinhas = 12)
    private String nome;



}