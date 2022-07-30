/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Aluno
 */
public class Estudante extends Pessoa {
    private String ra;
    private String senha;

    public Estudante() {
    }
    
    public Estudante(String ra, String senha) {
        this.ra = ra;
        this.senha = senha;
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
