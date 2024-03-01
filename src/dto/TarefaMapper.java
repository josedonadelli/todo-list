package dto;

import entities.Status;
import entities.Tarefa;
import utilities.DateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static services.TarefaService.fromString;

public class TarefaMapper {
    public static TarefaDTO fromEntity(Tarefa tarefa){
        return new TarefaDTO(tarefa.getNome(), tarefa.getCategoria(), tarefa.getDescricao(), String.valueOf(tarefa.getPrioridade()), tarefa.getStatus().getDescricao(), tarefa.getDataLimite().toString());
    }

    public static Tarefa fromDTO(TarefaDTO dto){

       return new Tarefa(dto.getNome(), dto.getCategoria(), dto.getDescricao(), Integer.parseInt(dto.getPrioridade()), Status.valueOf(dto.getStatus()),DateFormat.outPutToInputFormat(dto.getDataLimite()));
    }

    public static List<TarefaDTO> fromStringToDTO(List<String> tarefas){
        List<TarefaDTO> listaDTO = new ArrayList<TarefaDTO>();

        for(String tarefa : tarefas){
            for(int i = 0; i < tarefas.size() ; i++){
                listaDTO.add(fromString(tarefas.get(i).replace("'", "").split(",")));
            }
        }
        return listaDTO;
    }

}
