package blog.jms;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/** Message Creator customer class
 * Created by jamesRMBP on 14/12/14.
 */
public class myMessageCreator implements MessageCreator {

    String message;

    /**
     *
     * @param message in our case, the message is the id of article
     */
    public myMessageCreator(String message) {
        this.message = message;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage(message);
    }
}
