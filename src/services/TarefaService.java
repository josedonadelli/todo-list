package services;

import entities.Tarefa;
import utilities.ToCSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TarefaService {
    private ToCSV toCSV;
    public void salvarTarefa(Tarefa tarefa) throws IOException {
        String obj = tarefa.toString();
        List<String>tarefas = toCSV.openCSVFile();
        tarefas.add(tarefa.toString());

        toCSV.givenDataArray_whenConvertToCSV_thenOutputCreated(tarefas);
    }




}
