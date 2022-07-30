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
public class DevolucaoControler {

    
    public static final int COD_ARMARIO_INEXISTENTE = 0;
    public static final int COD_DEVOLVIDO_COM_SUCESSO = 1;
    public static final int COD_ARMARIO_JA_DEVOLVIDO = 2;
    public static final int COD_ARMARIO_ENCONTRADO = 3;
    public static final int COD_ARMARIO_NAO_ENCONTRADO = 4;

    public static int devolver(String numeroArmario) {
        //TODO: DEVOLVER ARMARIO NO BANCO
        int armario = find(numeroArmario);
                
        if (armario == COD_ARMARIO_ENCONTRADO) {
            if (numeroArmario.equals("111")) {
                return COD_ARMARIO_JA_DEVOLVIDO;
            } else {
                return COD_DEVOLVIDO_COM_SUCESSO;
            }
        }
        return COD_ARMARIO_INEXISTENTE;
    }

    public static Integer find(String numero) {
        if (numero.equals("999")) {
            return COD_ARMARIO_NAO_ENCONTRADO;
        }
        return COD_ARMARIO_ENCONTRADO;
    }
}
