package blog.service;

import blog.Application;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * Created by jamesRMBP on 01/12/14.
 */

@Component(value = "categoryService")
@Import(Application.class)
public class CategoryServiceImpl implements CategoryService {

}
