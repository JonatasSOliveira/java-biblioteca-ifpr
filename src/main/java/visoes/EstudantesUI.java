package visoes;

import controles.EstudanteControle;
import java.util.List;
import modelos.Estudante;
import respostas.CodigosResposta;
import respostas.RespostaGenerica;
import visoescomponentes.ListagemUI;

/**
 *
 * @author Jonatas Oliveira
 */
public final class EstudantesUI extends ListagemUI<Estudante> {

    public EstudantesUI() {
        super();
    }
    
    @Override
    protected String[] getCabecalhosColunas() {
        return new String[] {"RA", "Nome"};
    }

    @Override
    protected List<Estudante> buscarDados(String filtro) {
        RespostaGenerica<List<Estudante>> resposta = EstudanteControle.buscarPaginavelPorFiltro(1, filtro);
        
        if (resposta.getCodigoResposta() != CodigosResposta.CODIGO_200_SUCESSO) {
            throw new Error();
        }
        
        return resposta.getData();
    }

    @Override
    protected String[] getLinha(Estudante estudante) {
        return new String[] {estudante.getRa(), estudante.getNome()};
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
