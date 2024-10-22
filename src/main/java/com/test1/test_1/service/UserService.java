package com.test1.test_1.service;

import com.test1.test_1.dto.UserDTO;
import com.test1.test_1.entity.User;
import com.test1.test_1.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    //save user
    public UserDTO saveUser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    //get all user
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        //map this list object to pass data to dto
        return modelMapper.map(users, new TypeToken<List<UserDTO>>(){}.getType());
    }

    //update user
    public UserDTO updateUser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    //delete user
    public boolean deleteUser(UserDTO userDTO) {
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }

}
