/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import modelos.Estudante;

/**
 *
 * @author Jonatas Oliveira
 */
public class EstudanteControle {

    public static Estudante buscaEstudante(String ra, String senha) {
        // TODO: Aqui será usado para buscar o estudante no banco
        Estudante estudante = new Estudante(ra, senha);
        return estudante;
    }

}
