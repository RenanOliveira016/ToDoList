package todolist.util;

import java.time.LocalDate;

import todolist.enums.Priority;

public class TaskValidation {
	
	public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be empty!");
        }
        name = name.trim();

        if (name.length() < 2 || name.length() > 200) {
            throw new IllegalArgumentException("Task name must be between 2 and 200 characters long.");
        }
        if (name.contains("  ")) {
            throw new IllegalArgumentException("Task name must not contain repeated spaces.");
        }
    }

    public static void validateDueDate(LocalDate date) {
        if (date != null && date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Due date cannot be in the past.");
        }
    }

    public static void validatePriority(Priority priority) {
        if (priority == null) {
            throw new IllegalArgumentException("Priority must be defined.");
        }
    }
    
    public static void validateId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number greater than zero.");
        }
    }

}
