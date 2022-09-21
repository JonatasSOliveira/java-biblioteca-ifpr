/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import modelos.Estudante;
import respostas.RespostaGenerica;
import servicos.ReservaServico;

public class ReservaControle {




//    TODO: Fazer salvar o emprestimo, associando a chave ao usuário
    public static RespostaGenerica emprestar(String ra, String senha, String numeroArmario) {
        return ReservaServico.emprestar(ra, senha, numeroArmario);
//        boolean armarioDisponivel = EstudanteArmarioControle.armarioEstaDisponivel(numeroArmario);
//
//        if (!armarioDisponivel) {
//            return ReservaControle.COD_ARMARIO_INDISPONIVEL;
//        }
//
//        Estudante estudante = EstudanteControle.buscaEstudante(ra, senha);
//        int pendenciaEstudante = EstudanteArmarioControle.verificarPendenciasEstudante(estudante);
//
//        switch (pendenciaEstudante) {
//            case EstudanteArmarioControle.COD_ESTUDANTE_EMPRESTIMO_PENDENTE:
//                return ReservaControle.COD_ESTUDANTE_EMPRESTIMO_PENDENTE;
//
//        }
//
////        NOTE: Aqui deverá ter a função de salvar antes do retorno
//
//        return ReservaControle.COD_EMPRESTADO_COM_SUCESSO;
    }
}
