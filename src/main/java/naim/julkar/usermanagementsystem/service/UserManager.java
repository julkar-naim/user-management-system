package naim.julkar.usermanagementsystem.service;

import java.util.List;
import naim.julkar.usermanagementsystem.exception.UserNameAlreadyExistsException;
import naim.julkar.usermanagementsystem.model.User;
import naim.julkar.usermanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll().stream().toList();
    }

    public void addNewUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UserNameAlreadyExistsException("Username already exists");
        }
        userRepository.save(user);
    }
}
