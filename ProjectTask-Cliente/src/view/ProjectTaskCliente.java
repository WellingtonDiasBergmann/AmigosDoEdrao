package view;

// autores Algayer e Wellington

import controller.ConexaoController;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import vie.TelaLogin;


public class ProjectTaskCliente {
    
    public static ConexaoController ccont;
    
    public static void main(String [] args){
        Socket socket;
        ObjectInputStream in;
        ObjectOutputStream out;
        
        try {
            System.out.println("Tentando conectar no servidor.....");
            socket = new Socket ("127.0.0.1",12345);
            System.out.println("Conectado com sucesso!");
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            
            // aqui voltaremos para abrir a tela de login e criar um objeto 
            // que irá controlar toda a comunicação com o servidor
            
            ccont = new ConexaoController(out,in);
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
