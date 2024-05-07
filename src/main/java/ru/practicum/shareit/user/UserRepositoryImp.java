package ru.practicum.shareit.user;

import org.springframework.stereotype.Repository;
import ru.practicum.shareit.exception.NotFoundException;

import java.util.*;

@Repository
public class UserRepositoryImp implements UserRepository {

    private Map<Integer, User> userRepo = new HashMap<>();
    private int generateId = 0;

    @Override
    public User create(User user) {
        user.setId(++generateId);
        userRepo.put(user.getId(), user);
        return user;
    }

    @Override
    public User update(User user) {
        if (!userRepo.containsKey(user.getId())) {
            throw new NotFoundException("Не найден айди " + user.getId());
        }
        User uesrFromRepo = userRepo.get(user.getId());
        System.out.println(user.getName());
        if (user.getName() != null) {
            uesrFromRepo.setName(user.getName());
        }
        System.out.println(user.getEmail());
        if (user.getEmail() != null) {
            for (User userInRepo : userRepo.values()) {
                if (userInRepo.getEmail().equals(user.getEmail()) && userInRepo.getId() != user.getId()) {
                    throw new RuntimeException("email занят");
                }
            }
            uesrFromRepo.setEmail(user.getEmail());
        }
        System.out.println(uesrFromRepo);
        userRepo.put(user.getId(), uesrFromRepo);
        return uesrFromRepo;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(userRepo.values());
    }

    @Override
    public User delete(int id) {
        if (!userRepo.containsKey(id)) {
            throw new NotFoundException("Не найден айди " + id);
        }
        User user = userRepo.get(id);
        userRepo.remove(id, user);
        return user;
    }

    @Override
    public User get(int id) {
        if (!userRepo.containsKey(id)) {
            throw new NotFoundException("Не найден айди " + id);
        }
        return userRepo.get(id);
    }


}
