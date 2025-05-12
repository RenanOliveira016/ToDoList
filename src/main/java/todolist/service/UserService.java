package todolist.service;

import todolist.model.User;
import todolist.repository.UserRepository;
import todolist.util.UserValidation;

import java.util.List;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public void createUser(User user) {
        UserValidation.validateName(user.getName());
        UserValidation.validateEmail(user.getEmail());
        UserValidation.validateAge(user.getAge());

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
}
