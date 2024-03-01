
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
            menuController.menu();
        }

}