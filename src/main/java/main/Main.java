/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import conexao.HibernateUtil;
import dao.ArmarioDAO;
import dao.EstudanteDAO;
import modelos.Armario;
import modelos.Estudante;
import org.hibernate.Session;
import visoes.DesktopUI;

import java.util.List;

/**
 *
 * @author Aluno
 */
public class Main {

//    Note: Função provisoria para cirar valores de teste. Será removido depois
    private static void criarValoresTeste() {
        ArmarioDAO armarioDAO = new ArmarioDAO();
        List<Armario> armarios =  armarioDAO.buscarTodos();
        if (armarios.size() == 0) {
            Armario armario = new Armario("001", true, null);
            armarioDAO.criar(armario);
        }

        EstudanteDAO estudanteDAO = new EstudanteDAO();
        List<Estudante> estudantes =  estudanteDAO.buscarTodos();
        if (estudantes.size() == 0) {
            Estudante estudante = new Estudante("TESTE", "TESTE@TESTE.COM","44984563076", "001", "001", true);
            estudanteDAO.criar(estudante);
        }
    }

    public static void main(String[] args) {
        Session sessao = HibernateUtil.getSession();
        sessao.beginTransaction();
        criarValoresTeste();
        DesktopUI inicio = new DesktopUI();
        inicio.setVisible(true);
    }
}
