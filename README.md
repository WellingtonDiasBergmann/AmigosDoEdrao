 case "validarSenha":
                    return new ResponseObject(true, "", pessoaService.validarSenha((String) request.getData()));


public Pessoa validarSenha(String senha) {
        System.out.println("Validando senha: " + senha);
        Pessoa pessoa = pessoaDAO.obterPessoaPorSenha(senha);

        if (pessoa != null) {
            System.out.println("senha válido");
            return pessoa;
        } else {
            System.out.println("senha inválido");
            return null;
        }
    }


    public Pessoa obterPessoaPorSenha(String Senha) {
        String sql = "SELECT * FROM Pessoa WHERE Senha=?";
        Pessoa pessoa = null;

        try (Connection conexao = ConexaoBancoDados.abrirConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, Senha);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                int idPessoa = resultado.getInt("ID_Pessoa");
                String cpf = resultado.getString("cpf");
                String usuario = resultado.getString("usuario");
                String email = resultado.getString("senha");
                int tipo = resultado.getInt("Tipo");
                pessoa = new Pessoa(idPessoa, cpf, usuario, email, Senha, tipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoBancoDados.fecharConexao(); // Fecha a conexão
        }

        return pessoa;
    }
