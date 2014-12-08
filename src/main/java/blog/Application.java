package blog;

import blog.domain.Article;
import blog.domain.User;
import blog.service.repository.ArticleRepository;
import blog.service.repository.UserRepository;
import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by JIN Benli on 17/11/14.
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        ArticleRepository articleRepository = context.getBean(ArticleRepository.class);
        UserRepository userRepository = context.getBean(UserRepository.class);
        Article articleTest = new Article();
        User userTest = new User();

        userTest.setUsername("lemattmatt");
        userTest.setPassword("ml");
        userTest.setFirstname("Lecomte");
        userTest.setLastname("Matthieu");
        userTest.setEmail("lemattmatt@hotmail.fr");
        userTest.setFacebook("lemattmatt");
        userTest.setTwitter("lemattmatt");

        userRepository.save(userTest);

        articleTest.setAuthor(userTest);
        articleTest.setTitle("Premier essai d'article");
        articleTest.setContent("C'est mon premier article de blog et j'espère que ca ne sera pas le dernier :p");

        articleRepository.save(articleTest);

        User admin = new User();

        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setFirstname("admin");
        admin.setLastname("admin");
        admin.setEmail("admin");
        admin.setTwitter("admin");
        admin.setFacebook("admin");

        userRepository.save(admin);

    }

    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }

}