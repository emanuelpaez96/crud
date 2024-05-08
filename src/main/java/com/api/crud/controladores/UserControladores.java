package com.api.crud.controladores;

import java.util.ArrayList;
import java.util.Optional;

import com.api.crud.modelos.UserModel;
import com.api.crud.servicios.UserServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

public class UserControladores {

        @Autowired
        private UserServicios UserService;

        @GetMapping
        public ArrayList<UserModel> getUsers(){
            return this.UserService.getUsers();
        }

        @PostMapping
        public UserModel saveUser(@RequestBody UserModel user){
            return this.UserService.saveUser(user);
        }

        @GetMapping(path="/{id}")
        public Optional<UserModel> getUserById(@PathVariable("id")Long id){
            return this.UserService.getById(id);
        }

        @PutMapping
        public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id")long id){
            return this.UserService.updateById(request, id);

        }

        @DeleteMapping(path ="/{id}")
        public String deleteById(@PathVariable("id")long id){
         boolean ok= this.UserService.deleteUser(id);

         if(ok){
            return "Usuario con id" + id + "eliminado";
         }else{
            return "Error, el usuario con id " + id + "no se pudo eliminar";
         }
         }

}
