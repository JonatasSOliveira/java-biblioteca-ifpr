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
    protected String[] getFiltrosPadrao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Reserva buscarPorArmarioEDevolucaoIsNull(String numeroArmario) {
        Reserva reserva = null;
        String queryReserva = "SELECT arm FROM Armario arm "
                + "WHERE arm.numero=:numeroArmario";
        String queryArmario = "SELECT r FROM Reserva r "
                + "WHERE r.armario=:armario and r.dataHoraDevolucao is null";

        try {
            getSessao().beginTransaction();
            Armario armario = getSessao()
                    .createQuery(queryReserva, Armario.class)
                    .setParameter("numeroArmario", numeroArmario)
                    .getSingleResult();
            reserva = getSessao().createQuery(queryArmario, Reserva.class)
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
