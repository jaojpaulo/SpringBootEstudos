package io.github.jaojpaulo.domain.repository;

import io.github.jaojpaulo.domain.entitiy.Cliente;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class Clientes {

    //private static String INSERT = "insert into cliente (nome) values (?)";
    private static final String SELECT_ALL = "select * from cliente";
    private static String UPDATE = "update cliente set nome = ? where id = ?";
    private static String DELETE = "delete from cliente where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    // Para poder executar a operação o JPA necessita de uma operação
    @Transactional
    public Cliente salvar(Cliente cliente) {
        /*jdbcTemplate.update(INSERT, cliente.getNome());
        Com o uso do Entity manage do JPA não é mais necessário o uso de JdbcTemplate pra executar operações sql
         */
        entityManager.persist(cliente);
        return cliente;
    }

    @Transactional
    public Cliente atualizar(Cliente cliente) {
        //jdbcTemplate.update(UPDATE, cliente.getNome(), cliente.getId());
        entityManager.merge(cliente);
        return cliente;
    }

    @Transactional
    public void deletar(Cliente cliente) {
        //deletar(cliente.getId());
        entityManager.remove(cliente);
    }

    @Transactional
    public void deletar(Integer id) {
        //jdbcTemplate.update(DELETE, id);
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.remove(cliente);
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarPorNome(String nome) {
        String jpql = " select c from Cliente c where c.nome = :nome ";
        //return jdbcTemplate.query(SELECT_ALL.concat("where name like ?"), obterClienteMapper(), "%"+nome+"%");
    }

    public List<Cliente> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
    }

    private RowMapper<Cliente> obterClienteMapper() {
        return (rs, rowNum) -> new Cliente(rs.getInt("id"),
                rs.getString("nome"));
    }
}
