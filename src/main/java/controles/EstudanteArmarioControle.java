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
public class EstudanteArmarioControle {

    public static final int COD_ESTUDANTE_SEM_PENDENCIAS = 1;
    public static final int COD_ESTUDANTE_EMPRESTIMO_PENDENTE = 2;

//    TODO: Aqui vai verificar no banco se o armário já foi emprestado;
    public static boolean armarioEstaDisponivel(String numeroArmario) {
//        NOTE: dado de teste, pois não temos o banco ainda
        if (numeroArmario.equals("00")) {
            return false;
        }

        return true;
    }

//    TODO: Verificar se o estudante tem algum emprestimo sem devolução
    public static int verificarPendenciasEstudante(Estudante estudante) {
//        NOTE: dado de teste, pois não temos o banco ainda
        if (estudante.getRa().equals("00")) {
            return EstudanteArmarioControle.COD_ESTUDANTE_EMPRESTIMO_PENDENTE;
        }

        return EstudanteArmarioControle.COD_ESTUDANTE_SEM_PENDENCIAS;
    }

}
