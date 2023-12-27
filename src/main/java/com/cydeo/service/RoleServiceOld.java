package com.cydeo.service;

import com.cydeo.dto.RoleDTO;

import java.util.List;

public interface RoleServiceOld {

    //save, findById, delete, findAll, ...

    RoleDTO save(RoleDTO role);

    RoleDTO findByID(long id);

    List<RoleDTO> findAll();

    void delete(RoleDTO role);

    void deleteById(Long id);


}
