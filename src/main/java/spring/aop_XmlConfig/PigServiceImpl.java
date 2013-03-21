package spring.aop_XmlConfig;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-6-26
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */
public class PigServiceImpl implements AnimalService{
    protected   Log logger = LogFactory.getLog(getClass());
    public void speak(String language) {
        logger.debug(getClass() +" sleep .....");
    }

    public String sleep() {
        logger.debug(getClass() +" start fall in sleep .....");
        System.out.println("--->");
        return "fall in sleep";
    }
    public void eat(){
        logger.debug(getClass() + " eat something");
    }
}
