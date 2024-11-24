package naim.julkar.usermanagementsystem.controller;

import java.util.List;
import java.util.Map;
import naim.julkar.usermanagementsystem.dto.UserDto;
import naim.julkar.usermanagementsystem.entity.GeneralUser;
import naim.julkar.usermanagementsystem.service.UserManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<UserDto> getUsers() {
        return userManager.getAllUser();
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.OK)
    public Map<String, Object> createUser(@RequestBody UserDto userInfo) {
        GeneralUser generalUser = modelMapper.map(userInfo, GeneralUser.class);
        userManager.addNewUser(generalUser);
        return Map.of(
            "message",
            "user creation successful",
            "userInfo",
            userInfo
        );
    }
}
