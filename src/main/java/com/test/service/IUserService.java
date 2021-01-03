package com.test.service;

import com.test.dto.UserDTO;

import java.util.List;

public interface IUserService {
    UserDTO getUserById(Long id);
    UserDTO getUserByMail(String mail);
    List<UserDTO> saveUser(UserDTO userDTO);
    List<UserDTO> deleteUser(Long id);
    List<UserDTO> getAll();
    UserDTO updateUser(UserDTO userDTO, Long id);

}
