package com.cydeo.bootstrap;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;
    ProjectService projectService;
    TaskService taskService;


    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService, TaskService taskService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {
        RoleDTO adminRole = new RoleDTO(1L,"Admin");
        RoleDTO managerRole = new RoleDTO(2L,"Manager");
        RoleDTO employeeRole = new RoleDTO(3L,"Employee");


        //add these data to map
//        RoleServiceImpl r  = new RoleServiceImpl(); // this is tight coupling and so we dont prefer this.
//        r.save(adminRole);
//        r.save(managerRole);
//        r.save(employeeRole);

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);


        UserDTO user1 = new UserDTO("John","Kesy","john@gmail.com","Abc1",true,"4565432321",managerRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Mike","Smith","mike@gmail.com","Abc2",true,"1232343445",adminRole, Gender.MALE);
        UserDTO user3 = new UserDTO("Delise","Jark","delise@gmail.com","Abc3",true,"9876543423",managerRole, Gender.FEMALE);
        UserDTO user4 = new UserDTO("Craig","Hayns","Craig@gmail.com","Abc4",true,"4566543432",employeeRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Shaun","Loren","Shaun@gmail.com","Abc5",true,"7655678789",managerRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Elizebeth","Ada","Elizebeth@gmail.com","Abc6",true,"8763451234",employeeRole, Gender.FEMALE);
        UserDTO user7 = new UserDTO("Maria","Matt","maria@gmail.com","Abc7",true,"7653452343",employeeRole, Gender.FEMALE);
        UserDTO user8 = new UserDTO("Bill","Norre","Bill@gmail.com","Abc8",true,"7654532465",adminRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);


        ProjectDTO project1 = new ProjectDTO("Spring MVC","PR001",user1, LocalDate.now(),LocalDate.now().plusDays(25),"Creating Controllers", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Spring ORM","PR002",user2, LocalDate.now(),LocalDate.now().plusDays(25),"Creating Database", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Spring Container","PR003",user3, LocalDate.now(),LocalDate.now().plusDays(25),"Creating Container", Status.COMPLETE);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);


        TaskDTO task1 = new TaskDTO("Building project","meeting with share holders and building BRD",project1,user1,Status.OPEN,LocalDate.of(2023,12,2));
        TaskDTO task2 = new TaskDTO("Implementing project","meeting with employees and starting to implement",project2,user2,Status.IN_PROGRESS,LocalDate.of(2023,11,5));
        TaskDTO task3 = new TaskDTO("Completing project","meeting with PO and closing  project",project3,user3,Status.COMPLETE,LocalDate.of(2023,10,3));

        taskService.save(task1);
        taskService.save(task2);
        taskService.save(task3);
    }
}
