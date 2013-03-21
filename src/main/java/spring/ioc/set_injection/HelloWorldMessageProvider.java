package spring.ioc.set_injection;

import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-17
 * Time: 下午2:47
 * To change this template use File | Settings | File Templates.
 */
@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider{
    private String name;
    public String getMessage() {
        return " Hello World";
    }
}
