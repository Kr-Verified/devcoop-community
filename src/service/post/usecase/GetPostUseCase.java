package service.post.usecase;

import domain.post.PostEntity;
import domain.post.PostRepository;
import service.post.dto.request.PostIdRequest;
import service.post.dto.response.PostFullResponse;

public class GetPostUseCase {

    private PostRepository postRepository;

    public GetPostUseCase(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostFullResponse getById(PostIdRequest request) {
        PostEntity postEntity = postRepository.findById(request.postId())
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        return PostFullResponse.of(postEntity);
    }
}
