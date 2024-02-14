package entities;

public enum Status {
    TODO("todo"),
    DOING("doing"),
    DONE("done");

    private String descricao;

    Status(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }



}
