package blog.rest;

import blog.domain.Comment;
import blog.service.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jamesRMBP on 14/12/14.
 */
@Controller
@RequestMapping("/api/comment")
public class CommentRestController {
    @Autowired
    private CommentRepository commentRepository;

    /**
     *  get all comments
     * @return
     */
    @RequestMapping(value = "/getAllComments", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Comment> getAll() {
        return (List<Comment>) commentRepository.findAll();
    }
}
