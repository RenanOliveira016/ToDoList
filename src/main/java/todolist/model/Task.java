package todolist.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import todolist.enums.Priority;


@Entity
@Table(name = "tb_task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@NotBlank(message = "Task name is required")
	@Size(max = 200, message = "Task name must be at most 200 characters")
	@Column(name = "Name", length = 200, nullable = false)
	private String name;
	
	@Column(name = "Description")
	@Lob
	private String description;
	
	@Column(name = "Completed", nullable = false)
	private boolean completed;
	
	@FutureOrPresent(message = "Due date must be today or a future date")
	@Column(name = "DueDate")
	private LocalDate dueDate;
	
	@Column(name = "Priority")
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@Column(name = "Created At", updatable = false)
	private LocalDateTime createdAt;
	
	@Column(name = "Update At")
	private LocalDateTime updateAt;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	public Task() {	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
	
	public User getUser() {
	    return user;
	}

	public void setUser(User user) {
	    this.user = user;
	}

	
}
