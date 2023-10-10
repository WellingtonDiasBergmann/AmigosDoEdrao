package controller;

import com.example.common.utils.RequestObject;
import com.example.common.utils.ResponseObject;
import com.example.common.model.Pessoa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoController {

    private static final Logger LOGGER = Logger.getLogger(ConexaoController.class.getName());
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
        LOGGER.log(Level.INFO, "Preparando para enviar requisição: {0}", request.getOperation());
        try {
            LOGGER.log(Level.INFO, "Enviando requisição...");
            out.writeObject(request);
            out.flush();
            LOGGER.log(Level.INFO, "Requisição enviada. Aguardando resposta...");
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
            LOGGER.log(Level.SEVERE, "Erro ao enviar requisição ou receber resposta", e);
            return new ResponseObject(false, "Erro ao enviar requisição ou ao receber resposta: " + e.getMessage(), null);
        }
    }

    public ResponseObject sendLoginRequest(String username, String password) {
        System.out.println(TAG + ":Enviado requisição de login para o usuario " + username);
        Pessoa user = new Pessoa(username, password);
        RequestObject request = new RequestObject("login", user);
        return sendRequest(request);
    }

    public ResponseObject criarFuncionario(String cpf, String nome, String email, String senha) {
        System.out.println(TAG + ":Enviando requisição de criar funcionario para o usuario");
        Pessoa pessoa = new Pessoa(cpf, nome, email, senha);
        RequestObject request = new RequestObject("criarPessoa", pessoa);
        return sendRequest(request);
    }

    public ResponseObject listarPessoas() {
        try {
            System.out.println(TAG + ":Enviando requisição de listar funcionario para o usuario");
            RequestObject request = new RequestObject("listarTodosPessoa", null);
            return sendRequest(request);
        } catch (Exception e) {
            System.err.println("Erro ao listar pessoas: " + e.getMessage());
            return null;
        }
    }

    public void closeConecction() {
        try {
            System.out.println(TAG + "Fechando conexao....");
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
