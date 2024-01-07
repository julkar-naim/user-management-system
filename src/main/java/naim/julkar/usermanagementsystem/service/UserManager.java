package naim.julkar.usermanagementsystem.service;

import naim.julkar.usermanagementsystem.dto.UserDto;
import naim.julkar.usermanagementsystem.entity.GeneralUser;
import naim.julkar.usermanagementsystem.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class UserManager {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAllUser() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
            .map(generalUser -> modelMapper.map(generalUser, UserDto.class))
            .toList();
    }
    public void addNewUser(@Valid GeneralUser generalUser) {
        userRepository.save(generalUser);
    }
}
