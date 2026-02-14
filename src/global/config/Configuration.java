package global.config;

import controller.PostController;
import controller.UserController;
import domain.post.PostRepository;
import domain.user.UserRepository;
import repository.MemoryPostRepository;
import repository.MemoryUserRepository;
import service.post.usecase.*;
import service.user.usecase.*;

public class Configuration {

    private static UserRepository userRepository = new MemoryUserRepository();
    private static PostRepository postRepository = new MemoryPostRepository();

    private static CheckUserUseCase checkUserUseCase = new CheckUserUseCase(userRepository);
    private static CreateUserUseCase createUserUseCase = new CreateUserUseCase(userRepository);
    private static DeleteUserUseCase deleteUserUseCase = new DeleteUserUseCase(userRepository);
    private static GetUserUseCase getUserUseCase = new GetUserUseCase(userRepository);
    private static UpdateUserUseCase updateUserUseCase = new UpdateUserUseCase(userRepository);

    private static CreatePostUseCase createPostUseCase = new CreatePostUseCase(postRepository);
    private static DeletePostUseCase deletePostUseCase = new DeletePostUseCase(postRepository);
    private static GetPostUseCase getPostUseCase = new GetPostUseCase(postRepository);
    private static UpdatePostUseCase updatePostUseCase = new UpdatePostUseCase(postRepository);
    private static GetPostListUseCase getPostListUseCase = new GetPostListUseCase(postRepository);

    private static UserController userController = new UserController(createUserUseCase, updateUserUseCase, deleteUserUseCase, getUserUseCase, checkUserUseCase);
    private static PostController postController = new PostController(createPostUseCase, deletePostUseCase, updatePostUseCase, getPostListUseCase, getPostUseCase);

    public static UserController getUserController() {
        return userController;
    }

    public static PostController getPostController() {
        return postController;
    }
}
