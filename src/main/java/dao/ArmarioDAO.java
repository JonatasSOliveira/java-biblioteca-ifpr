package dao;

import java.util.List;
import modelos.Armario;

public class ArmarioDAO extends GenericoDAO<Armario> {
    public ArmarioDAO() {
        super();
    }

    @Override
    public List<Armario> buscarTodos() {
        List<Armario> armarios = null;
        
        try {
            getSessao().beginTransaction();
            armarios = getSessao().createQuery("from Armario", Armario.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }

        return armarios;
    }

    @Override
    public Armario buscarPorId(Long id) {
        Armario armario = null;
        
        try {
            getSessao().beginTransaction();
            armario = getSessao().get(Armario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
        
        return armario;
    }
    
    @Override
    public void criar(Armario armario) {
        try {
            getSessao().beginTransaction();
            getSessao().persist(armario);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
    }
    
    @Override
    public void atualizar(Armario armario) {
        try {
            getSessao().beginTransaction();
            getSessao().update(armario);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
    }       

    @Override
    public void excluir(Armario armario) {
        try {
            getSessao().beginTransaction();
            getSessao().delete(armario);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSessao().getTransaction().commit();
        }
    }

    public Armario buscarPorNumero(String numero) {
        Armario armario = null;
        String query = "select a from Armario a" +
                " where a.numero = :numero";

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
