package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    ProjectService projectService;
    UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String projectCreate(Model model){

        //what attributes are needed in the view. By checking view we can decide: an empty project object, all the managers, list of projects,
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers",userService.findAll());


        return "/project/create";
    }

    @PostMapping("/create")
    public String projectInsert(@ModelAttribute("project") ProjectDTO project,Model model){

        project.setProjectStatus(Status.IN_PROGRESS);
        project.setProjectDetail("Creating new project");
        projectService.save(project);

        return "redirect:/project/create";
    }



}
