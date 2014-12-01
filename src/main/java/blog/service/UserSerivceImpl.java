package blog.service;

import blog.Application;
import blog.domain.Article;
import blog.domain.User;
import blog.service.repository.ArticleRepository;
import blog.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by JIN Benli on 01/12/14.
 */
@Component("userService")
@Import(Application.class)
public class UserSerivceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public User findUserByArticle(long aid) {
        Article article = articleRepository.findOne(aid);
        return article.getAuthor();
    }

    @Override
    public User createUser(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return userRepository.save(user);
    }

    @Override
    public User readUser(long uid) {
        return userRepository.findOne(uid);
    }

    @Override
    public User updateUser(long uid, HashMap<String, String> values) {
        User user = userRepository.findOne(uid);
        for(String key : values.keySet()) {
            String value = values.get(key);

            if(value.equals("firstname")) {
                user.setFirstname(value);
            } else if (value.equals("lastname")) {
                user.setLastname(value);
            } else if (value.equals("email")) {
                user.setEmail(value);
            } else if (value.equals("facebook")) {
                user.setFacebook(value);
            } else if (value.equals("twitter")) {
                user.setTwitter(value);
            } else if (value.equals("password")) {
                user.setPassword(value);
            } else {
                //TODO case handler
            }
        }

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(long uid) {
        userRepository.delete(uid);
    }
}
