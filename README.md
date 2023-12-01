 case "validarEmail":
                    return new ResponseObject(true, "", pessoaService.validarEmail((String) request.getData()));
                case "mudarSenha":
                    pessoaService.atualizarSenha((Pessoa) request.getData());
                    return new ResponseObject(true, "senha atualizada com sucesso", null);

public Pessoa validarEmail(String email) {
        System.out.println("Validando email: " + email);
        Pessoa pessoa = pessoaDAO.obterPessoaPorEmail(email);

        if (pessoa != null) {
            System.out.println("Email válido");
            return pessoa;
        } else {
            System.out.println("Email inválido");
            return null;
        }
    }
    
    public void atualizarSenha(Pessoa pessoa) {
        pessoaDAO.atualizarSenha(pessoa);
    }


public Pessoa obterPessoaPorEmail(String email) {
        String sql = "SELECT * FROM Pessoa WHERE Email=?";
        Pessoa pessoa = null;

        try (Connection conexao = ConexaoBancoDados.abrirConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                int idPessoa = resultado.getInt("ID_Pessoa");
                String cpf = resultado.getString("cpf");
                String usuario = resultado.getString("usuario");
                String senhaCriptografada = resultado.getString("senha");
                int tipo = resultado.getInt("Tipo");
                pessoa = new Pessoa(idPessoa, cpf, usuario, email, senhaCriptografada, tipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoBancoDados.fecharConexao(); // Fecha a conexão
        }

        return pessoa;
    }
    
    public void atualizarSenha(Pessoa pessoa) {
        String sql = "UPDATE Pessoa SET Senha = ? WHERE ID_Pessoa=?";
        try (Connection conexao = ConexaoBancoDados.abrirConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getSenha());
            stmt.setInt(2, pessoa.getID_Pessoa());
            stmt.executeUpdate();
            ConexaoBancoDados.commit(); // Realiza o commit da transação
        } catch (SQLException e) {
            ConexaoBancoDados.rollback(); // Em caso de erro, faz o rollback
            e.printStackTrace();
        } finally {
            ConexaoBancoDados.fecharConexao(); // Fecha a conexão
        }
    }
