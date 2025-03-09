package Service;

import java.util.ArrayList;
import java.util.Scanner;

import Entities.Task;
import Exceptions.CreateException;
import Exceptions.DeleteException;
import Exceptions.ListException;
import Exceptions.UpdateException;

public class TaskService {
    Scanner dados = new Scanner(System.in);

    String name;

    private ArrayList<Task> tasks;
    Task task = new Task();

    public TaskService(){
        this.tasks = new ArrayList<Task>();
    }


    public void showTasks(){
        if(tasks.isEmpty()){
            throw new ListException("Nenhuma tarefa cadastrada.");
        }

         tasks.stream()
            .forEach(System.out::println);
    }

    public void createTask(){
        System.out.println("Informe o nome da tarefa:");
        name = dados.nextLine();

        Task isExist = tasks.stream()
            .filter(t -> t.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);

            if(isExist != null){
                throw new CreateException("Tarefa já existente.");
            }

        System.out.println("Informe a sua descrição:");
        String description = dados.nextLine();

        Task task = new Task(name, description);
        
        tasks.add(task);
        System.out.println("\nTarefa criada");
    }

    public void deleteTask(){

        System.out.println("Informe o nome da tarefa:");
        name = dados.nextLine().toLowerCase();

        Task taskRemove = tasks.stream()
            .filter(t -> t.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElseThrow(() -> new DeleteException("Tarefa não encontrada."));

        tasks.remove(taskRemove);
        System.out.println("\nTarefa deletada.");
    }

    public void updateStatus(){

        System.out.println("Informe o nome da tarefa:");
        name = dados.nextLine().toLowerCase();

        Task taskStatus = tasks.stream()
            .filter(t -> t.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElseThrow(() -> new UpdateException("Tarefa não encontrada."));

        taskStatus.setCompleted(true);
        System.out.println("\nStatus atualizado.");
    
    }

    public void updateTask(){

        System.out.println("Informe o nome da tarefa:");
        name = dados.nextLine().toLowerCase();

        Task taskUpdate = tasks.stream()
            .filter(t -> t.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElseThrow(() -> new UpdateException("Tarefa não encontrada."));
       
        System.out.println("Infome o novo nome da tarefa:");
        String newName = dados.nextLine().toLowerCase();

        boolean nameExists = tasks.stream()
            .anyMatch(t -> t.getName().equalsIgnoreCase(newName));

        if(nameExists){
            throw new UpdateException("Tarefa já existente.");
        }    

        System.out.println("Infome a nova descrição:");
        String description = dados.nextLine().toLowerCase();

        taskUpdate.setName(name);
        taskUpdate.setDescription(description);
        taskUpdate.setCompleted(false);
        System.out.println("\ntarefa atualizada");
    }


  
}
