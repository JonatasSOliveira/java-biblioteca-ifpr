package visoes;

import controles.ReservaControle;
import java.util.List;
import modelos.Reserva;
import respostas.CodigosResposta;
import respostas.RespostaGenerica;
import visoescomponentes.FormularioUI;
import visoescomponentes.ListagemUI;

public final class ReservasUI extends ListagemUI<Reserva> {

    public ReservasUI() {
        super();
    }

    @Override
    protected String[] getCabecalhosColunas() {
        return new String[]{"armario", "data hora devolucao"};
    }

    @Override
    public List<Reserva> buscarDados(String filtro) {
        RespostaGenerica<List<Reserva>> resposta = ReservaControle.buscarPaginavelPorFiltro(1, filtro);

        if (resposta.getCodigoResposta() != CodigosResposta.CODIGO_200_SUCESSO) {
            throw new Error();
        }

        return resposta.getData();
    }

    @Override
    protected String[] getLinha(Reserva reserva) {
        return new String[]{reserva.getArmario().getNumero(), reserva.getDataHoraDevolucao().toString()};
    }

    @Override
    protected FormularioUI getTelaFormulario(Reserva reservaEdicao) {
        return new ReservaFormUI();
    }

    @Override
    protected void excluir(Reserva entidade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
