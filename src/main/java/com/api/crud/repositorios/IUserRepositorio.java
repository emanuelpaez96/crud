package com.api.crud.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.modelos.UserModel;

@Repository
public interface IUserRepositorio extends JpaRepository<UserModel, Long>{
    

}
