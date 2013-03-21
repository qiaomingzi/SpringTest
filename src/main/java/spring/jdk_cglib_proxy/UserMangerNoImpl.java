package spring.jdk_cglib_proxy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-8
 * Time: обнГ4:53
 * To change this template use File | Settings | File Templates.
 */
public class UserMangerNoImpl implements UserManager{
    private Log log = LogFactory.getLog(this.getClass());
    public void save(){
        System.out.println("--- execute save method ---");
    }
}
