package service.user.dto.request;

import domain.user.UserEntity;

public record UserFullRequest(
        String username,
        String password
) {
    public UserEntity toEntity() {
        return new UserEntity(this.username, this.password);
    }
}
