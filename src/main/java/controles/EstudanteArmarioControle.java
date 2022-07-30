/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import modelos.Armario;

/**
 *
 * @author Jonatas Oliveira
 */
public class EstudanteArmarioControle {

    //TODO: Aqui vai verificar no banco se o armário já foi emprestado
    public static boolean verificarDisponibilidade(String numeroArmario) {
        Armario armario = new Armario(numeroArmario);

        return true;
    }
}
