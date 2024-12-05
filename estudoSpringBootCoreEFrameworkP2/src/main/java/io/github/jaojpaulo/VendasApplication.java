package io.github.jaojpaulo;

import io.github.jaojpaulo.domain.entitiy.Cliente;
import io.github.jaojpaulo.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner inir(@Autowired Clientes clientes) {
        return args -> {
          clientes.salvar(new Cliente("João Paulo"));
          clientes.salvar(new Cliente("João Paulo Santos"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado");
                clientes.atualizar(c);
            });

            todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}