package spring.ioc.set_injection;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-17
 * Time: 下午2:46
 * To change this template use File | Settings | File Templates.
 */
public interface MessageRender {
    public void render();
    public void setMessageProvider(MessageProvider provider);
    public MessageProvider getMessageProvider();
}
