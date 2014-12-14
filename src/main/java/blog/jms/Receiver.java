package blog.jms;

import blog.domain.Article;
import blog.service.repository.ArticleRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileSystemUtils;

import java.io.File;

/**
 * Created by jamesRMBP on 12/12/14.
 */
public class Receiver {

    private Logger log = Logger.getLogger(Receiver.class);

    @Autowired
    private ArticleRepository articleRepository;

    //recive methode
    public void receiveMessage(String articleID) {

        log.info(articleID);


        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
}
