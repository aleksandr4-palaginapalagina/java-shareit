package ru.practicum.shareit.user;

import java.util.List;

public interface UserRepository {

    User create(User user);

    User update(User user);

    List<User> getAll();

    User delete(int id);

    User get(int id);
}
