package blog.jms;

import blog.domain.Article;
import org.apache.log4j.Logger;
import org.springframework.util.FileSystemUtils;

import java.io.File;

/**
 * Created by jamesRMBP on 12/12/14.
 */
public class Receiver {

    private Logger log = Logger.getLogger(Receiver.class);

    public void receiveMessage(Article article) {

        log.info("recevice a message");
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
}
