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

    public Bibliotecario() {
    }

    public Bibliotecario(String siape) {
        this.siape = siape;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

}
