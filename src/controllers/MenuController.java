package controllers;

import entities.Status;
import entities.Tarefa;
import services.TarefaService;
import utilities.DateFormat;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    //private MenuService menuService = new MenuService();
    private final TarefaService tarefaService = new TarefaService();
    private  Scanner myObj = new Scanner(System.in);

    public void menu(){
        int opt = 4;
        while(opt!=0){
            System.out.println(
                    "Bem findo ao ToDo. Aqui você organiza suas tarefas de forma simples e prática \n\n" +
                            "Suas opcoes são: \n" +
                            "1. Criar uma nova tarefa \n" +
                            "2. Remover uma tarefa \n" +
                            "3. Listar todas as tarefas \n" +
                            "4. Filtrar tarefas \n" +
                            "0. Para finalizar o programa\n" +
                            "Entre com o valor referente a sua escolha: "
            );

            opt = myObj.nextInt();
            this.selectOption(opt);
           System.out.println("\n Precione Enter para voltar ao menu inicial");
            try{System.in.read();}
            catch(Exception e){}
        }

    }

    public void selectOption(int opt){
        switch (opt){
            case 1:
                myObj.nextLine();
                this.novaTarefa();
                break;
            case 2:
                this.removerTarefa();
                break;
            case 3:
                this.listarTarefas();
                break;
            case 4:
                this.filtrarTarefas();
                break;
        }

    }


    public void novaTarefa(){
        Tarefa tarefa = new Tarefa();
        System.out.println(
                "NOVA TAREFA \n\n" +
                        "O nome da tarefa deve ser unico. Ele sera usado como identificador das suas tarefas "
        );
        System.out.println("Nome da tarefa: ");
        tarefa.setNome(myObj.nextLine());
        System.out.println("Categoria: ");
        tarefa.setCategoria(myObj.nextLine());

        System.out.println("Descricao (nao usar ',' nem '{}'): ");
        tarefa.setDescricao(myObj.nextLine());

        System.out.println("Prioridade (1 a 5): ");
        tarefa.setPrioridade(myObj.nextInt());
        myObj.nextLine();
        System.out.println("Status ('todo', 'doing' ou 'done'): ");
        tarefa.setStatus(Status.valueOf(myObj.nextLine().toUpperCase()));

        System.out.println("([opcional]Data para Termino da tarefa no formato dia-mes-ano('05-04-2024' p.e.): ");
        tarefa.setDataLimite(DateFormat.outPutToInputFormat(myObj.nextLine()));

        tarefaService.novaTarefa(tarefa);

    }

    public void removerTarefa(){
        String nome;
        boolean rem;
        System.out.println("REMOCAO DE TAREFA \n");

        System.out.println("Digite o nome da tarefa que deseja remover: ");
        myObj.nextLine();
        nome = myObj.nextLine();
        rem = tarefaService.removerTarefa(nome);
        if(rem){
            System.out.println("\n Tarefa removida com sucesso");
        }   else{
            System.out.println("\n Tarefa nao encontrada");
        }
    }

    public void listarTarefas(){
        int opt;
        System.out.println("OPCOES DE LISTAGEM \n\n");
        System.out.println("1. Listar tarefas por Categoria \n" +
                "2. Listar tarefas por Prioridade \n" +
                "3. Listar tarefas por Status \n" +
                "0. Voltar ao menu principal \n" +
                "Digite sua escolha: ");
        opt = myObj.nextInt();
        tarefaService.listarTarefas(opt);
    }

    public void filtrarTarefas(){
        int opt;
        System.out.println("OPCOES DE FILTRAGEM \n\n");
        System.out.println("1. Filtrar tarefas por Categoria \n" +
                "2. Filtrar tarefas por Prioridade \n" +
                "3. Filtrar tarefas por Status \n" +
                "0. Voltar ao menu principal \n" +
                "Digite sua escolha: ");
        opt = myObj.nextInt();
        tarefaService.filtro(opt);
    }



}
