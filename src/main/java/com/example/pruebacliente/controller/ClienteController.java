package com.example.pruebacliente.controller;

import com.example.pruebacliente.model.Cliente;
import com.example.pruebacliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    public ClienteService clienteService;

    @GetMapping
    public List<Cliente> list(){
         return clienteService.findAll();
    }
    @GetMapping("/{id}")
    public Cliente get(@PathVariable  Long id){
        return clienteService.findById(id);
    }
    @PostMapping
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }
    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente client) {
        client.setId(id);
        return clienteService.save(client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteService.deleteById(id);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>("Valor de parámetro incorrecto: " + ex.getValue(), HttpStatus.BAD_REQUEST);
    }
}
