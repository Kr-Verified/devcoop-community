package domain.post;

import java.time.LocalDateTime;

public class PostEntity {
    /**
     * Value
     */
    private Long postId;
    private String username;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long views;


    /**
     * Constructor
     */
    public PostEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.views = 0L;
    }

    public PostEntity(Long postId, String username) {
        this();
        this.postId = postId;
        this.username = username;
    }

    public PostEntity(String username, String title, String content) {
        this();
        this.username = username;
        this.title = title;
        this.content = content;
    }


    /**
     * Getter
     */
    public Long getPostId() {
        return postId;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Long getViews() {
        return views;
    }


    /**
     * Setter
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setViews(Long views) {
        this.views = views;
    }
}
