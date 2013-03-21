package spring.ioc.test01;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-12
 * Time: обнГ3:49
 * To change this template use File | Settings | File Templates.
 */
public class Summary {
    private String serverChoice;

    public Summary(){}


    public String getServerChoice() { return serverChoice; }
    public void setServerChoice(String serverChoice) {
        this.serverChoice = serverChoice;
    }

    public String toString() {
        return Thread.currentThread().getName()+"_"+serverChoice;
    }
}
