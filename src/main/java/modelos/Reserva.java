/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "data_hora_emprestimo", nullable = false)
    @CreationTimestamp
    private Date dataHoraEmprestimo;

    @Column(name = "data_hora_devolucao", nullable = false)
    private Date dataHoraDevolucao;

    @ManyToOne
    @JoinColumn(name = "id_armario")
    private Armario armario;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
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
