
package com.MOD42.VendasService.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MOD42.VendasService.domain.Venda;
import com.MOD42.VendasService.dto.VendaDTO;
import com.MOD42.VendasService.usecase.BuscaVenda;
import com.MOD42.VendasService.usecase.CadastroVenda;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/venda")
public class VendasResources {

	private BuscaVenda buscaVenda;
	
	private CadastroVenda cadastroVenda;
	
	@Autowired
	public VendasResources(BuscaVenda buscaVenda,
			CadastroVenda cadastroVenda) {
		this.buscaVenda = buscaVenda;
		this.cadastroVenda = cadastroVenda;
	}
	
	@GetMapping
	@Operation(summary = "Lista as vendas cadastradas")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Retorna a lista de clientes"),
		    @ApiResponse(responseCode = "400", description = "Requisição malformada ou erro de sintaxe", 
		    		content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, examples = @ExampleObject(value = "BAD_REQUEST"))),
		    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção",
		    		content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, examples = @ExampleObject(value = "INTERNAL_SERVER_ERROR"))),
		})
	public ResponseEntity<Page<Venda>> buscar(Pageable pageable) {
		return ResponseEntity.ok(buscaVenda.buscar(pageable));
	}
	
	@PostMapping
	@Operation(summary = "Iniciar uma venda")
	public ResponseEntity<Venda> cadastrar(@RequestBody @Valid VendaDTO venda) {
		return ResponseEntity.ok(cadastroVenda.cadastrar(venda));
	}
	
	@PutMapping("/{id}/{codigoProduto}/{quantidade}/addProduto")
	public ResponseEntity<Venda> adicionarProduto(
			@PathVariable(name = "id", required = true) String id,
			@PathVariable(name = "codigoProduto", required = true) String codigoProduto,
			@PathVariable(name = "quantidade", required = true) Integer quantidade) {
		return ResponseEntity.ok(cadastroVenda.adicionarProduto(id, codigoProduto, quantidade));
	}
}
