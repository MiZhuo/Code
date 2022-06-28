package fun.mizhuo.mailserver.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: Mizhuo
 * @time: 2020/10/19 10:00 下午
 * @description: rabbitMq队列
 */
@Component
public class MqQueue {
    @Bean
    Queue queue(){
        return new Queue("mizhuo.mail");
    }
}
