package modelos;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String nome;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Column(name = "data_criacao", nullable = false)
    @CreationTimestamp
    private Date dataCriacao;

    @Column(name = "data_atualizacao", nullable = false)
    @UpdateTimestamp
    private Date dataAtualizacao;


    public Pessoa() {
    }

    public Pessoa(String nome, String senha, Date dataCriacao) {
        this.nome = nome;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
    }


    public Pessoa(String nome, String email, String telefone, String senha, boolean ativo, Date dataAtualizacao, Date dataCriacao) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.ativo = ativo;
        this.dataAtualizacao = dataAtualizacao;
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}
