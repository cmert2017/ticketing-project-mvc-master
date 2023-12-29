package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user",new UserDTO());
        model.addAttribute("roles",roleService.findAll()); //bring me all roles from database
        model.addAttribute("users",userService.findAll()); //bring me all users from database

        return "/user/create";
    }

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user,Model model){
       // model.addAttribute("user",new UserDTO());
        //model.addAttribute("roles",roleService.findAll()); //bring me all roles from database
        userService.save(user);
        //model.addAttribute("users",userService.findAll()); //bring me all users from database

       // return "/user/create"; // <--- in this view html, we used user, roles, users attributes, so we need to add them as attributes
        return "redirect:/user/create";
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username){



        return "/update";
    }

    @PostMapping("/update")
    public String userUpdate(){

        return "/update";
    }







}
