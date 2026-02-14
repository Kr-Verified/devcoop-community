package service.user.usecase;

import domain.user.UserEntity;
import domain.user.UserRepository;
import service.user.dto.request.UserFullRequest;
import service.user.dto.response.UserIdResponse;

public class CreateUserUseCase {

    private UserRepository userRepository;

    public CreateUserUseCase(UserRepository repository) {
        this.userRepository = repository;
    }

    public UserIdResponse create(UserFullRequest request) {
        UserEntity userEntity = userRepository.save(request.toEntity())
                .orElseThrow(() -> new IllegalArgumentException("Cannot create new user"));

        return UserIdResponse.from(userEntity);
    }
}
