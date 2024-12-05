package io.github.jaojpaulo.domain.entitiy;

import jakarta.persistence.*;

@Entity
// Usar a notation @Table quando o o nome da tabel não corresponde a da classe de entidade
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    /* Por padrão quando uma coluna é anotada como entity a colocação de notation não é necessária caso o nome dos
    seja igual ao das colunas, JPA consegue fazer esse mapeamento de forma automática.
     */
    @Column(name = "nome")
    private String nome;

    public Cliente() {}

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
