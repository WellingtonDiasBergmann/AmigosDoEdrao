package view;

import utils.RequestObject;
import utils.ResponseObject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ProjectTaskCliente {

    private final String host;
    private final int port;

    public ProjectTaskCliente(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public ResponseObject enviarRequisicao(RequestObject request) {
        try (Socket socket = new Socket(this.host, this.port); ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream()); ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {

            // Envia o RequestObject para o servidor
            outputStream.writeObject(request);

            // Recebe o ResponseObject do servidor
            return (ResponseObject) inputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseObject(false, "Erro na comunicação com o servidor.", null);
        }
    }
}
