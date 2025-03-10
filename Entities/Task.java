package Entities;

public class Task{

    private String name;
    private String description;
    private boolean completed;

    public Task(){
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString(){
        return String.format("\nNome: %s\n" + "Descrição: %s\n" + "Completa: %b\n ", name, description, completed);
    }

    
    
}