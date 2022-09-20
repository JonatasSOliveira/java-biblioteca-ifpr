/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import conexao.HibernateUtil;
import org.hibernate.Session;
import visoes.DesktopUI;

/**
 *
 * @author Aluno
 */
public class Main {
    public static void main(String[] args) {
        Session sessao = HibernateUtil.getSession();
        sessao.beginTransaction();
        DesktopUI inicio = new DesktopUI();
        inicio.setVisible(true);
    }
}
