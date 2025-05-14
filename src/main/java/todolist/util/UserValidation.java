package todolist.util;

public class UserValidation {

	public static void validateName(String name) {
		
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty!");
		}

		name = name.trim();

		String nameRegex = "^[\\p{L} ]+$";

		if (!name.matches(nameRegex)) {
			throw new IllegalArgumentException("The name must contain only letters and spaces!");
		}
		if (name.length() < 2 || name.length() > 150) {
			throw new IllegalArgumentException("The name must be between 2 and 150 characters long!");
		}
		if (name.contains("  ")) {
			throw new IllegalArgumentException("The name must not contain repeated spaces!");
		}
	}

	public static void validateEmail(String email) {

		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("Email cannot be empty!");
		}
		
		email = email.trim();

		String emailRegex = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,}$";

		if (!email.matches(emailRegex)) {
			throw new IllegalArgumentException("Invalid email format!");
		}
	}
	
	public static void validatePassword(String password) {
	    if (password == null || password.trim().isEmpty()) {
	        throw new IllegalArgumentException("Password cannot be empty.");
	    }

	    if (password.length() < 6 || password.length() > 60) {
	        throw new IllegalArgumentException("Password must be between 6 and 60 characters long.");
	    }
	}
	
	public static void validateId(Long id) {
	    if (id == null || id <= 0) {
	        throw new IllegalArgumentException("ID must be a positive number greater than zero.");
	    }
	}
	
	public static void validateAge(int age) {
	    if (age < 0 || age > 150) {
	        throw new IllegalArgumentException("Age must be between 0 and 150.");
	    }
	}
}
