package service.post.dto.response;

import domain.post.PostEntity;

import java.time.LocalDateTime;

public record PostFullResponse(
        Long postId,
        String username,
        String title,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static PostFullResponse of(PostEntity postEntity) {
        return new PostFullResponse(
                postEntity.getPostId(),
                postEntity.getUsername(),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getCreatedAt(),
                postEntity.getUpdatedAt()
        );
    }
}
