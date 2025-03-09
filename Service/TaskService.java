package Service;

import java.util.ArrayList;
import java.util.List;

import Entities.Task;
import Exceptions.DeleteException;
import Exceptions.ListException;

public class TaskService {
    
    private ArrayList<Task> tasks;
    private Task task;


    public TaskService(ArrayList<Task> tasks){
        this.tasks = new ArrayList<Task>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void showTasks(){
        if(tasks.isEmpty()){
            throw new ListException("Nenhuma tarefa cadastrada.");
        }

         tasks.stream()
            .forEach(System.out::println);
    }

    public void createTask(Task task){
        tasks.add(task);
        System.out.println("Tarefa criada");
    }

    public void deleteTask(String title){
        if(!tasks.contains(title.toLowerCase())){
            throw new DeleteException("Tarefa não encontrada.");
        }

        tasks.remove(title);
        System.out.println("Tarefa deletada.");
    }

    public void updateStatus(String title){
        if(!tasks.contains(title.toLowerCase())){
            throw new DeleteException("Tarefa não encontrada.");
        }
        task.setCompleted(true);
        System.out.println("Status atualizado.");
    
    }

    public void updateTask(String title){
        if(!tasks.contains(title.toLowerCase())){
            throw new DeleteException("Tarefa não encontrada.");
        }

        task.setTitle(title);
        task.setDescription(title);
        System.out.println("tarefa atualizada");
    }

  
}
