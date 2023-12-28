package com.cydeo.bootstrap;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import com.cydeo.service.impl.RoleServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;

    public DataGenerator(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
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


    }
}
