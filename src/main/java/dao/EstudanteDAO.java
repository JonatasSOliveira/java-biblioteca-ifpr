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
    public void atualizar(Estudante modelo) {
        try {
            getSessao().beginTransaction();
            getSessao().update(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
    }

    @Override
    public void excluir(Estudante modelo) {
        try {
            getSessao().beginTransaction();
            getSessao().delete(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
    }

    public Estudante buscarPorRaESenha(String ra, String senha) {
        Estudante estudante = null;

        try {
            getSessao().beginTransaction();
            estudante = (Estudante) getSessao().createQuery("SELECT etd FROM Estudante etd WHERE etd.ra=:ra and etd.senha=:senha").setParameter("ra", ra).setParameter("senha", senha).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }

        return estudante;
    }
}
