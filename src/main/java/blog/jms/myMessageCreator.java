package blog.jms;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by jamesRMBP on 14/12/14.
 */
public class myMessageCreator implements MessageCreator {

    String message;

    public myMessageCreator(String message) {
        this.message = message;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage(message);
    }
}
