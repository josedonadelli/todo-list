package services;

import dto.TarefaDTO;
import dto.TarefaMapper;
import entities.Status;
import entities.Tarefa;
import utilities.ToCSV;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TarefaService {
    private ToCSV toCSV = new ToCSV();


    public List<Tarefa> listaDeTarefas(){
        List<String>tarefas = toCSV.openCSVFile();
        int size = tarefas.size();
        List<TarefaDTO> listaDTO = new ArrayList<TarefaDTO>();
        for(int i = 0; i < size ; i++){
            listaDTO.add(fromString(tarefas.get(i).replace("'", "").split(",")));
        }
        return listaDTO.stream().map(TarefaMapper::fromDTO).collect(Collectors.toList());
    }
    public void novaTarefa(Tarefa tarefa) {
        List<Tarefa>tarefas = this.listaDeTarefas();
        boolean exist = false;
        for(Tarefa t : tarefas){
            if(t.getNome().equalsIgnoreCase(tarefa.getNome())){
                exist = true;
                break;
            }
        }
        if(!exist){
            tarefas.add(tarefa);
            tarefas.sort(Comparator.comparing(Tarefa::getPrioridade));;
            this.salvarListaDeTarefas(tarefas);
            System.out.println("Tarefa salva com sucesso");
        } else{
            System.out.println("Erro ao criar nova tarefa: uma tarefa com o mesmo nome já existe");
        }

    }

    public void salvarListaDeTarefas(List<Tarefa> tarefas){
        List<String>tarefasString = new ArrayList<String>();

        for(Tarefa t : tarefas){
            tarefasString.add(t.toString());
        }
        try {
            toCSV.givenDataArray_whenConvertToCSV_thenOutputCreated(tarefasString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removerTarefa(String nome){
        List<Tarefa> tarefas = this.listaDeTarefas();
        int index = -1, inSize = tarefas.size();

        for (int i = 0; i < inSize; i++){
            if(tarefas.get(i).getNome().equalsIgnoreCase(nome)){
                index = i;
                break;
            }

        }
        tarefas.remove(index);
        if(inSize==tarefas.size()){
            return false;
        }   else{
            this.salvarListaDeTarefas(tarefas);
            return true;
        }
    }

    public void listarTarefas(int opt) {
        List<Tarefa> tarefas = this.listaDeTarefas();

        switch (opt){
            case 1:
                tarefas.sort(Comparator.comparing(Tarefa::getCategoria));
                break;
            case 2:
                break;
            case 3:
                tarefas.sort(Comparator.comparing(Tarefa::getStatus));
                break;


        }
        tarefas.forEach(System.out::println);
    }

    public static TarefaDTO fromString(String[] tarefa){
        int tamanho = tarefa.length;
        TarefaDTO dto;
        List<String> dados = new ArrayList<String>();

        for(int i = 0; i < tamanho; i++){
            dados.add(tarefa[i].split("[=}]")[1]);
        }
        dto = new TarefaDTO(dados.get(0), dados.get(1), dados.get(2), dados.get(3),dados.get(4),dados.get(5));
        return dto;
    }

    public void filtroPorCategoria(List<Tarefa> tarefas, String categoria){
        List<Tarefa> tarefasFiltradas = new ArrayList<Tarefa>();
        for (Tarefa tarefa : tarefas){
            if(tarefa.getCategoria().equals(categoria)){
                tarefasFiltradas.add(tarefa);
            }
        }

        tarefasFiltradas.forEach(System.out::println);
    }

    public void filtroPorPrioridade(List<Tarefa> tarefas, int prioridade){
        List<Tarefa> tarefasFiltradas = new ArrayList<Tarefa>();

        for (Tarefa tarefa : tarefas){
            if(tarefa.getPrioridade() == prioridade){
                tarefasFiltradas.add(tarefa);
            }
        }
        tarefasFiltradas.forEach(System.out::println);
    }

    public void filtroPorStatus(List<Tarefa> tarefas, String status){
        List<Tarefa> tarefasFiltradas = new ArrayList<Tarefa>();
        for (Tarefa tarefa : tarefas){
            if(tarefa.getStatus().getDescricao().equalsIgnoreCase(status)){
                tarefasFiltradas.add(tarefa);
            }
        }
        System.out.println("Foram encontradas " + tarefasFiltradas.size() + " tarefas com o status " + status.toUpperCase() + ": \n");
        tarefasFiltradas.forEach(System.out::println);
    }

    public void filtro(int opt){
        List<Tarefa> tarefas = this.listaDeTarefas();
        Scanner myObj = new Scanner(System.in);
        switch (opt){
            case 1:
                System.out.println("Informe a categoria desejada");
                this.filtroPorCategoria(tarefas, myObj.nextLine());
                break;
            case 2:
                System.out.println("Informe a prioridade desejada (valores de 1 a 5)");
                this.filtroPorPrioridade(tarefas, Integer.parseInt(myObj.nextLine()));
                break;
                case 3:
                    System.out.println("Informe o Status desejado");
                    this.filtroPorStatus(tarefas, myObj.nextLine());

        }
    }





}
