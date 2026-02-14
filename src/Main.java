import controller.PostController;
import controller.UserController;
import global.config.Configuration;
import service.post.dto.response.PostFullListResponse;
import service.post.dto.response.PostFullResponse;
import service.post.dto.response.PostIdResponse;
import service.user.dto.response.UserFullResponse;
import service.user.dto.response.UserIdResponse;
import service.user.usecase.*;

import java.util.Scanner;

public class Main {

    private static UserController userController = Configuration.getUserController();
    private static PostController postController = Configuration.getPostController();

    public static void printList(PostFullListResponse response) {
        System.out.println("-------Post List (" + response.posts() + ")--------");
        response.postFullList().forEach(System.out::println);
        System.out.println("---------------------------------------------------");
    }

    public static void main(String[] args) {

        int menu;
        Long userId = -1L;
        String username = "";

        while (true) {
            System.out.println("-------------------");
            System.out.println("1: signUp");
            System.out.println("2: login");
            System.out.println("3: logout");
            System.out.println("4: show user");
            System.out.println("5: change user info");
            System.out.println("6: post list");
            System.out.println("7: search post");
            System.out.println("8: add post");
            System.out.println("9: update post");
            System.out.println("10: delete post");
            System.out.println("-1: exit");
            System.out.println("-------------------");
            System.out.println();
            System.out.print("Enter your choice: ");

            Scanner sc = new Scanner(System.in);
            menu = sc.nextInt();

            if (menu == -1) break;

            if (menu == 1) {
                String inputUsername = "", password;

                System.out.print("Enter username: ");
                username = sc.next();
                System.out.print("Enter password: ");
                password = sc.next();

                UserIdResponse response = userController.signUp(inputUsername, password);
                userId = response.userId();
                username = inputUsername;
                System.out.println("SignUp successful!");
            }else if (menu == 2) {
                String inputUsername = "", password;

                System.out.println("Enter username: ");
                inputUsername = sc.next();
                System.out.print("Enter password: ");
                password = sc.next();

                UserIdResponse response = userController.login(inputUsername, password);
                userId = response.userId();
                username = inputUsername;
                System.out.println("Login successful!");
                System.out.println("Hello " + username + "!");
            }else if (menu == 3) {
                userId = -1L;
                username = "";
                System.out.println("Logout successful!");
            }else if (menu == 4) {
                String inputUsername = "";
                System.out.println("Enter username: ");
                inputUsername = sc.next();

                UserFullResponse response = userController.getUser(inputUsername);
                System.out.println("Username: " + response.username());
                System.out.println("Password: " + response.password());
                System.out.println("UserId: " + response.userId());
            }else if (menu == 5) {
                String inputUsername, password;
                System.out.println("Enter username: ");
                inputUsername = sc.next();
                System.out.print("Enter password: ");
                password = sc.next();

                userController.updateUser(userId, inputUsername, password);
                System.out.println("Username updated successful!");
            }else if (menu == 6) {
                Long page, size;

                System.out.println("Enter page: ");
                page = sc.nextLong();
                System.out.println("Enter size: ");
                size = sc.nextLong();

                System.out.println();
                PostFullListResponse response = postController.getAllPostList(page, size);
                printList(response);
            }else if (menu == 7) {
                Long page, size;

                System.out.println("Enter page: ");
                page = sc.nextLong();
                System.out.println("Enter size: ");
                size = sc.nextLong();
                System.out.println();

                int detailMenu;
                System.out.println("1: Search By Title");
                System.out.println("2: Search By Username");
                System.out.println("3: Search By PostId");
                System.out.println("---------------------");
                System.out.println("Enter detail menu: ");
                detailMenu = sc.nextInt();

                if (detailMenu == 1) {
                    String title;

                    System.out.println("Enter title: ");
                    title = sc.next();

                    PostFullListResponse response = postController.getPostListByTitle(title, page, size);
                    printList(response);
                }else if (detailMenu == 2) {
                    String inputUsername;

                    System.out.println("Enter username: ");
                    inputUsername = sc.next();

                    PostFullListResponse response = postController.getPostListByUsername(inputUsername, page, size);
                    printList(response);
                }else if (detailMenu == 3) {
                    Long postId;

                    System.out.println("Enter post id: ");
                    postId = sc.nextLong();

                    PostFullResponse response = postController.getPost(postId);
                    System.out.println(response);
                }
            }else if (menu == 8) {
                String title, content;

                System.out.println("Enter title: ");
                title = sc.next();
                System.out.println("Enter content: ");
                content = sc.next();

                PostIdResponse response = postController.post(username, title, content);
                System.out.println("Post " + response.postId() + "is posted Successfully!");
            }else if (menu == 9) {
                String title, content;
                Long postId;

                System.out.println("Enter post id: ");
                postId = sc.nextLong();
                System.out.println("Enter title: ");
                title = sc.next();
                System.out.println("Enter content: ");
                content = sc.next();

                postController.updatePost(username, postId, title, content);
                System.out.println("Post " + postId + " is updated successfully!");
            }else if (menu == 10) {
                Long postId;

                System.out.println("Enter post id: ");
                postId = sc.nextLong();

                postController.deletePost(username, postId);
                System.out.println("Post is deleted successfully!");
            }

            System.out.println();
        }
    }
}