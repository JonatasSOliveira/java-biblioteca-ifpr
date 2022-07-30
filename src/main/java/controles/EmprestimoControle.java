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
    public static final int COD_ARMARIO_INDISPONIVEL = 2;
    public static final int COD_ESTUDANTE_EMPRESTIMO_PENDENTE = 3;

//    TODO: Fazer salvar o emprestimo, associando a chave ao usuário
    public static int emprestar(String ra, String senha, String numeroArmario) {
        boolean armarioDisponivel = EstudanteArmarioControle.armarioEstaDisponivel(numeroArmario);

        if (!armarioDisponivel) {
            return EmprestimoControle.COD_ARMARIO_INDISPONIVEL;
        }

        Estudante estudante = EstudanteControle.buscaEstudante(ra, senha);
        int pendenciaEstudante = EstudanteArmarioControle.verificarPendenciasEstudante(estudante);

        switch (pendenciaEstudante) {
            case EstudanteArmarioControle.COD_ESTUDANTE_EMPRESTIMO_PENDENTE:
                return EmprestimoControle.COD_ESTUDANTE_EMPRESTIMO_PENDENTE;

        }
        
//        NOTE: Aqui deverá ter a função de salvar antes do retorno

        return EmprestimoControle.COD_EMPRESTADO_COM_SUCESSO;
    }
}
