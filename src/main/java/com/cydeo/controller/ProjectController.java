package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

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
        model.addAttribute("managers",userService.findManagers());


        return "/project/create";
    }

    @PostMapping("/create")
    public String projectInsert(@ModelAttribute("project") ProjectDTO project){

       // project.setProjectStatus(Status.IN_PROGRESS); <--- such business logic should be inside the service
        projectService.save(project);

        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String projectDelete(@PathVariable(value = "projectCode") String projectCode){

        projectService.deleteById(projectCode);

        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String projectEdit(@PathVariable(value = "projectCode") String projectCode, Model model){

        model.addAttribute("project",projectService.findById(projectCode));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers",userService.findManagers());

        return "/project/update";
    }

    @PostMapping ("/update/{projectCode}")
    public String projectUpdate(@ModelAttribute("project") ProjectDTO project){

        //projectService.save(project);
        projectService.update(project);

        return "redirect:/project/create";
    }

    @GetMapping ("/complete/{projectCode}")
    public String projectComplete(@PathVariable(value = "projectCode") String projectCode){

        projectService.complete(projectService.findById(projectCode));

        return "redirect:/project/create";
    }

    @GetMapping ("/status")
    public String projectStatus(){


        return "/manager/project-status";
    }

}
