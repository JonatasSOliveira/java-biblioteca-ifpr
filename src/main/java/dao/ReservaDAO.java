package dao;

import java.util.List;
import modelos.Reserva;

public class ReservaDAO extends GenericoDAO<Reserva> {
    public ReservaDAO() {
        super();
    }

    @Override
    public List<Reserva> buscarTodos() {
        List<Reserva> Reservas = null;
        
        try {
            getSessao().beginTransaction();
            Reservas = (List<Reserva>) getSessao().createQuery("from Reserva").list();
            getSessao().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Reservas;        
    }

    @Override
    public Reserva buscarPorId(Long id) {
        Reserva Reserva = null;
        
        try {
            getSessao().beginTransaction();
            Reserva = (Reserva) getSessao().get(Reserva.class, id);
            getSessao().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Reserva;
    }
    
    @Override
    public void criar(Reserva modelo) {
        try {
            getSessao().beginTransaction();
            getSessao().persist(modelo);
            getSessao().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    @Override
    public void atualizar(Reserva modelo) {
        try {
            getSessao().beginTransaction();
            getSessao().update(modelo);
            getSessao().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }       

    @Override
    public void excluir(Reserva modelo) {
        try {
            getSessao().beginTransaction();
            getSessao().delete(modelo);
            getSessao().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    } 
}
