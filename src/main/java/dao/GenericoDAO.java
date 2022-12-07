package dao;

import conexao.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public abstract class GenericoDAO<T> {

    private final Session sessao;

    public GenericoDAO() {
        this.sessao = HibernateUtil.getSession();
    }

    protected abstract String getNomeModelo();

    protected abstract Class<T> getClasseModelo();

    protected abstract String[] getFiltrosPadrao();

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

    public List<T> buscarPaginavelPorFiltro(int pagina, String filtro) {
        List<T> listaModelos = null;
        String[] filtrosPadrao = this.getFiltrosPadrao();
        String hqlQuery = "from " + this.getNomeModelo();
        boolean existeFiltro = filtrosPadrao.length > 0 && filtro != null && !filtro.isEmpty();

        if (existeFiltro) {
            String whereFiltro = " LIKE :filtro";
            hqlQuery += " WHERE "
                    + String.join(whereFiltro + " AND ", filtrosPadrao)
                    + whereFiltro;
        }

        try {
            getSessao().beginTransaction();
            Query queryset = getSessao()
                    .createQuery(hqlQuery, this.getClasseModelo());

            if (existeFiltro) {
                queryset = queryset.setParameter("filtro", "%" + filtro + "%");
            }

            listaModelos = queryset.list();
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
