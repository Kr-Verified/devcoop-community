package service.post.usecase;

import domain.post.PostEntity;
import domain.post.PostRepository;
import service.post.dto.request.PostFullRequest;

public class UpdatePostUseCase {

    private PostRepository postRepository;

    public UpdatePostUseCase(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void update(PostFullRequest request, Long postId, String username) {
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        if (!postEntity.getUsername().equals(username)) {
            throw new IllegalArgumentException("Permission denied");
        }

        PostEntity newPostEntity = request.toEntity(username);
        newPostEntity.setPostId(postId);

        postRepository.update(newPostEntity);
    }
}
