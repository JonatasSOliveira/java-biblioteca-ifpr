/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.Date;

/**
 *
 * @author Aluno
 */
public class Reserva {

    private Date dataHoraEmprestimo;
    private Date dataHoraDevolucao;
    private Armario armario;
    private Pessoa pessoa;

    public Reserva() {
    }

    public Reserva(Date dataHoraEmprestimo, Date dataHoraDevolucao, Armario armario, Pessoa pessoa) {
        this.dataHoraEmprestimo = dataHoraEmprestimo;
        this.dataHoraDevolucao = dataHoraDevolucao;
        this.armario = armario;
        this.pessoa = pessoa;
    }
    
    public Date getDataHoraEmprestimo() {
        return dataHoraEmprestimo;
    }

    public void setDataHoraEmprestimo(Date dataHoraEmprestimo) {
        this.dataHoraEmprestimo = dataHoraEmprestimo;
    }

    public Date getDataHoraDevolucao() {
        return dataHoraDevolucao;
    }

    public void setDataHoraDevolucao(Date dataHoraDevolucao) {
        this.dataHoraDevolucao = dataHoraDevolucao;
    }

    public Armario getArmario() {
        return armario;
    }

    public void setArmario(Armario armario) {
        this.armario = armario;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
    
}
