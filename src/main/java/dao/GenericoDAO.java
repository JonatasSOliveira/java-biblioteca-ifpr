package dao;

import conexao.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public abstract class GenericoDAO<T> {

    private final Session sessao;

    public GenericoDAO() {
        this.sessao = HibernateUtil.getSession();
    }

    protected Session getSessao() {
        return this.sessao;
    }

    public List<T> buscarTodos() {
        List<T> listaModelos = null;

        try {
            getSessao().beginTransaction();
            listaModelos = (List<T>) getSessao().createQuery("from " + this.getNomeModelo()).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }

        return listaModelos;
    }

    public T buscarPorId(Long id) {
        T modelo = null;

        try {
            getSessao().beginTransaction();
            modelo = (T) getSessao().get(this.getClasseModelo(), id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }

        return modelo;
    }

    public void criar(T modelo) {
        try {
            getSessao().beginTransaction();
            getSessao().persist(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
    }

    protected abstract String getNomeModelo();

    protected abstract Class<T> getClasseModelo();

    public abstract void atualizar(T modelo);

    public abstract void excluir(T modelo);
}
