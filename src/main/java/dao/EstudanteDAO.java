package dao;

import modelos.Estudante;

public class EstudanteDAO extends GenericoDAO<Estudante> {

    public EstudanteDAO() {
        super();
    }

    @Override
    protected String getNomeModelo() {
        return "Estudante";
    }

    @Override
    public Class<Estudante> getClasseModelo() {
        return Estudante.class;
    }

    @Override
    protected String[] getFiltrosPadrao() {
        return new String[]{"nome"};
    }

    public Estudante buscarPorRaESenha(String ra, String senha) {
        Estudante estudante = null;
        String query = "SELECT etd FROM Estudante etd "
                + "WHERE etd.ra=:ra and etd.senha=:senha";

        try {
            getSessao().beginTransaction();
            estudante = getSessao().createQuery(query, Estudante.class)
                    .setParameter("ra", ra)
                    .setParameter("senha", senha)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }

        return estudante;
    }
}
