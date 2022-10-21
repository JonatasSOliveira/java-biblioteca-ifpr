package dao;

import modelos.Armario;

public class ArmarioDAO extends GenericoDAO<Armario> {

    public ArmarioDAO() {
        super();
    }

    @Override
    protected String getNomeModelo() {
        return "Armario";
    }

    @Override
    public Class<Armario> getClasseModelo() {
        return Armario.class;
    }

    @Override
    protected String[] getFiltrosPadrao() {
        return new String[]{"numero"};
    }

    public Armario buscarPorNumero(String numero) {
        Armario armario = null;
        String query = "select a from Armario a"
                + " where a.numero = :numero";

        try {
            getSessao().beginTransaction();
            armario = (Armario) getSessao()
                    .createQuery(query)
                    .setParameter("numero", numero)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }

        return armario;
    }
}
