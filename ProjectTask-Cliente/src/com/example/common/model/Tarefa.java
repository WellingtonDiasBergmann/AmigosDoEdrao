package com.example.common.model;

 // autores Algayer e Wellington

import java.io.Serializable;
import java.sql.Time;

public class Tarefa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private int ID_Tarefa;
    private String Nome;
    private String Descricao;
    private Time HorasTrabalhada;
    private int ID_Projeto;
    private int ID_Pessoa;

    public int getID_Tarefa() {
        return ID_Tarefa;
    }

    public void setID_Tarefa(int ID_Tarefa) {
        this.ID_Tarefa = ID_Tarefa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Time getHorasTrabalhada() {
        return HorasTrabalhada;
    }

    public void setHorasTrabalhadas(Time HorasTrabalhada) {
        this.HorasTrabalhada = HorasTrabalhada;
    }

    public int getID_Projeto() {
        return ID_Projeto;
    }

    public void setID_Projeto(int ID_Projeto) {
        this.ID_Projeto = ID_Projeto;
    }

    public int getID_Pessoa() {
        return ID_Pessoa;
    }

    public void setID_Pessoa(int ID_Pessoa) {
        this.ID_Pessoa = ID_Pessoa;
    }
    
    //DELETEs
    public Tarefa(int ID_Tarefa){
        this.ID_Tarefa = ID_Tarefa;
    }
    
    //INSERTs
    public Tarefa(String Nome, String Descricao, Time HorasTrabalhada, int ID_Pessoa, int ID_Projeto){
        this.Nome = Nome;
        this.Descricao = Descricao;
        this.HorasTrabalhada = HorasTrabalhada;
        this.ID_Pessoa = ID_Pessoa;
        this.ID_Projeto = ID_Projeto;
    }
    
    //UPDATEs & SELECTs
    public Tarefa(int ID_Tarefa, String Nome, String Descricao, Time HorasTrabalhada, int ID_Pessoa, int ID_Projeto){
        this.ID_Tarefa = ID_Tarefa;
        this.Nome = Nome;
        this.Descricao = Descricao;
        this.HorasTrabalhada = HorasTrabalhada;
        this.ID_Pessoa = ID_Pessoa;
        this.ID_Projeto = ID_Projeto;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "ID_Tarefa=" + ID_Tarefa + ", Nome=" + Nome + ", Descricao=" + Descricao + ", HorasTrabalhada=" + HorasTrabalhada + ", ID_Projeto=" + ID_Projeto + ", ID_Pessoa=" + ID_Pessoa + '}';
    }
    
    
}
