package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    ProjectService projectService;
    UserService userService;

    TaskService taskService;

    public TaskController(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String taskCreate(Model model){

        model.addAttribute("task", new TaskDTO());
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("users",userService.findAll());


        return "/task/create";
    }

    @PostMapping("/create")
    public String taskInsert(@ModelAttribute("task") TaskDTO task){

         taskService.save(task);

        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String taskDelete(@PathVariable(value = "id") Long id){

        taskService.deleteById(id);

        return "redirect:/task/create";
    }

    @GetMapping("/update/{id}")
    public String taskEdit(@PathVariable(value = "id") Long id, Model model){

        model.addAttribute("task", taskService.findById(id));
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("users",userService.findEmployees());

        return "/task/update";
    }


//    @PostMapping("/update/{taskId}")
//    public String taskUpdate(@PathVariable(value = "taskId") Long taskId,@ModelAttribute(value = "task") TaskDTO task){
//        task.setId(taskId);
//        taskService.update(task);
//        return "redirect:/task/create";
//    }

    @PostMapping("/update/{Id}") //above method can be shorten like this. Spring is dealing with the setting id. important thing is here we need to use path parameter as same as the field in the DTO.
    public String taskUpdate(@ModelAttribute(value = "task") TaskDTO task){
        taskService.update(task);
        return "redirect:/task/create";
    }


}
