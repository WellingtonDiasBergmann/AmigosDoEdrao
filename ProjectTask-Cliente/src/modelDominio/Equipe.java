package modelDominio;

 // autores Algayer e Wellington

import java.io.Serializable;

public class Equipe implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private int ID_Equipe;
    private String Nome;

    public int getID_Equipe() {
        return ID_Equipe;
    }

    public void setID_Equipe(int ID_Equipe) {
        this.ID_Equipe = ID_Equipe;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = Nome;
    }
    
    //DELETEs
    public Equipe(int ID_Equipe){
        this.ID_Equipe = ID_Equipe;
    }
    
    //INSERTs
    public Equipe(String Nome){
        this.Nome = Nome;
    }
    
    //UPDATEs & SELECTs
    public Equipe(int ID_Equipe, String Nome){
        this.ID_Equipe = ID_Equipe;
        this.Nome = Nome;
    }

    @Override
    public String toString() {
        return "Equipe{" + "ID_Equipe=" + ID_Equipe + ", Nome=" + Nome + '}';
    }
    
}
