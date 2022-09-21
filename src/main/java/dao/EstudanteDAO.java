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
            estudantes = (List<Estudante>) getSessao().createQuery("from Estudante").list();
            getSessao().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return estudantes;        
    }

    @Override
    public Estudante buscarPorId(Long id) {
        Estudante estudante = null;
        
        try {
            getSessao().beginTransaction();
            estudante = (Estudante) getSessao().get(Estudante.class, id);
            getSessao().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return estudante;
    }
    
    @Override
    public void criar(Estudante modelo) {
        try {
            getSessao().beginTransaction();
            getSessao().persist(modelo);
            getSessao().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    @Override
    public void atualizar(Estudante modelo) {
        try {
            getSessao().beginTransaction();
            getSessao().update(modelo);
            getSessao().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }       

    @Override
    public void excluir(Estudante modelo) {
        try {
            getSessao().beginTransaction();
            getSessao().delete(modelo);
            getSessao().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }    
    
}
