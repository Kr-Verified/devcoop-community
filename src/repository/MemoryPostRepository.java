package repository;

import domain.post.PostEntity;
import domain.post.PostRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryPostRepository implements PostRepository {

    private final Map<Long, PostEntity> posts = new HashMap<>();
    private Long postCount = 0L;

    @Override
    public Optional<PostEntity> findById(Long postId) {
        return Optional.ofNullable(posts.get(postId));
    }

    @Override
    public Optional<PostEntity> findByUsername(String username) {
        return posts.values().stream().filter(postEntity -> postEntity.getUsername().equals(username)).findFirst();
    }

    @Override
    public List<PostEntity> findAllByTitle(String title, Long page, Long size) {
        return posts.values().stream().filter(postEntity -> postEntity.getTitle().equals(title)).toList()
                .subList(page.intValue()*size.intValue(), (page.intValue()+1)*size.intValue());
    }

    @Override
    public List<PostEntity> findAllByUsername(String username, Long page, Long size) {
        return posts.values().stream().filter(postEntity -> postEntity.getUsername().equals(username)).toList()
                .subList(page.intValue()*size.intValue(), (page.intValue()+1)*size.intValue());
    }

    @Override
    public List<PostEntity> findAll(Long page, Long size) {
        return posts.values().stream().toList().subList(page.intValue()*size.intValue(), (page.intValue()+1)*size.intValue());
    }

    @Override
    public Optional<PostEntity> save(PostEntity post) {
        post.setPostId(postCount);
        posts.put(postCount++, post);

        return Optional.of(post);
    }

    @Override
    public Optional<PostEntity> update(PostEntity post) {
        PostEntity postEntity = posts.get(post.getPostId());

        if (postEntity == null) {
            throw new IllegalArgumentException("post id not found");
        }

        postEntity.setTitle(post.getTitle());
        postEntity.setContent(post.getContent());
        postEntity.setUpdatedAt(post.getUpdatedAt());
        postEntity.setViews(post.getViews());

        return Optional.of(postEntity);
    }

    @Override
    public void deleteById(Long postId) {
        posts.remove(postId);
    }
}
