package blog.service.repository;

import blog.domain.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jamesRMBP on 14/12/14.
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {

}
