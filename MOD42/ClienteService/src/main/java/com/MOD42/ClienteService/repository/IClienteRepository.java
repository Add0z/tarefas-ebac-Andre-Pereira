package com.MOD42.ClienteService.repository;


import java.util.Optional;

import com.MOD42.ClienteService.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IClienteRepository extends MongoRepository<Cliente, String>{

    Optional<Cliente> findByCpf(Long cpf);
}