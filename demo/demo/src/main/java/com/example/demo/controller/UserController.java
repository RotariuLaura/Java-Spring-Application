package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model){
        List<UserDto> userDtos = userService.getAllUsers();
        model.addAttribute("title", "Users");
        model.addAttribute("users", userDtos);
        return "users";
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable Integer id, Model model){
        UserDto userDtos = userService.getUserById(id);
        model.addAttribute("title", "Users");
        model.addAttribute("users", userDtos);
        return "users";
    }

    @GetMapping("/users/delete/{id}")
    @PostMapping("/users/delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        userService.deleteUser(id);
        model.addAttribute("title", "Users");
        List<UserDto> userDtos = userService.getAllUsers();
        model.addAttribute("users", userDtos);
        return "users";
    }
}
