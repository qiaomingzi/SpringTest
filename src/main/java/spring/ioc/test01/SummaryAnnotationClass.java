package spring.ioc.test01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-7-12
 * Time: обнГ3:51
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class SummaryAnnotationClass {
    @Bean
    public Summary getGameSummary(){
        Summary summary = new Summary();
        summary.setServerChoice("lmz");
        return summary;
    }
}
