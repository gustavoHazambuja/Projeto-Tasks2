package Application;

import java.util.Scanner;

import Exceptions.CreateException;
import Exceptions.DeleteException;
import Exceptions.ListException;
import Exceptions.UpdateException;
import Service.TaskService;

public class Programm {
    public static void main(String[] args) {
        Scanner dados = new Scanner(System.in);


        TaskService taskService = new TaskService();

         int opcao;


         do{

         
        System.out.println("*******MENU DE OPÇÕES*******");
        System.out.println("****************************");

        System.out.println("(1) Adicionar tarefa");
        System.out.println("(2) Listar tarefas");
        System.out.println("(3) Marcar como completa");
        System.out.println("(4) Editar tarefa");
        System.out.println("(5) Remover tarefa");
        System.out.println("(6) Sair");
        opcao = dados.nextInt();
        dados.nextLine();

        switch (opcao) {
            case 1:
            try {
                taskService.createTask();
            } catch (CreateException e) {
                System.out.println("Erro. " + e.getMessage());
            }
              
                break;

            case 2:
            try {
                taskService.showTasks();
            } catch (ListException e) {
                System.out.println("Erro. " + e.getMessage());
            }   
                
                break;

            case 3:
            try {
                taskService.updateStatus();
            } catch (DeleteException e) {
                System.out.println("Erro. " + e.getMessage());
            }
                 
                break;

            case 4:
                try{
                 taskService.updateTask();   
                }catch(UpdateException e){
                    System.out.println("Erro. " + e.getMessage());
                }
                 break;

            case 5:
             
            try {
                    taskService.deleteTask();
                } catch (UpdateException e) {
                    System.out.println("Erro. " + e.getMessage());
                } 
                
                break;   

            case 6:
            System.out.println("Saindo...");
            break;

            default:
            System.out.println("Opção inválida.");
            break;
        }

    }while (opcao != 6);
        
    
    dados.close();
    }
}
