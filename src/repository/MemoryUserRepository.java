package repository;

import domain.user.UserEntity;
import domain.user.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryUserRepository implements UserRepository {

    private final Map<Long, UserEntity> users = new HashMap<>();
    private Long userCount = 0L;

    @Override
    public Optional<UserEntity> findById(Long userId) {
        return Optional.ofNullable(users.get(userId));
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return users.values().stream().filter(userEntity -> userEntity.getUserName().equals(username)).findFirst();
    }

    @Override
    public Optional<UserEntity> save(UserEntity user) {
        user.setUserId(userCount);
        users.put(userCount++, user);

        return Optional.of(user);
    }

    @Override
    public Optional<UserEntity> update(UserEntity user) {
        UserEntity userEntity = users.get(user.getUserId());

        if (userEntity == null) {
            throw new IllegalArgumentException("User not found"); // 새로운 exception
        }

        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());

        return Optional.of(userEntity);
    }

    @Override
    public void deleteById(Long userId) {
        users.remove(userId);
    }
}
