package blog.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Date;
import java.util.Properties;

/**
 * Created by jamesRMBP on 14/12/14.
 */
public class EmailService {


    private String context;
    private String title;

    public EmailService(String context,String title){
        this.context = context;
        this.title = title;
    }
    private  JavaMailSender createJavaMailSender() {

        Properties properties = new Properties();
        properties.setProperty("mail.debug", "true");//是否显示调试信息(可选)
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.auth", "true");

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setJavaMailProperties(properties);
        javaMailSender.setUsername("helloblogfil@gmail.com");
        javaMailSender.setPassword("helloblogfil123");
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(465);
        javaMailSender.setDefaultEncoding("UTF-8");
        return javaMailSender;
    }


    public  void sendSimpleMailMessage() {
        JavaMailSender javaMailSender = createJavaMailSender();

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("filonyva@gmail.com");//可选的
        mailMessage.setTo("jamescheng16@gmail.com");
        mailMessage.setSubject("Blog notification");
        mailMessage.setText("A new article has created, title :"+ this.title + "  context : " + this.context + new Date());

        javaMailSender.send(mailMessage);
    }

}
