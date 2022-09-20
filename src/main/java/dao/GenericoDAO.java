package dao;

import java.util.List;
import org.hibernate.Session;

public abstract class GenericoDAO<T> {
  private Session sessao;

  public GenericoDAO() {
    this.sessao = HibernateUtil.getSession();
  }

  protected getSessao() {
    return this.sessao;
  }
  
  public abstract List<T> buscarTodos();
  public abstract T buscarPorId(Long id);
  public abstract void criar(T modelo);
  public abstract void atualizar(T modelo);  
  public abstract void excluir(T modelo);
}