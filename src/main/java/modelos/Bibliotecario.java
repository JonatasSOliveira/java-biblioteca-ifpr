package modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "bibliotecario")
@PrimaryKeyJoinColumn(name="id_pessoa")
public class Bibliotecario extends Pessoa {

    @Column(name = "siapie", nullable = false, unique = true)
    private String siape;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    public Bibliotecario() {
    }

    public Bibliotecario(String siape) {
        this.siape = siape;
    }

    public Bibliotecario(String siape, String login, String nome, String email, String telefone, String senha, boolean ativo) {
        super(nome, email, telefone, senha, ativo);
        this.siape = siape;
        this.login = login;
    }
    
    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }
    
    public String getLogin() {
        return login;
    }

}
