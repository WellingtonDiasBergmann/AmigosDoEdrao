String nomeUsuario = jTextFieldNomeUsuario.getText();
        String senhaInserida = jTextFieldSenha.getText();

        Pessoa user = new Pessoa(nomeUsuario, senhaInserida);
        RequestObject request = new RequestObject("login", user);
        ConexaoController conexao = new ConexaoController();
        ResponseObject response = conexao.sendRequest(request);

        if (response.isSuccess()) {
            TelaMenu TLMenu = new TelaMenu();
            TLMenu.setVisible(true);
        } else {
            jLabelContaNaoExiste.setVisible(true);
        }
