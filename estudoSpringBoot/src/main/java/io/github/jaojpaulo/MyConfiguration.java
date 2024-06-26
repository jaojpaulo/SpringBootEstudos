package io.github.jaojpaulo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*
Substituir essa config

@Configuration
@Profile("development")

por essa
 */
@Development
public class MyConfiguration {

    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("RODANDO A CONFIGURAÇÃO DE DESENVOLVIMENTO");
        };
    }
}
