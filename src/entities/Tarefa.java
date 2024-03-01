package entities;

import utilities.DateFormat;

import java.util.Date;

public class Tarefa {
    private String nome;
    private String categoria;
    private String descricao;
    private int prioridade;

    private Status status;

    private Date dataLimite;

    public Tarefa(){}
    public Tarefa(String nome, String categoria, String descricao, int prioridade, Status status) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.dataLimite = null;
    }

    public Tarefa(String nome, String categoria, String descricao, int prioridade, Status status, String dataLimite) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.dataLimite = DateFormat.dateFormat(dataLimite);
    }

    public Tarefa(String nome, String categoria, String descricao, int prioridade, Status status, Date dataLimite) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.dataLimite = dataLimite;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", descricao='" + descricao + '\'' +
                ", prioridade=" + prioridade +
                ", status=" + status +
                ", dataLimite=" + dataLimite +
                '}';
    }
}
