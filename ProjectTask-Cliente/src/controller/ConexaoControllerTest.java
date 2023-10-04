package controller;

import com.example.common.utils.ResponseObject;

public class ConexaoControllerTest {

    public static void main(String[] args) {
        ConexaoController conexao = new ConexaoController();

        String username = "Algayer";
        String senha = "Senha14051979";

        System.out.println("[Test] Preparando para enviar a requisição de login");
        System.out.println("[Test] nome de usuario " + username);
        System.out.println("[Test] Senha de usuario " + senha);
        ResponseObject response = conexao.sendLoginRequest(username, senha);
        System.out.println("[Test] Resposta recebida do servidor");
        System.out.println("[Test] Sucesso " + response.isSuccess());
        System.out.println("[Test] Mensagem " + response.getMessage());
        if (response.getData() != null) {
            System.out.println("[Test] Dados " + response.getData().toString());
        } else {
            System.out.println("[Test] Sem dados na resposta");
        }
        conexao.closeConecction();
        System.out.println("[Test] Conexão perdida.");
    }
}
