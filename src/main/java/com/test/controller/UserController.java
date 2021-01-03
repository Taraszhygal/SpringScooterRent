package com.test.controller;

import com.test.dto.UserDTO;
import com.test.service.impl.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public List<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/mail/{mail}")
    public UserDTO getUserByMail(@PathVariable String mail) {
        return userService.getUserByMail(mail);
    }

    @GetMapping("/")
    public List<UserDTO> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    public List<UserDTO> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@RequestBody UserDTO userDTO,@PathVariable Long id){
        return userService.updateUser(userDTO,id);
    }
}
