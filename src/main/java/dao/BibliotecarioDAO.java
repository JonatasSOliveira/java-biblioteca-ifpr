package dao;

import modelos.Bibliotecario;

public class BibliotecarioDAO extends GenericoDAO<Bibliotecario> {

    public BibliotecarioDAO() {
        super();
    }

    @Override
    protected String getNomeModelo() {
        return "Bibliotecario";
    }

    @Override
    public Class<Bibliotecario> getClasseModelo() {
        return Bibliotecario.class;
    }

    @Override
    public void atualizar(Bibliotecario bibliotecario) {
        try {
            getSessao().beginTransaction();
            getSessao().update(bibliotecario);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
    }

    @Override
    public void excluir(Bibliotecario bibliotecario) {
        try {
            getSessao().beginTransaction();
            getSessao().delete(bibliotecario);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
    }

    public Bibliotecario buscarPorLoginESenha(String login, String senha) {
        Bibliotecario bibliotecario = null;
        String query = "Select b from Bibliotecario as b"
                + " where b.login = :login"
                + " and b.senha = MD5(:senha)";

        try {
            getSessao().beginTransaction();
            bibliotecario = getSessao()
                    .createQuery(query, Bibliotecario.class)
                    .setParameter("login", login)
                    .setParameter("senha", senha)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }

        return bibliotecario;
    }
}
