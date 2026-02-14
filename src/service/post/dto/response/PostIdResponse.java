package service.post.dto.response;

import domain.post.PostEntity;

public record PostIdResponse(
        Long postId
) {
    public static PostIdResponse from(PostEntity postEntity) {
        return new PostIdResponse(postEntity.getPostId());
    }
}
