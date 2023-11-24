package edu.sber.controller;


import edu.sber.dto.UserDto;
import edu.sber.entity.User;
import edu.sber.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping (value = "/{id}")
    public User findUser(@PathVariable Long id){

        return userService.findById(id);
    }

    // handler method to handle user registration request
    @PostMapping("/register")
    public Long register(@RequestBody UserDto userDto){
        User user = userService.saveUser(User.builder()
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .password(userDto.getPassword())
                .build());
        return user.getId();
    }

    @GetMapping
    public List<User> getAllUsers(){

        return userService.findAllUsers();
    }
}
