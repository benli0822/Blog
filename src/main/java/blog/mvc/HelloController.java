package blog.mvc;

/**
 * Created by JIN Benli on 15/12/14.
 */

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
@RequestMapping("/facebook")
public class HelloController {

    private Facebook facebook;

    @Inject
    public HelloController(Facebook facebook) {
        this.facebook = facebook;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String helloFacebook(Model model) {
        if (!facebook.isAuthorized()) {
            return "redirect:/view/facebook";
        }

        model.addAttribute(facebook.userOperations().getUserProfile());
        PagedList<Post> homeFeed = facebook.feedOperations().getHomeFeed();
        model.addAttribute("feed", homeFeed);

        return "view/hello";
    }

}