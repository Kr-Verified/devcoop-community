package domain.post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    /**
     * Read
     */
    Optional<PostEntity> findById(Long postId);
    Optional<PostEntity> findByUsername(String username);
    List<PostEntity> findAllByTitle(String title, Long page, Long size);
    List<PostEntity> findAllByUsername(String username, Long page, Long size);
    List<PostEntity> findAll(Long page, Long size);


    /**
     * Write
     */
    Optional<PostEntity> save(PostEntity post);
    Optional<PostEntity> update(PostEntity post);
    void deleteById(Long postId);
}
