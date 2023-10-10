package view.util;

import com.example.common.model.Pessoa;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ComboBoxPessoa {

    private String value; //String que aparece para o usuário
    private int key; //Código da String (Chave primaria da tabela Pessoa)

    //Método construtor
    public ComboBoxPessoa(int key, String value) {
        this.value = value;
        this.key = key;
    }

    @Override
    public String toString() {
        return value;
    }

    public int getKey() {
        return key;
    }

    public static int getSelectedIndex(JComboBox combo) {
        Object obj = combo.getSelectedItem();
        if (obj == null) {
            return -1;
        } else {
            return ((ComboBoxPessoa) obj).getKey();
        }
    }

    public static void preencherComboBoxPessoa(int SelCodigo, JComboBox combo, ArrayList<Pessoa> lista, Boolean addTodos) {
        Vector vlista = new Vector();
        int x = 1;
        int selecionarCodigo = -1;

        if (addTodos) {
            vlista.add(new ComboBoxPessoa(0, "Todas"));
        }

        for (Pessoa p : lista) {
            ComboBoxPessoa cmb = new ComboBoxPessoa(p.getID_Pessoa(), p.getUsuario());
            vlista.add(cmb);

            if (cmb.getKey() == SelCodigo) {
                selecionarCodigo = x;
            }
            x++;
        }
        DefaultComboBoxModel modelocliente = new DefaultComboBoxModel(vlista);
        combo.setModel(modelocliente);
        if (selecionarCodigo >= 0) {
            combo.setSelectedIndex(selecionarCodigo);
        }
    }
}
