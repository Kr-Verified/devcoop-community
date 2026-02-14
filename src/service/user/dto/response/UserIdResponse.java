package service.user.dto.response;

import domain.user.UserEntity;

public record UserIdResponse(
        Long userId
) {
    public static UserIdResponse from(UserEntity userEntity) {
        return new UserIdResponse(userEntity.getUserId());
    }
}
