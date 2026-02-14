package service.user.usecase;

import domain.user.UserEntity;
import domain.user.UserRepository;
import service.user.dto.request.UsernameRequest;

public class DeleteUserUseCase {

    private UserRepository userRepository;

    public DeleteUserUseCase(UserRepository repository) {
        this.userRepository = repository;
    }

    public void delete(UsernameRequest request) {
        UserEntity userEntity = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new IllegalArgumentException("Username " + request.username() + " not found"));

        userRepository.deleteById(userEntity.getUserId());
    }
}
