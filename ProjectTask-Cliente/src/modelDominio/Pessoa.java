package modelDominio;

import java.io.Serializable;

 // autores Algayer e Wellington
         
public class Pessoa implements Serializable{
    
    
    private static final long serialVersionUID = 1L;
    
    private int ID_Pessoa;
    private String cpf;
    private String usuario;
    private String email;
    private String senha;

    public int getID_Pessoa() {
        return ID_Pessoa;
    }

    public void setID_Pessoa(int ID_Pessoa) {
        this.ID_Pessoa = ID_Pessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    //DELETEs
    public Pessoa(int ID_Pessoa){
        this.ID_Pessoa = ID_Pessoa;
    }
    
    //INSERTs
    public Pessoa(String usuario, String cpf, String senha, String email){
        this.usuario = usuario;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
    }
    
    //UPDATEs & SELECTs
    public Pessoa(int ID_Pessoa, String usuario, String cpf, String senha, String email){
        this.ID_Pessoa = ID_Pessoa;
        this.usuario = usuario;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
    }
    
    //PARA O CLIENTE FAZER LOGIN
    public Pessoa(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "CodPessoa=" + ID_Pessoa + ", cpf=" + cpf + ", usuario=" + usuario + ", email=" + email + ", senha=" + senha + '}';
    }
    
    
}
