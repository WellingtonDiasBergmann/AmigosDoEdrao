String usuarioInserido = jTextFieldNomeUsuario.getText();
        String senhaInserida = jTextFieldSenha.getText();

        ConexaoController conexao = new ConexaoController();
        ResponseObject response = conexao.sendLoginRequest(usuarioInserido, senhaInserida);

        if (response.isSuccess()) {
            TelaMenu TLMenu = new TelaMenu();
            TLMenu.setVisible(true);
            System.out.println("certo "+response);
        } else {
            jLabelContaNaoExiste.setVisible(true);
            System.out.println("errado "+response);
        }
