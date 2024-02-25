
import entities.Status;
import entities.Tarefa;
import utilities.ToCSV;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        ToCSV toCSV = new ToCSV();
        Tarefa tarefa = new Tarefa("Tarefa Teste 1", "Categoria Teste", "Descricao Teste", 2, Status.TODO);
        Tarefa tarefaData = new Tarefa("Tarefa Teste 2", "Categoria Teste", "Descricao Teste", 2, Status.TODO, "12-05-2024");
        Tarefa tarefaData2 = new Tarefa("Tarefa Teste 3", "Categoria Teste", "Descricao Teste", 2, Status.TODO, "12-05-2024");
        //System.out.println(tarefaData);

        ArrayList<Tarefa> listaDeTarefas = new ArrayList<Tarefa>();

        listaDeTarefas.add(tarefa);
        listaDeTarefas.add(tarefaData);

        List<String> listaString; //= new ArrayList<String>();
               listaString = listaDeTarefas.stream().map((obj) -> Objects.toString(obj,null)).collect(Collectors.toList());

        //Criar inicializador com data como String e como Date: Receber string, tratar e retornar com date?
        //Criar CRUD em json ou txt
        //Criar ordenação e balanceamento
        }

}