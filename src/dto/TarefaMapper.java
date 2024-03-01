package dto;

import entities.Status;
import entities.Tarefa;
import utilities.DateFormat;


public class TarefaMapper {
    public static TarefaDTO fromEntity(Tarefa tarefa){
        return new TarefaDTO(tarefa.getNome(), tarefa.getCategoria(), tarefa.getDescricao(), String.valueOf(tarefa.getPrioridade()), tarefa.getStatus().getDescricao(), tarefa.getDataLimite().toString());
    }

    public static Tarefa fromDTO(TarefaDTO dto){

       return new Tarefa(dto.getNome(), dto.getCategoria(), dto.getDescricao(), Integer.parseInt(dto.getPrioridade()), Status.valueOf(dto.getStatus()),DateFormat.outPutToInputFormat(dto.getDataLimite()));
    }

}
