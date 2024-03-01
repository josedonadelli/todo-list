
import controllers.MenuController;
import dto.TarefaDTO;
import entities.Status;
import entities.Tarefa;
import services.TarefaService;
import utilities.DateFormat;
import utilities.ToCSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static MenuController menuController = new MenuController();
    public static void main(String[] args){
//        ToCSV toCSV = new ToCSV();
//        TarefaService tarefaService = new TarefaService();
//        Tarefa tarefa = new Tarefa("Zerar jogo", "Outros", "Descricao Teste", 2, Status.DOING);
//        Tarefa tarefaData = new Tarefa("Abrir conta no banco", "Financas", "Descricao Teste", 4, Status.TODO, "11-05-2024");
//        Tarefa tarefaData2 = new Tarefa("Comprar roupas", "Shopping", "Descricao Teste", 1, Status.TODO, "13-02-2024");
//        ArrayList<Tarefa> listaDeTarefas = new ArrayList<Tarefa>();
//
//        listaDeTarefas.add(tarefa);
//        listaDeTarefas.add(tarefaData2);
//        listaDeTarefas.add(tarefaData);
//
//        List<String> listaString; //= new ArrayList<String>();
//               listaString = listaDeTarefas.stream().map((obj) -> Objects.toString(obj,null)).collect(Collectors.toList());
//        try {
//            toCSV.givenDataArray_whenConvertToCSV_thenOutputCreated(listaString);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        List<Tarefa> listaDTO = tarefaService.listaDeTarefas();
//       // System.out.println(listaDTO);
//        System.out.println("\n\n ---- SORTED ----");
//        //tarefaService.ordenadaPorStatus(listaDTO, "todo");
//
//        System.out.println("\n\n ---- datas ----");
//        listaDeTarefas.forEach(System.out::println);
//       // System.out.println(listaDeTarefas.get(2).getDataLimite());
//       //Date data = DateFormat.outPutToInputFormat("Sat Dec 11 00:00:00 BRT 2024");
//        //System.out.println(data);

            menuController.menu();


        }

}