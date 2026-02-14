package service.user.usecase;

import domain.user.UserEntity;
import domain.user.UserRepository;
import service.user.dto.request.UserFullRequest;
import service.user.dto.response.UserIdResponse;

public class CheckUserUseCase {

    private UserRepository userRepository;

    public CheckUserUseCase(UserRepository repository) {
        this.userRepository = repository;
    }

    public UserIdResponse check(UserFullRequest request) {
        UserEntity userEntity = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new IllegalArgumentException("Username not found"));

        if (request.password().equals(userEntity.getPassword())) {
            return UserIdResponse.from(userEntity);
        }else {
            throw new IllegalArgumentException("Wrong password");
        }
    }
}
