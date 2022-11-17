package visoes;

import controles.BibliotecarioControle;
import java.util.List;
import modelos.Bibliotecario;
import respostas.CodigosResposta;
import respostas.RespostaGenerica;
import visoescomponentes.FormularioUI;
import visoescomponentes.ListagemUI;

/**
 *
 * @author Jonatas Oliveira
 */
public final class BibliotecariosUI extends ListagemUI<Bibliotecario> {

    public BibliotecariosUI() {
        super();
    }
    
    @Override
    protected String[] getCabecalhosColunas() {
        return new String[] {"siape", "login", "nome"};
    }

    @Override
    public List<Bibliotecario> buscarDados(String filtro) {
        RespostaGenerica<List<Bibliotecario>> resposta = BibliotecarioControle.buscarPaginavelPorFiltro(1, filtro);
        
        if (resposta.getCodigoResposta() != CodigosResposta.CODIGO_200_SUCESSO) {
            throw new Error();
        }
        
        return resposta.getData();
    }

    @Override
    protected String[] getLinha(Bibliotecario bibliotecario) {
        return new String[] {bibliotecario.getNome(), bibliotecario.getLogin(), bibliotecario.getNome() };
    }

    @Override
    protected FormularioUI getTelaFormulario(Bibliotecario bibliotecarioEdicao) {
        return new BibliotecarioFormUI();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
