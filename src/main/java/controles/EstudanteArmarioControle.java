/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import modelos.Armario;
import modelos.Estudante;

/**
 *
 * @author Jonatas Oliveira
 */
public class EstudanteArmarioControle {

    public static final int COD_ESTUDANTE_SEM_PENDENCIAS = 1;
    public static final int COD_ESTUDANTE_EMPRESTIMO_PENDENTE = 2;

    //TODO: Aqui vai verificar no banco se o armário já foi emprestado
    public static boolean armarioEstaDisponivel(String numeroArmario) {

        return true;
    }

    public static int verificarPendenciasEstudante(Estudante estudante) {

        return EstudanteArmarioControle.COD_ESTUDANTE_SEM_PENDENCIAS;
    }

}
