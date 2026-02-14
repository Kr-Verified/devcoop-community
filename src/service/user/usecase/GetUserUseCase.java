package service.user.usecase;

import domain.user.UserEntity;
import domain.user.UserRepository;
import service.user.dto.request.UsernameRequest;
import service.user.dto.response.UserFullResponse;

public class GetUserUseCase {

    private UserRepository userRepository;

    public GetUserUseCase(UserRepository repository) {
        this.userRepository = repository;
    }

    public UserFullResponse get(UsernameRequest request) {
        UserEntity userEntity = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new IllegalArgumentException("Username " + request.username() + " not found"));

        return UserFullResponse.from(userEntity);
    }
}
