package dao;

import modelos.Armario;
import modelos.Estudante;
import modelos.Reserva;

public class ReservaDAO extends GenericoDAO<Reserva> {

    public ReservaDAO() {
        super();
    }

    @Override
    protected String getNomeModelo() {
        return "Reserva";

    }

    @Override
    public Class<Reserva> getClasseModelo() {
        return Reserva.class;
    }

    @Override
    public void atualizar(Reserva reserva) {
        try {
            getSessao().beginTransaction();
            getSessao().update(reserva);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
    }

    @Override
    public void excluir(Reserva reserva) {
        try {
            getSessao().beginTransaction();
            getSessao().delete(reserva);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
    }

    public Reserva buscarPorArmarioEDevolucaoIsNull(String numeroArmario) {
        Reserva reserva = null;
        try {
            getSessao().beginTransaction();
            Armario armario = (Armario) getSessao().createQuery("SELECT arm FROM Armario arm WHERE arm.numero=:numeroArmario")
                    .setParameter("numeroArmario", numeroArmario)
                    .getSingleResult();
            reserva = (Reserva) getSessao().createQuery("SELECT r FROM Reserva r WHERE r.armario=:armario and r.dataHoraDevolucao is null")
                    .setParameter("armario", armario)
                    .getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
        return reserva;
    }

    public Reserva buscarPorEstudanteEDevolucaoNull(Estudante estudante) {
        Reserva reserva = null;
        String query = "select r from Reserva r "
                + "where r.estudante = :estudante "
                + "and r.dataHoraDevolucao is null";

        try {
            getSessao().beginTransaction();
            reserva = (Reserva) getSessao().createQuery(query)
                    .setParameter("estudante", estudante)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
        return reserva;
    }
}
