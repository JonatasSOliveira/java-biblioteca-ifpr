package main;

import conexao.HibernateUtil;

import dao.ArmarioDAO;
import dao.BibliotecarioDAO;
import dao.EstudanteDAO;
import dao.ReservaDAO;
import java.util.Date;

import modelos.Armario;
import modelos.Estudante;
import modelos.Bibliotecario;

import org.hibernate.Session;

import visoes.DesktopUI;

import java.util.List;
import modelos.Reserva;

public class Main {

    // NOTE: Função para criar valores de teste. Será removido posteriormente
    private static void criarValoresTeste() {
        ArmarioDAO armarioDAO = new ArmarioDAO();
        List<Armario> armarios = armarioDAO.buscarTodos();
        if (armarios.isEmpty()) {
            Armario armario = new Armario("001", true, null);
            armarioDAO.criar(armario);
        }

        EstudanteDAO estudanteDAO = new EstudanteDAO();
        List<Estudante> estudantes = estudanteDAO.buscarTodos();
        if (estudantes.isEmpty()) {
            Estudante estudante = new Estudante("TESTE", "TESTE@TESTE.COM", "44984563076", "001", "001", true);
            estudanteDAO.criar(estudante);
            Estudante estudante2 = new Estudante("SANTYERO", "SANTYERO@SANTYERO.COM", "44984563077", "002", "002", true);
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

        ReservaDAO reservaDAO = new ReservaDAO();
        List<Reserva> reservas = reservaDAO.buscarTodos();
        if (reservas.isEmpty()) {
            Reserva reserva = new Reserva(
                    new Date(),
                    new Date(),
                    armarioDAO.buscarPorId((long) 1),
                    estudanteDAO.buscarPorId((long) 1)
            );
            reservaDAO.criar(reserva);
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
