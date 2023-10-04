package com.example.pruebacliente.service;

import com.example.pruebacliente.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClienteService {
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);
    void deleteById(Long id);
}
