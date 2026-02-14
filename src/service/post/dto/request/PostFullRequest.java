package service.post.dto.request;

import domain.post.PostEntity;

public record PostFullRequest(
        String title,
        String content
) {
    public PostEntity toEntity( String username) {
        return new PostEntity(username, title, content);
    }
}
