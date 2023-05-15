package annotations;

import annotations.PrimeiraAnotacao;

@PrimeiraAnotacao(NomeDaTabela = "Andre", TitutloColunas = "Cep, rua, bairro, cidade, estado", numeroLinhas = 10)
public class Main {

    @PrimeiraAnotacao(NomeDaTabela = "Pereira", TitutloColunas = "telefone" ,numeroLinhas = 12)
    private String nome;



}