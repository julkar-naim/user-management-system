package naim.julkar.usermanagementsystem.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import naim.julkar.usermanagementsystem.model.User;
import naim.julkar.usermanagementsystem.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    @GetMapping
    public List<User> getUsers() {
        return userManager.getAllUser();
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.OK)
    public Map<String, Object> createUser(@Valid @RequestBody User userInfo) {
        userManager.addNewUser(userInfo);
        return Map.of(
            "message",
            "user creation successful",
            "userInfo",
            userInfo
        );
    }
}
