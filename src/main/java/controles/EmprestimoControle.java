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
public class EmprestimoControle {

    public static final int COD_EMPRESTADO_COM_SUCESSO = 1;

    public static int emprestar(String ra, String senha, String numeroArmario) {
        Estudante estudante = EstudanteControle.buscaEstudante(ra, senha);
        int estaDispo

        return EmprestimoControle.COD_EMPRESTADO_COM_SUCESSO;
    }
}
