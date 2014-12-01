package blog.service.repository;

import blog.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 01/12/14.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    public List<User> findUserByUsername(String username);

    public List<User> findUserByEmail(String email);
}
