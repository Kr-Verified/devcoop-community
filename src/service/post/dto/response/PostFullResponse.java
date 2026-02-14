package service.post.dto.response;

import domain.post.PostEntity;

import java.time.LocalDateTime;

public record PostFullResponse(
        Long postId,
        String username,
        String title,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Long views
) {
    public static PostFullResponse of(PostEntity postEntity, ) {

    }
}
