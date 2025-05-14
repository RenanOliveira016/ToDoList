package todolist.service;

import todolist.model.*;
import todolist.repository.UserRepository;
import todolist.util.PasswordEncoder;
import todolist.util.UserValidation;
import java.util.List;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public void createUser(User user) {
        UserValidation.validateName(user.getName());
        UserValidation.validateEmail(user.getEmail());
        UserValidation.validateAge(user.getAge());
        UserValidation.validatePassword(user.getPassword());

        user.setPassword(PasswordEncoder.hash(user.getPassword()));
        userRepository.save(user);

    }

    public User getUserById(Long id) {
    	UserValidation.validateId(id);
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
    	UserValidation.validateId(id);
        User user = userRepository.findById(id);
        if (user != null) {
            userRepository.delete(user);
        } else {
            throw new IllegalArgumentException("User not found for ID: " + id);
        }
    }
    
    public User login(String email, String rawPassword) {
        UserValidation.validateEmail(email);

        User user = userRepository.findByEmail(email);

        if (user == null || !PasswordEncoder.matches(rawPassword, user.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password.");
        }

        return user;
    }

}
