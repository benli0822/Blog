package blog.service;

import blog.domain.User;

import java.util.HashMap;

/**
 * Created by JIN Benli on 01/12/14.
 */
public interface UserService {
    /* Find user */
    public User findUserByArticle(long aid);

    /* User CRUD */
    public User createUser(String username, String password, String email);

    //TODO maybe not necessary
    public User readUser(long uid);

    public User updateUser(HashMap<String, String> values);

    public boolean deleteUser(long uid);
}
