/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

/**
 *
 * @author Aluno
 */
public class LoginControle {
    public static final int COD_LOGIN_INVALIDO = 1;
    public static final int COD_LOGIN_VALIDO = 2;    
    
    public static int autenticar(String login, String senha) {
        if (login.equals("ADMIN") && senha.equals(("ADMIN"))) {
            return LoginControle.COD_LOGIN_VALIDO;
        }
        
        return LoginControle.COD_LOGIN_INVALIDO;
    }        
}
