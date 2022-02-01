package com.jsr.api.controller;

import java.util.List;

import com.jsr.api.model.User;
import com.jsr.api.repository.UserRepository;
import com.jsr.api.security.jwtController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<User> getUserByUsername(@RequestBody User user){   
        try{
		jwtController jwt = new jwtController();		
		    User usuario = userRepository.findByCredentials(user.getAlias_usuario(), user.getPass_usuario());
            String token = jwt.getJWTToken(usuario.getAlias_usuario());
            usuario.setToken(token);
            return ResponseEntity.ok().body(usuario);
        }  catch (IllegalStateException exc) {
            throw new ResponseStatusException(
              HttpStatus.NOT_FOUND, "Usuario o contraseña invalidos.", exc);
       }
    }
}