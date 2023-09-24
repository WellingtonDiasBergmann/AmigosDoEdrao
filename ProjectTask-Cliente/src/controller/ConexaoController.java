package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelDominio.*;

// autores Algayer e Wellington

public class ConexaoController {

    private ObjectOutputStream out;
    private ObjectInputStream in;

    //usuario que fez login
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public ConexaoController(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
    }

    public Pessoa efetuarLogin(Pessoa usr) {
        try {
            //ENVIANDO O COMANDO PARA O SERVIDOR
            out.writeObject("EfetuarLogin");
            String msg = (String) in.readObject();
            //ENVIANDO O USUARIO QUE VEIO DA TELA LOGIN
            out.writeObject(usr);
            //RETORNO DO USUARIO QUE SERVIDOR BUSCOU NO BANCO
            return (Pessoa) in.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void fim() {
        try {
            out.writeObject("fim");
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
