package service.post.usecase;

import domain.post.PostEntity;
import domain.post.PostRepository;
import service.post.dto.request.PostFullRequest;
import service.post.dto.response.PostIdResponse;

public class CreatePostUseCase {

    private PostRepository postRepository;

    public CreatePostUseCase(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostIdResponse create(PostFullRequest request, String username) {
        PostEntity postEntity = request.toEntity(username);
        postEntity.setUsername(username);

        postEntity = postRepository.save(postEntity)
                .orElseThrow(() -> new IllegalArgumentException("Cannot create new post"));

        return PostIdResponse.from(postEntity);
    }
}
