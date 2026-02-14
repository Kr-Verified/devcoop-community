package service.user.dto.response;

import domain.user.UserEntity;

public record UsernameResponse(
        String username
) {
    public static UsernameResponse from(UserEntity userEntity) {
        return new UsernameResponse(userEntity.getUserName());
    }
}
