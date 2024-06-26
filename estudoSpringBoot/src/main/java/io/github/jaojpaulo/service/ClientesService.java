package io.github.jaojpaulo.service;

import io.github.jaojpaulo.model.Cliente;
import io.github.jaojpaulo.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    // Injeção pode ser feita via construtor ou atributo
    @Autowired
    private ClientesRepository repository;
    /*
    OU

    @Autowired
    public ClientesService (ClientesRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private setRepository (ClientesRepository repository) {
        this.repository = repository;
    }
    */
    public void salvarCliente (Cliente cliente) {
        validarCliente(cliente);
        this.repository.persistir(cliente);
    }

    public void validarCliente (Cliente cliente) {
        // Aplica Validações
    }
}
