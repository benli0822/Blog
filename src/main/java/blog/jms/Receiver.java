package blog.jms;

import blog.domain.Article;
import blog.service.EmailService;
import blog.service.repository.ArticleRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.util.FileSystemUtils;


import java.io.File;

/** Message recevier
 * Created by jamesRMBP on 12/12/14.
 */
public class Receiver {

    private Logger log = Logger.getLogger(Receiver.class);

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    ConfigurableApplicationContext context;


    //recive methode
    public void receiveMessage(String articleID) {

        log.info(articleID);
        long a_id = Long.valueOf(articleID);

        Article article = articleRepository.findOne(a_id);

        EmailService emailService = new EmailService(article.getContent(),article.getTitle());

        emailService.sendSimpleMailMessage();

        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
}
