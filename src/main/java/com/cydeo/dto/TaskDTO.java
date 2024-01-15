package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Data
public class TaskDTO {
    private String taskSubject;
    private String taskDetail;
    private ProjectDTO project;
    private UserDTO assignedEmployee;
    private Long id;  //postgres will assign this so we dont need @AllArgsConstructor
    private Status taskStatus;
    private LocalDate assignedDate;

    public TaskDTO(String taskSubject, String taskDetail, ProjectDTO project, UserDTO assignedEmployee, Status taskStatus, LocalDate assignedDate) {
        this.taskSubject = taskSubject;
        this.taskDetail = taskDetail;
        this.project = project;
        this.assignedEmployee = assignedEmployee;
        this.taskStatus = taskStatus;
        this.assignedDate = assignedDate;
        this.id = UUID.randomUUID().getMostSignificantBits();
    }
}
