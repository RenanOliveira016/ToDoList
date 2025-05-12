package todolist.service;

import todolist.model.Task;
import todolist.repository.TaskRepository;
import todolist.util.TaskValidation;

import java.util.List;

public class TaskService {

    private final TaskRepository taskRepository = new TaskRepository();

    public void createTask(Task task) {
        TaskValidation.validateName(task.getName());
        TaskValidation.validateDueDate(task.getDueDate());
        TaskValidation.validatePriority(task.getPriority());

        taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        TaskValidation.validateId(id);
        return taskRepository.findById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(Long id) {
        TaskValidation.validateId(id);
        Task task = taskRepository.findById(id);
        if (task != null) {
            taskRepository.delete(task);
        } else {
            throw new IllegalArgumentException("Task not found for ID: " + id);
        }
    }
}
