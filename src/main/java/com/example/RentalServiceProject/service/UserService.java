package com.example.RentalServiceProject.service;

import com.example.RentalServiceProject.dto.UserDto;
import com.example.RentalServiceProject.model.User;
import com.example.RentalServiceProject.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public  UserDto addUser(UserDto userDto) {
        return toDTO(userRepo.save(toDO(userDto)));
    }

    private User toDO(UserDto userDto){
        return new User().builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .number(userDto.getNumber())
                .email(userDto.getEmail())
                .gender(userDto.getGender())
                .type(userDto.getType())
                .accountNumber(userDto.getAccountNumber())
                .cinic(userDto.getCinic())
                .address(userDto.getAddress())
                .build();
    }

    private UserDto toDTO(User user){
        return new UserDto().builder()
                .id(user.getId())
                .name(user.getName())
                .number(user.getNumber())
                .email(user.getEmail())
                .gender(user.getGender())
                .type(user.getType())
                .accountNumber(user.getAccountNumber())
                .cinic(user.getCinic())
                .address(user.getAddress())
                .build();
    }

    public List<UserDto> getAllUser() {
        List<UserDto> userDtos = new ArrayList<>();
        for(User user: userRepo.findAll()){
            userDtos.add(toDTO(user));
        }
        return userDtos;
    }

    public UserDto getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()){
            return toDTO(user.get());
        }
        return  null;
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    public void updateUser(UserDto userDto) {
        userRepo.save(toDO(userDto));
    }
}
