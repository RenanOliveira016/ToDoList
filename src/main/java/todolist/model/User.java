package todolist.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tb_users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private Long id;
	
	@NotBlank(message = "Name is required")	
	@Size(max = 150, message = "Name must be at most 150 characters")
	@Column(name = "Name", length = 150, nullable = false)
	private String name;
	
	@NotBlank(message = "Email is required")
	@Email
	@Column(name = "E-mail", nullable = false, unique = true)
	private String email;
	
	@NotBlank(message = "Password is required.")
	@Size(min = 6, max = 60, message = "Password must be between 6 and 60 characters.")
	@Column(nullable = false)
	private String password;

	
	@Min(value = 0, message = "Age must be at least 0")
	@Max(value = 120, message = "Age must be realistc")
	@Column(name = "Age", nullable = false)
	private int age;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Task> tasks = new ArrayList<>();
	
	public User() { }
	
	//Getters and Setters
	public Long getId(){ return id;	}
	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getEmail(){ return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getPassword(){ return password; }
	public void setPassword(String password) { this.password = password; }
	
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	
}	
