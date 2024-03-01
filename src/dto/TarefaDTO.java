package dto;

public class TarefaDTO {
    private String nome;
    private String categoria;
    private String descricao;
    private String prioridade;

    private String status;

    private String dataLimite;

    public TarefaDTO(String nome, String categoria, String descricao, String prioridade, String status, String dataLimite) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.dataLimite = dataLimite;
    }

    public TarefaDTO(){}
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

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    @Override
    public String toString() {
        return "TarefaDTO{" +
                "nome='" + nome + '\'' +
                ", categoria=" + categoria + '\'' +
                ", descricao=" + descricao + '\'' +
                ", prioridade=" + prioridade + '\'' +
                ", status='" + status + '\'' +
                ", dataLimite='" + dataLimite + '\'' +
                '}';
    }
}
