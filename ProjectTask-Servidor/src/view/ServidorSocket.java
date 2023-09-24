package view;

import factory.Conector;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {

    public static void main(String[] args) {

        Conector.getConnection();
        System.out.println("Conectou no banco de dados!!");

        try {
            //ESPERANDO O ENVIO DE MENSAGENS DO CLIENTE
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor inicializado. Aguardando conexão...");
            int idUnico = 0;
            while (true) {
                //AGUARDANDO AS CONEXÕES DOS CLIENTES
                Socket cliente = servidor.accept();
                System.out.println("Um novo cliente se conectou: " + cliente);
                idUnico++;
                System.out.println("Iniciando uma nova thread para o cliente: " + idUnico);
                //CRIAR O CONTROLLER
                TrataClienteController trataCliente = new TrataClienteController(cliente, idUnico);

            }
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
