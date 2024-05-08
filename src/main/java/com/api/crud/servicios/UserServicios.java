package com.api.crud.servicios;

import com.api.crud.modelos.UserModel;
import com.api.crud.repositorios.IUserRepositorio;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicios {

    @Autowired
    IUserRepositorio userRepository;
    
    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

    public UserModel updateById(UserModel request,Long id){
        UserModel user= userRepository.findById(id).get();

        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());

        return user;
    }

    public boolean deleteUser(long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
