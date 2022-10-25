/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import conexao.HibernateUtil;

import dao.ArmarioDAO;
import dao.BibliotecarioDAO;
import dao.EstudanteDAO;

import modelos.Armario;
import modelos.Estudante;
import modelos.Bibliotecario;

import org.hibernate.Session;

import visoes.DesktopUI;

import java.util.List;

/**
 *
 * @author Aluno
 */
public class Main {

    // NOTE: Função para criar valores de teste. Será removido posteriormente
    private static void criarValoresTeste() {
        ArmarioDAO armarioDAO = new ArmarioDAO();
        List<Armario> armarios =  armarioDAO.buscarTodos();
        if (armarios.isEmpty()) {
            Armario armario = new Armario("001", true, null);
            armarioDAO.criar(armario);
        }

        EstudanteDAO estudanteDAO = new EstudanteDAO();
        List<Estudante> estudantes =  estudanteDAO.buscarTodos();
        if (estudantes.isEmpty()) {
            Estudante estudante = new Estudante("TESTE", "TESTE@TESTE.COM","44984563076", "001", "001", true);
            estudanteDAO.criar(estudante);
            Estudante estudante2 = new Estudante("SANTYERO", "SANTYERO@SANTYERO.COM","44984563077", "002", "002", true);
            estudanteDAO.criar(estudante2);
        }
        
        BibliotecarioDAO bibliotecarioDAO = new BibliotecarioDAO();
        List<Bibliotecario> bibliotecarios = bibliotecarioDAO.buscarTodos();
        if (bibliotecarios.isEmpty()) {
            Bibliotecario bibliotecario = new Bibliotecario(
                    "001", "admin", "BIBLIOTECARIO", "TESTE2@TESTE.COM", 
                    "44984563076", "admin", true);
            bibliotecarioDAO.criar(bibliotecario);
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
