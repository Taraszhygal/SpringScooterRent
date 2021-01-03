package com.test.repository;

import com.test.dto.UserDTO;
import com.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserById(Long id);
    User findUserByMail(String mail);
}
