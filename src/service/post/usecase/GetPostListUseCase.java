package service.post.usecase;

import domain.post.PostEntity;
import domain.post.PostRepository;
import service.post.dto.response.PostFullListResponse;
import service.post.dto.response.PostFullResponse;

import java.util.ArrayList;
import java.util.List;

public class GetPostListUseCase {

    private PostRepository postRepository;

    public GetPostListUseCase(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostFullListResponse getAllList(Long page, Long size) {
        List<PostEntity> postEntityList = postRepository.findAll(page, size);

        List<PostFullResponse> postFullListResponseList = postEntityList.stream().map(PostFullResponse::of).toList();

        postFullListResponseList.sort((postA, postB) -> postA.updatedAt().compareTo(postB.updatedAt()));

        return PostFullListResponse.of(postFullListResponseList);
    }

    public PostFullListResponse getAllByTitle(String title, Long page, Long size) {
        List<PostEntity> postEntityList = postRepository.findAllByTitle(title, page, size);

        List<PostFullResponse> postFullListResponseList = postEntityList.stream().map(PostFullResponse::of).toList();

        return PostFullListResponse.of(postFullListResponseList);
    }

    public PostFullListResponse getAllByUsername(String username, Long page, Long size) {
        List<PostEntity> postEntityList = postRepository.findAllByUsername(username, page, size);

        List<PostFullResponse> postFullListResponseList = postEntityList.stream().map(PostFullResponse::of).toList();

        return PostFullListResponse.of(postFullListResponseList);
    }
}
