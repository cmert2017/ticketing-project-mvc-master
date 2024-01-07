package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDTO {
    private String taskSubject;
    private String taskDetail;
    private ProjectDTO project;
    private UserDTO assignedEmployee;
    private Long id;
    private Status taskStatus;
    private LocalDate assignedDate;

}
