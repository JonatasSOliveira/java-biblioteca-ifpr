package dao;

import java.util.List;
import modelos.Armario;

public class ArmarioDAO extends GenericoDAO<Armario> {
    public ArmarioDAO() {
        super();
    }

    @Override
    public List<Armario> buscarTodos() {
        List<Armario> Armarios = null;
        
        try {
            getSessao().beginTransaction();
            Armarios = (List<Armario>) getSessao().createQuery("from Armario").list();
            getSessao().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Armarios;        
    }

    @Override
    public Armario buscarPorId(Long id) {
        Armario Armario = null;
        
        try {
            getSessao().beginTransaction();
            Armario = (Armario) getSessao().get(Armario.class, id);
            getSessao().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Armario;
    }
    
    @Override
    public void criar(Armario modelo) {
        try {
            getSessao().beginTransaction();
            getSessao().persist(modelo);
            getSessao().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    @Override
    public void atualizar(Armario modelo) {
        try {
            getSessao().beginTransaction();
            getSessao().update(modelo);
            getSessao().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }       

    @Override
    public void excluir(Armario modelo) {
        try {
            getSessao().beginTransaction();
            getSessao().delete(modelo);
            getSessao().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    } 
}
