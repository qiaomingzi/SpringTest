package spring.ioc.constructor_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring.ioc.set_injection.MessageProvider;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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


    @Value("李明梓")
    private String name;

    @Resource(name="map")
    private Map  map;

    @Resource(name="props")
    private Properties props;

    @Resource(name="set")
    private Set set;

    @Resource(name="list")
    private List list;



    public void setName(String name) {
        this.name = name;
    }



    public void setMap(Map map) {
        this.map = map;
    }


    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }


    public void setList(List list) {
        this.list = list;
    }

    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + StandardOutMessageRender.class.getName());
        }
        System.out.println(this.messageProvider.getMessage());
        System.out.println("name :"+this.name);
        System.out.println("list :"+this.list);
        System.out.println("map :"+this.map);

        if (props != null)
            for (Map.Entry<Object, Object> entry: props.entrySet()) {
                System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
            }

        // display the set
        System.out.println("\nSet contents:\n");
        if (set != null)
            for (Object obj: set) {
                System.out.println("Value: " + obj);
            }
    }

    @Autowired //注入
    public StandardOutMessageRender(MessageProvider messageProvider){
        this.messageProvider = messageProvider;
    }
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
