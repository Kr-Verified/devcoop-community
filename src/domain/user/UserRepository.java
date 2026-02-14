package domain.user;

import java.util.Optional;

public interface UserRepository {
    /**
     * Read
     */
    Optional<UserEntity> findById(Long userId);
    Optional<UserEntity> findByUsername(String username);


    /**
     * Write
     */
    Optional<UserEntity> save(UserEntity user);
    Optional<UserEntity> update(UserEntity user);
    void deleteById(Long userId);
}
