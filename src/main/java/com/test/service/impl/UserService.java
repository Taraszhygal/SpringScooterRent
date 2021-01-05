package com.test.service.impl;

import com.test.dto.UserDTO;
import com.test.entity.User;
import com.test.exeption.ServiceException;
import com.test.mapper.UserMapper;
import com.test.repository.UserRepository;
import com.test.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getUserById(Long id) {
        User userById = userRepository.findUserById(id);
        return userMapper.toDTO(userById);
    }

    @Override
    public UserDTO getUserByMail(String mail) {
        User userByMail = userRepository.findUserByMail(mail);
        return userMapper.toDTO(userByMail);
    }

    @Override
    public List<UserDTO> saveUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        userRepository.save(user);
        return getAll();
    }

    @Override
    public List<UserDTO> deleteUser(Long id) {
        userRepository.deleteById(id);
        return getAll();
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> all = userRepository.findAll();
        if(all.isEmpty()){
            throw new ServiceException(400, "There aren`t users", null);
        }
        return all.stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) {
        User user = userMapper.toEntity(userDTO);
        User updatedUser = userRepository.findUserById(id);
        if (updatedUser != null && id != 0) {
            updatedUser.setPhoneNumber(user.getPhoneNumber());
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setMail(user.getMail());
            updatedUser.setPassword(user.getPassword());
            userRepository.save(updatedUser);
            userDTO = userMapper.toDTO(updatedUser);
            return userDTO;
        } else {
            throw new ServiceException(400, "User should have an id and exist", null);
        }

    }

}
