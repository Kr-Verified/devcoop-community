package service.user.dto.response;

import domain.user.UserEntity;

public record UserFullResponse(
        Long userId,
        String username,
        String password
) {
    public static UserFullResponse from(UserEntity userEntity) {
        return new UserFullResponse(userEntity.getUserId(), userEntity.getUserName(), userEntity.getPassword());
    }
}
