package com.example.RentalServiceProject.controller;

import com.example.RentalServiceProject.dto.UserDto;
import com.example.RentalServiceProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/user")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto){
        return ResponseEntity.of(Optional.of(userService.addUser(userDto)));
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.of(Optional.of(userService.getAllUser()));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getAllUser(@PathVariable Long id){
        return ResponseEntity.of(Optional.of(userService.getUserById(id)));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/user")
    public ResponseEntity<Void> updateUser(@RequestBody UserDto userDto){
        userService.updateUser(userDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
