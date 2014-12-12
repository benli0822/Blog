package blog.service;

import blog.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.HashMap;

/**
 * User service implements UserDetailsService to integrate in Authentication module
 * Created by JIN Benli on 01/12/14.
 */
public interface UserService extends UserDetailsService {
    /* Find user */
    public User findUserByArticle(long aid);

    /* User CRUD */
    public User createUser(String username, String password, String email);

    //TODO maybe not necessary
    public User readUser(long uid);

    public User updateUser(long uid, HashMap<String, String> values);

    public void deleteUser(long uid);
}
