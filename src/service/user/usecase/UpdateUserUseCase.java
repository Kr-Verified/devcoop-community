package service.user.usecase;

import domain.user.UserEntity;
import domain.user.UserRepository;
import service.user.dto.request.UserFullRequest;

public class UpdateUserUseCase {

    private UserRepository userRepository;

    public UpdateUserUseCase(UserRepository repository) {
        this.userRepository = repository;
    }

    public void update(UserFullRequest request, Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (userRepository.findByUsername(request.username()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (request.password().length() < 6) {
            throw new IllegalArgumentException("Password too short");
        }

        UserEntity newUserEntity = request.toEntity();
        newUserEntity.setUserId(userId);

        userRepository.update(newUserEntity);
    }
}
