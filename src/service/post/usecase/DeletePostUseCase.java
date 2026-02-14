package service.post.usecase;

import domain.post.PostEntity;
import domain.post.PostRepository;

public class DeletePostUseCase {

    private PostRepository postRepository;

    public DeletePostUseCase(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void delete(Long postId, String username) {
        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        if (postEntity.getUsername().equals(username)) {
            postRepository.deleteById(postId);
        }else {
            System.out.println("Permission denied");
        }
    }
}
