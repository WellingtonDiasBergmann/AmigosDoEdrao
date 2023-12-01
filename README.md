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
