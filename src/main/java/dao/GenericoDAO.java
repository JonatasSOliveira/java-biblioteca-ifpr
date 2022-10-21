package dao;

import conexao.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public abstract class GenericoDAO<T> {

    private final Session sessao;

    public GenericoDAO() {
        this.sessao = HibernateUtil.getSession();
    }
    
    protected abstract String getNomeModelo();

    protected abstract Class<T> getClasseModelo();

    protected Session getSessao() {
        return this.sessao;
    }
    
    public List<T> buscarTodos() {
        List<T> listaModelos = null;

        try {
            getSessao().beginTransaction();
            listaModelos = getSessao()
                    .createQuery("from " + this.getNomeModelo(),
                            this.getClasseModelo()).list();
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
            modelo = getSessao().get(this.getClasseModelo(), id);
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

    public void atualizar(T modelo) {
        try {
            getSessao().beginTransaction();
            getSessao().update(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
    }

    public void excluir(T modelo) {
        try {
            getSessao().beginTransaction();
            getSessao().delete(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
    }    

}
