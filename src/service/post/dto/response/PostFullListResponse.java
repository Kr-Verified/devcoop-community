package service.post.dto.response;

import java.util.List;

public record PostFullListResponse(
        Long posts,
        List<PostFullResponse> postFullList
) {
    public static PostFullListResponse of(List<PostFullResponse> postFullList) {
        return new PostFullListResponse(Long.valueOf(postFullList.size()), postFullList);
    }
}
