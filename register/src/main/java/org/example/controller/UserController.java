package org.example.controller;


import java.util.List;
import org.example.dto.UserDto;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping (value = "/{id}")
    public User findUser(@PathVariable Long id){

        return userService.findById(id);
    }

    // handler method to handle user registration request
    @PostMapping("/register")
    public Long register(UserDto userDto){
        User user = userService.saveUser(User.builder()
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .password(userDto.getPassword())
                .build());
        return user.getId();
    }

    // handler method to handle register user form submit request
//    @PostMapping("/register/save")
//    public String registration(@Valid @ModelAttribute("user") UserDto user,
//            BindingResult result,
//            Model model){
//        User existing = userService.findByEmail(user.getEmail());
//        if (existing != null) {
//            result.rejectValue("email", null, "There is already an account registered with that email");
//        }
//        if (result.hasErrors()) {
//            model.addAttribute("user", user);
//            return "register";
//        }
//        userService.saveUser(user);
//        return "redirect:/register?success";
//    }

    @GetMapping
    public List<User> getAllUsers(){

        return userService.findAllUsers();
    }
}
