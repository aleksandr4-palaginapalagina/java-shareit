package ru.practicum.shareit.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepositoryImp userRepositoryImp;

    @Override
    public User createUser(User user) {
        validationDublicate(userRepositoryImp.getAll(), user);
        return userRepositoryImp.create(user);

    }

    @Override
    public User updateUser(User user) {

        return userRepositoryImp.update(user);

    }

    @Override
    public List<User> getAll() {
        return userRepositoryImp.getAll();


    }

    @Override
    public User getUserById(int id) {
        return userRepositoryImp.get(id);
    }

    @Override
    public User deleteUser(int id) {
        User user = userRepositoryImp.delete(id);
        return user;
    }

    private void validationDublicate(List<User> userList, User user) {
        for (User userInList : userList) {
            if (userInList.getName().equals(user.getName()) || userInList.getEmail().equals(user.getEmail())) {
                throw new RuntimeException("Такой пользователь уже есть");
            }
        }
    }
}
