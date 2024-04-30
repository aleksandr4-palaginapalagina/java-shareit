package ru.practicum.shareit.user;


import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUser(User user);

    List<User> getAll();

    User getUserById(int id);

    User deleteUser(int id);
}
