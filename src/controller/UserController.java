package controller;

import service.user.dto.request.UserFullRequest;
import service.user.dto.request.UsernameRequest;
import service.user.dto.response.UserFullResponse;
import service.user.dto.response.UserIdResponse;
import service.user.usecase.*;

public class UserController {

    private CreateUserUseCase createUserUseCase;
    private UpdateUserUseCase updateUserUseCase;
    private DeleteUserUseCase deleteUserUseCase;
    private GetUserUseCase getUserUseCase;
    private CheckUserUseCase checkUserUseCase;

    public UserController(
            CreateUserUseCase createUserUseCase,
            UpdateUserUseCase updateUserUseCase,
            DeleteUserUseCase deleteUserUseCase,
            GetUserUseCase getUserUseCase,
            CheckUserUseCase checkUserUseCase
    ) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.getUserUseCase = getUserUseCase;
        this.checkUserUseCase = checkUserUseCase;
    }

    public UserIdResponse signUp(String username, String password) {
        UserFullRequest request = new UserFullRequest(username, password);

        UserIdResponse response = createUserUseCase.create(request);

        return response;
    }

    public UserIdResponse login(String username, String password) {
        UserFullRequest request = new UserFullRequest(username, password);

        UserIdResponse response = checkUserUseCase.check(request);

        return response;
    }

    public UserFullResponse getUser(String username) {
        UsernameRequest request = new UsernameRequest(username);

        UserFullResponse response = getUserUseCase.get(request);

        return response;
    }

    public void updateUser(Long userId, String username, String password) {
        UserFullRequest request = new UserFullRequest(username, password);

        updateUserUseCase.update(request, userId);
    }

    public void deleteUser(String username) {
        UsernameRequest request = new UsernameRequest(username);

        deleteUserUseCase.delete(request);
    }
}
