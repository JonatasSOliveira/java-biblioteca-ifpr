package dao;

import java.util.List;

import modelos.Estudante;

public class EstudanteDAO extends GenericoDAO<Estudante> {
    public EstudanteDAO() {
        super();
    }

    @Override
    public List<Estudante> buscarTodos() {
        List<Estudante> estudantes = null;

        try {
            getSessao().beginTransaction();
            estudantes = getSessao().createQuery("from Estudante", Estudante.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }

        return estudantes;
    }

    @Override
    public Estudante buscarPorId(Long id) {
        Estudante estudante = null;

        try {
            getSessao().beginTransaction();
            estudante = getSessao().get(Estudante.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }

        return estudante;
    }


    @Override
    public void criar(Estudante modelo) {
        try {
            getSessao().beginTransaction();
            getSessao().persist(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
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

    public Estudante autenticarEstudante(String ra, String senha) {
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
