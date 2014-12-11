package blog.service.repository;

import blog.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Created by jamesRMBP on 01/12/14.
 */
public interface CategoryRepository extends CrudRepository<Category, Long>{
    List<Category> findCategoryByDescription(String description);
}
