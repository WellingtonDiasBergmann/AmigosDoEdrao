package controller;

import com.example.common.utils.RequestObject;
import com.example.common.utils.ResponseObject;
import com.example.common.model.Pessoa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConexaoController {

    private final String SERVER_ADDRESS = "127.0.0.1";
    private final int SERVER_PORT = 8080;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private static final String TAG = "ConexaoController";

    public ConexaoController() {
        connect();
    }

    private synchronized void connect() {
        try {
            System.out.println(TAG + " :Tentando conectar");
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(socket.getInputStream());

            System.out.println(TAG + ":Conectado com sucesso");
        } catch (IOException e) {
            System.err.println(TAG + "Erro ao conectar " + e.getMessage());
        }
    }

    public ResponseObject sendRequest(RequestObject request) {
        try {
            System.out.println(TAG + "Enviando requisição");
            out.writeObject(request);
            out.flush();
            System.out.println(TAG + "Requisição enviada. Aguardando respota....");
            Object response = in.readObject();
            if (response instanceof ResponseObject) {
                return (ResponseObject) response;
            } else {
                System.err.println(TAG + ":Resposta invalida do servidor.");
                return new ResponseObject(false, "Resposta invalida do servidor.", null);
            }
        } catch (IOException e) {
            System.err.println(TAG + "Conexao perdida. Reconectando....");
            connect();
            return new ResponseObject(false, "Reconectando ao servidor.", null);

        } catch (Exception e) {
            System.err.println(TAG + ":Erro ao enviar requisição ou ao receber resposta " + e.getMessage());
            return new ResponseObject(false, "Erro ao enviar requisição ou ao receber resposta: " + e.getMessage(), null);
        }
    }

    public ResponseObject sendLoginRequest(String username, String senha) {
        System.out.println(TAG + ":Enviado requisição de login para o usuario " + username);
        Pessoa user = new Pessoa(username, senha);
        RequestObject request = new RequestObject("login", user);
        return sendRequest(request);
    }

    public void closeConecction() {
        try {
            System.out.println(TAG + "Fechyando conexao....");
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            if (socket != null) {
                socket.close();
            }
            System.out.println(TAG + "Conexao Fechada");
        } catch (IOException e) {
            System.out.println(TAG + "Errp ao fechart conexão " + e.getMessage());
        }
    }
}
