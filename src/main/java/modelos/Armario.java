package modelos;

import javax.persistence.*;

@Entity
@Table(name = "armario")
public class Armario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "numero", unique = true, nullable = false)
    private String numero;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Column(name = "observacoes")
    private String observacoes;

    public Armario() {

    }

    public Armario(String numero) {
        this.numero = numero;
    }

    public Armario(String numero, boolean ativo, String observacoes) {
        this.numero = numero;
        this.ativo = ativo;
        this.observacoes = observacoes;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}
