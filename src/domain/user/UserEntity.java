package domain.user;

public class UserEntity {
    /**
     * Value
     */
    private Long userId;
    private String userName;
    private String password;


    /**
     * Constructor
     */
    public UserEntity() {}

    public UserEntity(Long userId) {
        this.userId = userId;
    }

    public UserEntity(String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public UserEntity(Long userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }


    /**
     * Getter
     */
    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    /**
     * Setter
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
