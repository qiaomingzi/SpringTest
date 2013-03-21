package spring.ioc.set_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-17
 * Time: 下午2:48
 * To change this template use File | Settings | File Templates.
 */
@Service("messageRender")
public class StandardOutMessageRender implements MessageRender {
    private MessageProvider messageProvider;
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + StandardOutMessageRender.class.getName());
        }
        System.out.println(this.messageProvider.getMessage());
    }

    @Autowired //注入
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
