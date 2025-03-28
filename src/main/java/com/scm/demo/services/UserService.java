package com.scm.demo.services;

import com.scm.demo.entities.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    Optional<User> getUserById(String id);

    Optional<User> updateUser(User user);

    void deleteUser(String id);

    boolean isUserExists(String id);

    boolean isUserExistsByEmail(String email);

    List<User> getAllUsers();

}
