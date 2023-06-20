/**
 * 
 */
package com.MOD42.VendasService.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.MOD42.VendasService.domain.Venda;
import com.MOD42.VendasService.exception.EntityNotFoundException;
import com.MOD42.VendasService.repository.IVendaRepository;

/**
 * @author rodrigo.pires
 *
 */
@Service
public class BuscaVenda {

	private IVendaRepository vendaRepository;
	
	@Autowired
	public BuscaVenda(IVendaRepository produtoRepository) {
		this.vendaRepository = produtoRepository;
	}
	
	public Page<Venda> buscar(Pageable pageable) {
		return vendaRepository.findAll(pageable);
	}

	public Venda buscarPorCodigo(String codigo) {
		return vendaRepository.findByCodigo(codigo)
				.orElseThrow(() -> new EntityNotFoundException(Venda.class, "codigo", codigo));
	}

	
}
