package dao;

import java.util.List;

import modelos.Bibliotecario;

public class BibliotecarioDAO extends GenericoDAO<Bibliotecario> {
    public BibliotecarioDAO() {
        super();
    }

    @Override
    public List<Bibliotecario> buscarTodos() {
        List<Bibliotecario> bibliotecarios = null;

        try {
            getSessao().beginTransaction();
            bibliotecarios = getSessao().createQuery("from Bibliotecario", Bibliotecario.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }

        return bibliotecarios;
    }

    @Override
    public Bibliotecario buscarPorId(Long id) {
        Bibliotecario bibliotecario = null;

        try {
            getSessao().beginTransaction();
            bibliotecario = getSessao().get(Bibliotecario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }

        return bibliotecario;
    }

    @Override
    public void criar(Bibliotecario bibliotecario) {
        try {
            getSessao().beginTransaction();
            getSessao().persist(bibliotecario);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
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
        String query = "Select b from Bibliotecario as b" +
                " where b.login = :login" +
                " and b.senha = MD5(:senha)";

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

