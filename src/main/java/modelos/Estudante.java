/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "estudante")
@PrimaryKeyJoinColumn(name="id_pessoa")
public class Estudante extends Pessoa {

    @Column(name = "ra", unique = true, nullable = false)
    private String ra;


    public Estudante() {
    }

    public Estudante(String ra, String senha) {
        this.ra = ra;
        super.setSenha(senha);
    }

    public Estudante(String ra) {
        this.ra = ra;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

}
