package todolist.service;

import todolist.model.Task;
import todolist.model.User;
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
    
    public List<Task> getTasksByUser(User user) {
        if (user == null || user.getId() == null) {
            throw new IllegalArgumentException("User must be logged in.");
        }

        return taskRepository.findByUser(user);
    }

    public void deleteTask(Long taskId, User user) {
        TaskValidation.validateId(taskId);

        Task task = taskRepository.findById(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found.");
        }

        if (!task.getUser().getId().equals(user.getId())) {
            throw new IllegalArgumentException("You do not have permission to delete this task.");
        }

        taskRepository.delete(task);
    }

}
