package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.service.TaskService;

import java.util.List;

public class TaskServiceImpl extends AbstractMapService<TaskDTO,String> implements TaskService {


    @Override
    public TaskDTO save(TaskDTO object) {
        return super.save(object.getTaskID(),object);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(TaskDTO object) {
        super.update(object.getTaskID(),object);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public TaskDTO findById(String id) {
        return super.findById(id);
    }
}
