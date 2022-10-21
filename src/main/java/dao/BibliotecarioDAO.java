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
