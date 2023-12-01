 case "validarEmail":
                    return new ResponseObject(true, "", pessoaService.validarEmail((String) request.getData()));
                case "mudarSenha":
                    pessoaService.atualizarSenha((Pessoa) request.getData());
                    return new ResponseObject(true, "senha atualizada com sucesso", null);
