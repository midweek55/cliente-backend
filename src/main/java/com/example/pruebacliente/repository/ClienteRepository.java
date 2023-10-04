package com.example.pruebacliente.repository;

import com.example.pruebacliente.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
