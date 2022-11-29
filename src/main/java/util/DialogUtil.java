package util;

import java.awt.Component;
import javax.swing.JOptionPane;

public class DialogUtil {
    public static boolean abrirModalConfirmacaoPadrao(Component parentComponent, String mensagem) {
        Object[] options = {"Não", "Sim"};
        
        int opcaoSelecionada = JOptionPane.showOptionDialog(
                parentComponent,
                mensagem,
                "Atenção",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]
        );
        
        return opcaoSelecionada == 1;
    }
}
