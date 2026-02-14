package controller;

import service.post.dto.request.PostFullRequest;
import service.post.dto.request.PostIdRequest;
import service.post.dto.response.PostFullListResponse;
import service.post.dto.response.PostFullResponse;
import service.post.dto.response.PostIdResponse;
import service.post.usecase.*;

public class PostController {

    private CreatePostUseCase createPostUseCase;
    private DeletePostUseCase deletePostUseCase;
    private UpdatePostUseCase updatePostUseCase;
    private GetPostUseCase getPostUseCase;
    private GetPostListUseCase getPostListUseCase;

    public PostController(
            CreatePostUseCase createPostUseCase,
            DeletePostUseCase deletePostUseCase,
            UpdatePostUseCase updatePostUseCase,
            GetPostListUseCase getPostListUseCase,
            GetPostUseCase getPostUseCase
    ) {
        this.createPostUseCase = createPostUseCase;
        this.deletePostUseCase = deletePostUseCase;
        this.updatePostUseCase = updatePostUseCase;
        this.getPostListUseCase = getPostListUseCase;
        this.getPostUseCase = getPostUseCase;
    }

    public PostIdResponse post(String username, String title, String content) {
        PostFullRequest request = new PostFullRequest(title, content);

        PostIdResponse response = createPostUseCase.create(request, username);

        return response;
    }

    public void deletePost(String username, Long postId) {
        deletePostUseCase.delete(postId, username);
    }

    public void updatePost(String username, Long postId, String title, String content) {
        PostFullRequest request = new PostFullRequest(title, content);

        updatePostUseCase.update(request, postId, username);
    }

    public PostFullResponse getPost(Long postId) {
        PostIdRequest request = new PostIdRequest(postId);

        PostFullResponse response = getPostUseCase.getById(request);

        return response;
    }

    public PostFullListResponse getAllPostList(Long page, Long size) {
        PostFullListResponse response = getPostListUseCase.getAllList(page, size);

        return response;
    }

    public PostFullListResponse getPostListByTitle(String title, Long page, Long size) {
        PostFullListResponse response = getPostListUseCase.getAllByTitle(title, page, size);

        return response;
    }

    public PostFullListResponse getPostListByUsername(String username, Long page, Long size) {
        PostFullListResponse response = getPostListUseCase.getAllByUsername(username, page, size);

        return response;
    }
}
